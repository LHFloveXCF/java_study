package com.xu.util;

import java.util.Arrays;

/**
 * java_study
 */
public class PrintUtils {
    public static void printInt2Arr(int[][] arr) {
        if (null == arr || arr.length < 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
