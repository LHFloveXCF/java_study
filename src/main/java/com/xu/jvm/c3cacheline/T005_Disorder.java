package com.xu.jvm.c3cacheline;

/**
 * java_study
 */
public class T005_Disorder {
    private static int a = 0, b = 0, x = 0, y = 0;

    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        for (;;) {
            count++;
            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            if (a == 0 && b == 0) {
                System.out.println(count);
                break;
            }
        }
    }
}
