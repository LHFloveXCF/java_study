package com.xu.calculator.l_08.lesson41;

/**
 * java_study
 */
public class Code02_EqualValueSumSubArray2 {
    private static int aweSome(int[] arr, int K) {
        int ans = 0;
        int N = arr.length;
        int[] minSum = new int[N];
        int[] minSumEnd = new int[N];
        minSum[N - 1] = arr[N - 1];
        minSumEnd[N - 1] = N - 1;
        for (int i = arr.length - 1; i > 0; i--) {
            if (minSum[i] < 0) {
                minSum[i - 1] = minSum[i] + arr[i - 1];
                minSumEnd[i - 1] = minSumEnd[i];
            } else {
                minSum[i - 1] = arr[i - 1];
                minSumEnd[i - 1] = i;
            }
        }
        int left = 0;
        int right = 0;
        return ans;
    }
}
