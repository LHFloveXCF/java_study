package com.xu.util;

/**
 * java_study
 */
public class ArrayUtils {
    public static int[] generate(int len, int max) {
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int value = (int) (Math.random() * max) + 1;
            while (org.apache.commons.lang.ArrayUtils.indexOf(res, value) != -1) {
                value = (int) (Math.random() * max) + 1;
            }
            res[i] = value;
        }
        return res;
    }
}
