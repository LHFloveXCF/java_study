package com.xu.mca.local.oop;

/**
 * java_study
 */
public class StandardTest {
    public static void main(String[] args) {
        /*System.out.println(StaticTest.NAME);
        StaticTest test = new StaticTest();
        System.out.println(test.NAME);*/
        String str = "102";
        System.out.println(Integer.parseInt(str));
        System.exit(0);
    }
}

class StaticTest{
    public static final String NAME = "hello";

}
