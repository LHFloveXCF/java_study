package com.xu.calculator.l_06.lesson4;

import com.xu.calculator.l_06.MergerSort2;

/**
 * java_study
 */
public class MergerSort {
    public static void sort(int[] arr) {
        if (null == arr || arr.length < 2) {
            // 数组为空，数组长度为1不用排序直接返回
            return;
        }
        // 归并排序的非递归实现，主要是步长的概念；步长1--2--4--8---一直到N;每个步长都合并一下，最终求得结果
        int len = 1;
        int n = arr.length;
        while (len < n) {
            int l = 0;
            while (l < n) {
                int m = l + len - 1;
                if (m > n - 1) {
                    break;
                }
                int r = Math.min(m + len, n - 1);
                MergerSort2.merger(arr, m, l, r);
                l = r + 1;
            }
            if (len > n >> 1) {
                break;
            }
            len <<= 1;
        }
    }

}
