package com.xu.jvm.c3cacheline;

/**
 * java_study
 */
public class T001_LoadObject {

    public static void main(String[] args) {
//        System.out.println(P.count);
//        P p = new P();
//        System.out.println(p.detail);
        System.out.println(P.a);
    }

    public static class P {
        public static final int a = 2;
        public static P p = new P();
        public static int count = 2;
        public int detail = 9;

        private P() {
            count++;
            System.out.println(count);
        }
    }
}
