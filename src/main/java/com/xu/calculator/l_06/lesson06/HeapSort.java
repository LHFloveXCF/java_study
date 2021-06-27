package com.xu.calculator.l_06.lesson06;

import com.xu.util.SortUtil;

public class HeapSort {
    public static void sort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i=0; i<arr.length; i++) {
            HeapInsert.heapInsert(arr, i);
        }
//        System.out.println("--------");
        SortUtil.print(arr);
        int heapSize = arr.length;
        SortUtil.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            HeapInsert.heapIfy(arr, 0, heapSize);
            SortUtil.swap(arr, 0, --heapSize);
        }
    }
}
