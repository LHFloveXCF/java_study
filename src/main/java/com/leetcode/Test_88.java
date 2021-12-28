package com.leetcode;

import java.util.Scanner;

/**
 * java_study
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 合并两个有序数组
 */
public class Test_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int first = 0;
        int second = 0;
        int index = 0;
        while (first < m && second < n) {
            int fValue = nums1[first];
            int sValue = nums2[second];
            if (fValue < sValue) {
                res[index++] = fValue;
                first++;
            } else {
                res[index++] = sValue;
                second++;
            }
        }
        while (first < m) {
            res[index++] = nums1[first];
            first++;
        }

        while (second < n) {
            res[index++] = nums2[second];
            second++;
        }
        System.arraycopy(res, 0, nums1, 0, m + n);

        // System.out.println(nums1);
    }

}
