package com.xu.calculator.repeat.r_06;

import com.xu.util.SortUtil;

/**
 * 快速排序
 */
public class QuickSort_R {
    public static void sort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int[] range = partition(arr, L, R);
        if (range[0] > L) {
            process(arr, L, range[0]);
        }
        process(arr, range[1], R);
    }

    private static int[] partition(int[] arr, int L, int R) {
        int des = arr[R];
        int little = L - 1;
        int max = R;
        int cur = L;
        while (cur < max) {
            if (arr[cur] > des) {
                SortUtil.swap(arr, cur, --max);
            } else if (arr[cur] < des) {
                SortUtil.swap(arr, cur++, ++little);
            } else {
                cur++;
            }
        }
        SortUtil.swap(arr, max, R);
        return new int[]{little, max};
    }
}
