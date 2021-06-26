package com.xu.calculator.l_06.lesson05;

import com.xu.calculator.l_06.MergerSort2;

/**
 * java_study
 */
public class FindSubArr {

    public static void main(String[] args) {
        int[] arr = {1,2,3,6};
        System.out.println(findCount(arr, 3, 8));
    }

    public static int findCount(int[] arr, int lower, int upper) {
        int[] preSum = preSum(arr);
        return process(preSum, lower, upper, 0, arr.length - 1);
    }

    private static int process(int[] arr, int lower, int upper, int L, int R) {
        // 老规矩，写base
        if (L == R) {
            return (arr[L] >= lower && arr[L] <= upper) ? 1 : 0;
        }
        int M = L + ((R - L) >> 1);
        return (process(arr, lower, upper, L, M) + process(arr, lower, upper,M + 1, R) + calcCount(arr, lower, upper, M, L, R));
    }

    private static int calcCount(int[] arr, int lower, int upper, int m, int l, int r) {
        // 先计算，然后再合并
        int rightSum = m + 1;
        int count = 0;
        while (rightSum <= r) {
            for (int j=l;j<=m;j++) {
                int low2 = arr[rightSum] - upper;
                int upper2 = arr[rightSum] - lower;
                if (arr[j] >= low2 && arr[j] <= upper2) {
                    count += 1;
                }
            }
            rightSum++;
        }
        MergerSort2.merger(arr, m, l, r);
        return count;
    }

    private static int[] preSum(int[] arr) {
        int[] preSum = new int[arr.length];
        preSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
        return preSum;
    }

}
