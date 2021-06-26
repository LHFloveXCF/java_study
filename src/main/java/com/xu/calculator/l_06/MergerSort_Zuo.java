package com.xu.calculator.l_06;

/**
 * java_study
 * 左神版归并排序
 * 递归解法：
 * 非递归解法：步长的概念
 */
public class MergerSort_Zuo {
    public static void sort(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * 归并排序，baseCase
     *
     * @param arr
     * @param L   左边
     * @param R   右边
     */
    private static void process(int[] arr, int L, int R) {
        if (R == L) {
            return;
        }
        int middle = L + ((R - L) >> 1);
        process(arr, L, middle);
        process(arr, middle + 1, R);
        merger(arr, middle, L, R);
    }

    private static void merger(int[] arr, int middle, int l, int r) {
        int[] temp = new int[r - l + 1];
        int leftIndex = l;
        int rightIndex = middle + 1;
        int index = 0;
        while (leftIndex <= middle && rightIndex <= r) {
            temp[index++] = arr[leftIndex] > arr[rightIndex] ? arr[rightIndex++] : arr[leftIndex++];
        }
        while (leftIndex <= middle) {
            temp[index++] = arr[leftIndex++];
        }
        while (rightIndex <= r) {
            temp[index++] = arr[rightIndex++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[l + i] = temp[i];
        }
    }

}
