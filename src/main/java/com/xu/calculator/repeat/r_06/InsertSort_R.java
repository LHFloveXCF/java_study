package com.xu.calculator.repeat.r_06;

import com.xu.util.SortUtil;

/**
 * 插入排序
 * 跟打扑克，洗牌摸牌一样，后摸到的牌可能会放到前面去，也可能依次放到后面去
 */
public class InsertSort_R {
    public static void sort(int[] arr) {
        for (int i = 1; i<arr.length;i++) {
            for (int j=i; j>0;j--) {
                if (arr[j] < arr[j-1]) {
                    SortUtil.swap(arr, j, j - 1);
                }
            }
        }
    }

}
