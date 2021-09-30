package com.xu.jvm.c3cacheline;

/**
 * java_study
 */
public class T003_CacheLine {
    private static final int count = 10_0000_0000;
    private static class T {
        public long x;
    }



    public static void main(String[] args) throws InterruptedException {
        T[] p = new T[2];
        p[0] = new T();
        p[1] = new T();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                p[0].x = i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                p[1].x = i;
            }
        });
        long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.nanoTime();
        System.out.println(end - start);
    }

}
