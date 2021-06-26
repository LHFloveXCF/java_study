package com.xu.mca.thread.juc.sync;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * java_study
 * 访问同步方法的时候，依然可以访问非同步方法
 */
public class C01_Sync{
    static synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + "-----m1 start");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        m2();
        System.out.println(Thread.currentThread().getName() + "-----m1 end");
    }

    static void m2() {
        System.out.println("m2  start");
    }

    public static void main(String[] args) {
        new Thread(C01_Sync::m1, "t1").start();
        new Thread(C01_Sync::m2, "t2").start();
        AtomicInteger integer = new AtomicInteger(0);
    }
}
