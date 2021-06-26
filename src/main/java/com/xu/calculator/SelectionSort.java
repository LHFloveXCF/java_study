package com.xu.calculator;

import com.xu.util.SortUtil;

/**
 * java_study
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = DataCheck.generateArr(5);
        SortUtil.print(arr);
        sort(arr);
        SortUtil.print(arr);
    }

    // int[] arr = {2,3,8,5,4,5,4}
    static void sort(int[] arr) {
        for (int i = 0; i<arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                SortUtil.swap(arr, min, i);
            }
        }
    }
}
