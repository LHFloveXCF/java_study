package com.facetest.basics;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java_study
 * 生产者消费者模型
 * 安全点
 */
public class ProviderAndConsumer<T> {

    // 可重入锁
    private Lock lock = new ReentrantLock();
    // 生产者条件
    private Condition providerCondition = lock.newCondition();
    // 消费者条件
    private Condition consumerCondition = lock.newCondition();

    private Queue<T> pool = new LinkedBlockingDeque<>();

    private static final int maxCount = 10;

    private void produce(T value) {
        Thread thread = new Thread(() -> {
            for (;;) {
                lock.lock();
                try {
                    while (pool.size() >= maxCount) {
                        providerCondition.await();
                    }
                    pool.add(value);
                    System.out.println("生产了" + pool.size());
                    consumerCondition.signal();
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        thread.start();
    }

    private void consume() {
        Thread thread = new Thread(() -> {
            for (;;) {
                lock.lock();
                try {
                    while (pool.isEmpty()) {
                        consumerCondition.await();
                    }
                    pool.poll();
                    System.out.println("消费了" + pool.size());
                    providerCondition.signal();
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        thread.start();
    }

    public void start(T t) {
        produce(t);
        consume();
    }

    public static void main(String[] args) {
        ProviderAndConsumer<Integer> test = new ProviderAndConsumer<>();
        test.start(1);
    }
}
