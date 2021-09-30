package com.xu.calculator.l_08.lesson41;

/**
 * java_study
 *
 */
public class Code06_CanIWin {
    private static boolean canIWin(int choose , int total) {
        if (total == 0) {
            return true;
        }
        if ((choose * (choose + 1) >> 1) < total) {
            return false;
        }
        int[] arr = new int[choose];
        for (int i=0; i<choose; i++) {
            arr[i] = i + 1;
        }
        return process(arr, total);
    }

    private static boolean process(int[] arr, int rest) {
        if (rest <= 0) {
            return false;
        }
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != -1) {
                int cur = arr[i];
                arr[i] = -1;
                boolean next = process(arr, rest - cur);
                arr[i] = cur;
                if (!next) {
                    return true;
                }
            }
        }
        return false;
    }

}
