package com.xu.countdownlatch;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java_study
 */
public class Test_01 {


    static class Print implements Runnable{

        @Override
        public void run() {

        }
    }

    private static char[] data1 = {'1','2','3','4','5','6','7'};
    private static char[] data2 = {'a','b','c','d','e','f','g'};
    static BlockingQueue<String> q1 = new ArrayBlockingQueue<>(1);
    static BlockingQueue<String> q2 = new ArrayBlockingQueue<>(1);
    private static Thread t1,t2;
    private static final Object LOCK = new Object();
    static volatile int id = 1;

    public static void main(String[] args) {
//        p1();
//        p2();
//        p3();
//        p4();
//        p5();
        p6();
    }

    private static void p6() {
        t1 = new Thread(() -> {
            for (char c : data1) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
//            LockSupport.unpark(t1);
        });

        t2 = new Thread(() -> {
            for (char c : data2) {
                LockSupport.unpark(t1);
                System.out.print(c);
                LockSupport.park();
            }
//            LockSupport.unpark(t2);
        });

        t1.start();
        t2.start();
    }

    // volatile关键字操作实现CAS自旋操作
    private static void p5() {
        t1 = new Thread(() -> {
            for (char c : data1) {
                while (id != 1) {

                }
                System.out.print(c);
                id = 2;
            }
        });

        t2 = new Thread(() -> {
            for (char c : data2) {
                while (id != 2) {

                }
                System.out.print(c);
                id = 1;
            }
        });
        t1.start();
        t2.start();
    }

    // 原子类的自旋操作
    private static void p4() {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        t1 = new Thread(() -> {
            for (char c : data1) {
                while (atomicInteger.get() != 1) {
                    // 空转
                }
                System.out.print(c);
                atomicInteger.set(2);
            }
        });

        t2 = new Thread(() -> {
            for (char c : data2) {
                while (atomicInteger.get() != 2) {

                }
                System.out.print(c);
                atomicInteger.set(1);
            }
        });
        t1.start();
        t2.start();
    }


    // lock condition
    private static void p3() {
        Lock lock = new ReentrantLock();
        // 给定两个信号量用来表示两个线程
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        t1 = new Thread(() -> {
            lock.lock();
            for (char c : data1) {
                System.out.print(c);
                try {
                    c2.signal();
                    c1.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            c2.signal();
            lock.unlock();
        });
        t2 = new Thread(() -> {
            lock.lock();
            for (char c : data2) {
                System.out.print(c);
                try {
                    c1.signal();
                    c2.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            c1.signal();
            lock.unlock();
        });
        t2.start();
        t1.start();
    }

    // join / await (synchronized)
    private static void p2() {
        t1 = new Thread(() -> {
            synchronized (LOCK) {
                for (char c : data1) {
                    System.out.print(c);
                    LOCK.notify();
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                LOCK.notify();
            }
        });

        t2 = new Thread(() -> {
            synchronized (LOCK) {
                for (char c : data2) {
                    System.out.print(c);
                    LOCK.notify();
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                LOCK.notify();
            }
        });

        t1.start();
        t2.start();
    }

    // 阻塞队列的实现
    private static void p1() {
        t1 = new Thread(() -> {
            for (char c : data1) {
                System.out.print(c);
                try {
                    q1.put("hello1");
                    q2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2 = new Thread(() -> {
            for (char c : data2) {
                try {
                    q1.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(c);

                try {
                    q2.put("hello2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
