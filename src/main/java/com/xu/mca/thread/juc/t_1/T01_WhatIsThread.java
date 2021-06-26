package com.xu.mca.thread.juc.t_1;

/**
 * java_study
 */
public class T01_WhatIsThread {

    private static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i=0; i<5; i++) {
                System.out.println("T1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
//        new MyThread().run();
        new MyThread().start();
        for (int i=0; i<5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }
}
