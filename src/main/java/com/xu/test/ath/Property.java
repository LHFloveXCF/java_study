package com.xu.test.ath;

import java.util.Date;
import java.util.Properties;

/**
 * java_study
 */
public class Property {
    public static void main(String[] args) {
        System.out.println(new Date());
        Properties properties = System.getProperties();
        properties.list(System.out);
        System.out.println("-------Memory Usage-------");
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Total Memory = " + runtime.totalMemory() + " Free Memory = " + runtime.freeMemory());
    }
}
