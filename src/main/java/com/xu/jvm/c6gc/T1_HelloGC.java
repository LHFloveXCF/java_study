package com.xu.jvm.c6gc;

import java.util.ArrayList;
import java.util.List;

/**
 * java_study
 */
public class T1_HelloGC {
    public static void main(String[] args) {
        List<Integer[]> list = new ArrayList<>();
        for (; ; ) {
            list.add(new Integer[1024 * 1024]);
        }
    }
}
