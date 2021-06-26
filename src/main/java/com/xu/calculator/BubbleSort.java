package com.xu.calculator;

import com.xu.util.SortUtil;

/**
 * java_study
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = DataCheck.generateArr(5);
        SortUtil.print(arr);
        sort(arr);
        SortUtil.print(arr);
    }

    static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtil.swap(arr, j + 1, j);
                }
            }
        }
    }
}
