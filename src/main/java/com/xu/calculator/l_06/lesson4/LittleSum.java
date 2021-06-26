package com.xu.calculator.l_06.lesson4;

import com.xu.util.SortUtil;

/**
 * java_study
 * 小和问题：在一个数组中， 每一个数左边比当前数小的数累加起来， 叫做这个数组的小和。 求一个数组的小和。
 */
public class LittleSum {

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        System.out.println("小和值： " + findSum(arr));
        SortUtil.print(arr);
    }

    public static int findSum(int[] arr) {
        if (null == arr || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        int sum = 0;
        if (L == R) {
            return sum;
        }
        int M = L + ((R - L) >> 1);
        sum += process(arr, L, M);
        sum += process(arr, M + 1, R);
        sum += merger(arr, M, L, R);
        return sum;
    }

    private static int merger(int[] arr, int M, int L, int R) {
        int sum = 0;
        int[] help = new int[R - L + 1];
        int index = 0;
        int left = L;
        int right = M + 1;
        while (left <= M && right <= R) {
            if (arr[right] > arr[left]) {
                sum += arr[left] * (R - right + 1);
                help[index++] = arr[left++];
            } else {
                help[index++] = arr[right++];
            }
        }
        while (left <= M)
            help[index++] = arr[left++];
        while (right <= R)
            help[index++] = arr[right++];
        System.arraycopy(help, 0, arr, L, help.length);
        return sum;
    }
}
