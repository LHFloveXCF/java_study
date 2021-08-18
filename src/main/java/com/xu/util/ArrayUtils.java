package com.xu.util;

/**
 * java_study
 */
public class ArrayUtils {
    public static int[] generate(int len, int max) {
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = (int) (Math.random() * max) + 1;
        }
        return res;
    }
}
