package com.xu.calculator.repeat.r_06;

import com.xu.util.SortUtil;

/**
 * 选择排序
 * 有较少的交换次数
 */
public class SelectionSort_R {
    public static void sort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                SortUtil.swap(arr, minIndex, i);
            }
        }
    }
}
