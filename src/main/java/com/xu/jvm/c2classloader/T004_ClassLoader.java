package com.xu.jvm.c2classloader;

/**
 * java_study
 */
public class T004_ClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(T004_ClassLoader.class.getClassLoader().loadClass("com.xu.jvm.c2classloader.Test_02").getName());
    }
}
