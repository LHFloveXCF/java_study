package com.xu.jvm.c2classloader;


/**
 * java_study
 */
public class Test_03_Path {
    public static void main(String[] args) {
        String bootClassPath = System.getProperty("sun.boot.class.path");
//        System.out.println(System.lineSeparator());
        System.out.println(bootClassPath.replaceAll(";", System.lineSeparator()));

        System.out.println("----------------------------------------------------------");
        String var2 = System.getProperty("java.class.path");
        System.out.println(var2.replaceAll(";", System.lineSeparator()));
    }
}
