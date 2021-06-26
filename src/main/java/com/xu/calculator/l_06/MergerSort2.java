package com.xu.calculator.l_06;

/**
 * java_study
 */
public class MergerSort2 {
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
        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr, M + 1, R);
        merger(arr, M, L, R);
    }

    public static void merger(int[] arr, int M, int l, int r) {
        int[] help = new int[r - l + 1];
        int index = 0;
        int L = l;
        int R = M + 1;
        while (L <= M && R <= r)
            help[index++] = arr[L] > arr[R] ? arr[R++] : arr[L++];
        while (L <= M)
            help[index++] = arr[L++];
        while (R <= r)
            help[index++] = arr[R++];
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}
