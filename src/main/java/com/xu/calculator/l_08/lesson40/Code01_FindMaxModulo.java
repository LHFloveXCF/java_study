package com.xu.calculator.l_08.lesson40;

import java.util.HashSet;

/**
 * java_study
 */
public class Code01_FindMaxModulo {

    private long maxModulo(int[] arr, int M) {
        // 找到所有可能的子序列元素和
        // 取模，找到最大值
        HashSet<Long> sum = new HashSet<>();
        process(arr, 0, 0, sum);
        long result = Long.MIN_VALUE;
        for (Long aLong : sum) {
            result = Math.max(result, aLong % M);
        }
        return result;
    }

    private void process(int[] arr, int index, long nowSum, HashSet<Long> sum) {
        if (index == arr.length) {
            sum.add(nowSum);
        } else {
            process(arr, index + 1, nowSum, sum);
            process(arr, index + 1, nowSum + arr[index], sum);
        }
    }

    // 如果M比较小，但是arr中的数据比较大
    // DP表 动态规划是根据M，和数组中数据个数来判断
    private long maxModulo2(int[] arr, int M) {
        int N = arr.length;
        boolean[][] dp = new boolean[N][M];
        for (int i=0; i<N; i++) {
            dp[i][0] = true;
        }
        return 1;

    }
}
