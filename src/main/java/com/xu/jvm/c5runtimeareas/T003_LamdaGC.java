package com.xu.jvm.c5runtimeareas;

/**
 * java_study
 */
public class T003_LamdaGC {

    @FunctionalInterface
    public interface F {
        void f();
    }

    public static class C{
    }

    public static void main(String[] args) {
//        F g = () -> {};
//        System.out.println(g.getClass().getClassLoader());
//        for (;;) {
//            F f = () ->{};
//        }

        for (;;) {
            Object o = new Object();
        }
    }
}
