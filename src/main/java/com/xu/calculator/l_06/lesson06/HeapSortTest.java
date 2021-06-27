package com.xu.calculator.l_06.lesson06;

import com.xu.util.SortUtil;

/**
 * readme 堆排序相关问题
 */
public class HeapSortTest {
    public static void sort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int k = 2;
        for (int i=0; i<=arr.length - k; i++) {
            System.out.println("-----" + i);
            for (int index = 0; index < k; index++) {
                int left = index;
                while (arr[left + i] < arr[(left - 1) / 2 + i]) {
                    SortUtil.swap(arr, left + i, (left - 1) / 2 + i);
                    left = (left - 1) / 2;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,5,4,6,8,7};
        sort(arr);
        SortUtil.print(arr);
    }
}
