package com.xu.calculator;

import com.xu.util.SortUtil;

/**
 * java_study
 */
public class MergerSort {

    public static void main(String[] args) {
        int[] arr = {7,8,9,1,2,3,4};
        sort(arr, 0, arr.length - 1);
//        merger(arr, 0, arr.length - 1, 2);
//        merger(arr, 3);
        SortUtil.print(arr);
    }

    static void sort(int[] arr, int leftPointer, int rightPointer) {
        if (rightPointer <= leftPointer) {
            return;
        }
        //先分割
        int mid = leftPointer + (rightPointer - leftPointer) / 2;
        //左
        sort(arr, leftPointer, mid);
        //右
        sort(arr, mid + 1, rightPointer);
        merger2(arr, mid, leftPointer, rightPointer);
    }


    public static void merger2(int[] arr, int mid, int left, int right) {
        int i = left;
        int j = mid;
        int k = 0;
        int[] temp = new int[right - left + 1];
        while (i < mid && j <= right)
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        while (i < mid)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];
        for (int m = 0; m < temp.length; m++) {
            arr[left + m] = temp[m];
        }
    }

}
