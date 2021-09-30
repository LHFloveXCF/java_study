package com.xu.jvm.c3cacheline;

/**
 * java_study
 */
public class T004_CacheLine {
    private static final int count = 10_0000_0000;
    private static class Padding{
        public static volatile long p1, p2, p3, p4, p5, p6, p7;
    }

    private static class P extends Padding{
        public static volatile long x = 0;
    }

    private static P[] p = new P[2];

    static {
        p[0] = new P();
        p[1] = new P();
    }

    public static void main(String[] args) throws InterruptedException {
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
