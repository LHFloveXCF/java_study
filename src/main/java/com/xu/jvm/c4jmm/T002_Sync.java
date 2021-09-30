package com.xu.jvm.c4jmm;

/**
 * java_study
 */
public class T002_Sync {
    synchronized void m() {}

    void n() {
        synchronized (this) {

        }
    }

    public static void main(String[] args) {

    }
}
