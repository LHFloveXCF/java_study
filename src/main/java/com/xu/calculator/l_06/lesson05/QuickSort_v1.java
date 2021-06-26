package com.xu.calculator.l_06.lesson05;

import com.xu.util.SortUtil;

/**
 * java_study
 * 快排version1：
 * 分层思想，给定一个数组arr，和一个整数num。请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。
 */
public class QuickSort_v1 {
    public static void partition() {
        int[] arr = {3, 4, 2, 1, 5, 3, 8, 2};
        int des = 3;

        int fist = -1;
        int last = 0;
        while (last <= arr.length - 1) {
            if (arr[last] <= des) {
                SortUtil.swap(arr, ++fist, last++);
            } else {
                last++;
            }
        }
        SortUtil.print(arr);
    }

    public static void sort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        // base case
        if (l >= r) {
            return;
        }
        int i = partition2(arr, l, r);
        process(arr, l, i - 1);
        process(arr, i, r);
    }

    private static int partition2(int[] arr, int l, int m) {
        int des = arr[m];
        int fist = l - 1;
        int last = l;
        while (last <= m) {
            if (arr[last] <= des) {
                SortUtil.swap(arr, ++fist, last++);
            } else {
                last++;
            }
        }
        return fist;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 5, 3, 8, 2};
        sort(arr);
        SortUtil.print(arr);
    }
}
