package com.xu.calculator.repeat.r_06;

import com.xu.calculator.DataCheck;
import com.xu.calculator.l_06.lesson06.HeapSort;
import com.xu.util.SortUtil;

/**
 * 排序默认指升序，这就是一种行业的约定，除非特别制定顺序
 * 冒泡排序
 */
public class BubbleSort_R {
    public static void sort(int[] arr) {
        // 一共走arr.length轮，每一轮会找到一个最小值依次放到前面,一个个冒泡出来，每次都会交换
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    SortUtil.swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = DataCheck.generateArr(6);
        SortUtil.print(arr);
//        sort(arr);
//        InsertSort_R.sort(arr);
//        SelectionSort_R.sort(arr);
        // test commit
//        MergerSort_R.sort(arr);
//        QuickSort_R.sort(arr);
        HeapSort.sort(arr);
        SortUtil.print(arr);

    }
}
