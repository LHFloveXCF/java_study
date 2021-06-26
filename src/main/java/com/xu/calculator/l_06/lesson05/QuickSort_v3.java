package com.xu.calculator.l_06.lesson05;

import com.xu.calculator.DataCheck;
import com.xu.util.SortUtil;

/**
 * java_study
 */
public class QuickSort_v3 {
    public static void sort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        // base case
        if (l == r) {
            return;
        }
        int randomIndex = l + ((r - l) >> 1);
        int[] bound = partition(arr, randomIndex, l, r);
        if (bound[0] > l) {
            process(arr, l, bound[0]);
        }
        process(arr, bound[1], r);
    }

    private static int[] partition(int[] arr, int randomIndex, int l, int r) {
        int des = arr[randomIndex];
        int little = l - 1;
        int max = r;
        int cur = l;
        while (cur <= max) {
            if (arr[cur] > des) {
                SortUtil.swap(arr, cur, max--);
            } else if (arr[cur] < des) {
                SortUtil.swap(arr, cur++, ++little);
            } else {
                cur++;
            }
        }
//        System.out.println("-----" + little + "=========" + cur);
        return new int[]{little, cur};
    }

    public static void main(String[] args) {
        int[] ints = DataCheck.generateArr(5);
//        int[] ints = {3, 0 ,0 ,0 ,2 };

        SortUtil.print(ints);
        sort(ints);
        SortUtil.print(ints);
    }
}
