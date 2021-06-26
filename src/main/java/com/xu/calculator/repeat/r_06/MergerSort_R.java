package com.xu.calculator.repeat.r_06;

/**
 * 归并排序
 * 比较重要的排序方式时间复杂度O(N*logN)
 * 递归的使用，递归序，base case的合理运用
 */
public class MergerSort_R {
    public static void sort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        // base case
        if (L == R) {
            return;
        }
        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr, M + 1, R);
        merger(arr, M, L, R);
    }

    private static void merger(int[] arr, int M, int L, int R) {
        int[] help = new int[R - L + 1];
        int left = L;
        int right = M + 1;
        int cur = 0;
        while (left <= M && right <= R)
            help[cur++] = arr[left] > arr[right] ? arr[right++] : arr[left++];
        while (left <= M)
            help[cur++] = arr[left++];
        while (right <= R)
            help[cur++] = arr[right++];
        System.arraycopy(help, 0, arr, L, help.length);
    }
}
