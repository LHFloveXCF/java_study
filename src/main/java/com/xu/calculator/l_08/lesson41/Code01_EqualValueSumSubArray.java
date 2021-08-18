package com.xu.calculator.l_08.lesson41;

import com.xu.util.ArrayUtils;
import com.xu.util.SortUtil;

/**
 * java_study
 * 小于K的最长子序列的长度
 * 滑动窗口来解决这个问题；
 * O(N) 单调性，不回退，子数组的问题就考虑以某个下标开始或者以某个下标结尾的的情况
 */
public class Code01_EqualValueSumSubArray {
    private static int aweSome(int[] arr, int K) {
        int begin = 0;
        int end = 0;
        int sum = arr[0];
        int ans = 0;
        while (end < arr.length) {
            if (sum == K) {
                ans = Math.max(ans, end - begin + 1);
                // 因为题目中是正整数，所以才有这个，都是坑
                sum -= arr[begin++];
            } else if (sum < K) {
                end++;
                if (end == arr.length) {
                    break;
                }
                sum += arr[end];
            } else {
                sum -= arr[begin++];
            }
        }
        return ans;
    }

    private static int right(int[] arr, int K) {
        int ans = 0;
        // 1. 先算出所有的子数组
        // 2. 求出子数组之和等于K的最大长度
        for (int i=0; i<arr.length; i++) {
            int sum = 0;
            for (int j=i; j<arr.length; j++) {
                sum += arr[j];
                if (sum == K) {
                    ans = Math.max(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generate(100, 10);
        SortUtil.print(arr);

        int aweSome = aweSome(arr, 10);
        int right = right(arr, 10);
        System.out.println(right);
        System.out.println(aweSome == right);

    }
}
