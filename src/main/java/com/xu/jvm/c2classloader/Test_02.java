package com.xu.jvm.c2classloader;

/**
 * java_study
 */
public class Test_02 {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(Test_02.class.getClassLoader());
        System.out.println(Test_02.class.getClassLoader().getClass().getClassLoader());
    }
}
