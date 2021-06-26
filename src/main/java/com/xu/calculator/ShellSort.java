package com.xu.calculator;

import com.xu.util.SortUtil;

/**
 * java_study
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = DataCheck.generateArr(6);
        SortUtil.print(arr);
        sort(arr);
        SortUtil.print(arr);
    }

    static void sort(int[] arr) {
        int gap = arr.length / 2;
        for (int k = gap; k > 0; k /= 2) {
            for (int i = k; i < arr.length; i++) {
                for (int j = i; j > k - 1; j -= k) {
                    if (arr[j] < arr[j - k]) {
                        SortUtil.swap(arr, j - k, j);
                    }
                }
            }
        }
    }
}
