package com.xu.calculator;

import com.xu.util.SortUtil;

/**
 * java_study
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = DataCheck.generateArr(5);
        SortUtil.print(arr);
        sort(arr);
        SortUtil.print(arr);
    }

    static void sort(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            for (int j=i; j>0; j--) {
                if (arr[j] < arr[j - 1]) {
                    SortUtil.swap(arr, j - 1, j);
                }
            }
        }
    }
}
