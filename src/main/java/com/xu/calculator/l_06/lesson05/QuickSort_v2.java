package com.xu.calculator.l_06.lesson05;

import com.xu.calculator.DataCheck;
import com.xu.util.SortUtil;

/**
 * java_study
 */
public class QuickSort_v2 {
    public static void sort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int[] part = partition(arr, l, r);
        if (part[0] > 0) {
            process(arr, l, part[0]);
        }
        process(arr, part[1], r);
    }

    private static int[] partition(int[] arr, int l, int r) {
        int des = arr[r]; // 目标值
        int left = l - 1; // 小于区
        int right = r; // 大于区
        int cur = l; // 当前指针
        while (cur <= right - 1) {
            if (arr[cur] < des) {
                SortUtil.swap(arr, cur++, ++left);
            } else if (arr[cur] > des) {
                SortUtil.swap(arr, cur, --right);
            } else {
                cur++;
            }
        }
        SortUtil.swap(arr, right, r);
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        int[] ints = DataCheck.generateArr(5);
        sort(ints);
        SortUtil.print(ints);
    }

}
