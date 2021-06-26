package com.xu.mca.thread.juc.t_1;

/**
 * java_study
 */
public class T01_Sleep_yield_join {
    static void testSleep(){
        new Thread(() ->{
            System.out.println("ready sleep");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello sleep");
        }).start();
    }

    static void testYield(){
        new Thread(() ->{
            Thread.yield();
            System.out.println("ready Yield");
        }).start();

        new Thread(() ->{
            System.out.println("ready Yield2");
            Thread.yield();
        }).start();
    }

    static void testJoin() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ready testJoin");
        });

        Thread thread2 = new Thread(() -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ready testJoin2");
        });

        thread.start();
        thread2.start();
    }

    public static void main(String[] args) {
//        testSleep();
//        testYield();
        testJoin();
    }
}
