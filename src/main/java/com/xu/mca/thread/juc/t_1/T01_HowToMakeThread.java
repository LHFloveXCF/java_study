package com.xu.mca.thread.juc.t_1;

/**
 * java_study
 */
public class T01_HowToMakeThread {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("继承了Thread类");
        }
    }

    private static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("实现了Runnable接口");
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new MyThread().start();
        Thread thread = new Thread(new MyRun());
        thread.start();
        new Thread(() -> System.out.println("hello lambda")).start();
    }
}
