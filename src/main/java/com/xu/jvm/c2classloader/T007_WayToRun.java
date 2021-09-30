package com.xu.jvm.c2classloader;

import java.time.Instant;

/**
 * java_study
 */
public class T007_WayToRun {

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            m();
        }
        long start = Instant.now().toEpochMilli();

        for (int i = 0; i < 100000; i++) {
            m();
        }
        long en = Instant.now().toEpochMilli();

        System.out.println(en - start);
    }

    private static void m() {
        for (int i = 0; i < 1000000; i++) {
            int j = i % 3;
        }
    }
}
