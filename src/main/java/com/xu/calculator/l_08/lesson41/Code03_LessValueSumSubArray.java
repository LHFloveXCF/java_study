package com.xu.calculator.l_08.lesson41;

import javafx.scene.AmbientLight;

import java.util.Map;

/**
 * java_study
 * 给定一个整数组成的无序数组arr，值可能正、可能负、可能0
 * 给定一个整数值K
 * 找到arr的所有子数组里，哪个子数组的累加和<=K，并且是长度最大的
 * 返回其长度
 */
public class Code03_LessValueSumSubArray {
    private static int awesome(int[] arr, int K) {
        int ans = 0;
        int N = arr.length;
        int[] minSum = new int[N];
        int[] minSumEnd = new int[N];
        minSum[N - 1] = arr[N - 1];
        minSumEnd[N - 1] = N - 1;
        for (int i = N - 1; i > 0; i++) {
            if (minSum[i] < 0) {
                minSum[i - 1] = minSum[i] + arr[i - 1];
                minSumEnd[i - 1] = minSumEnd[i];
            } else {
                minSum[i - 1] = arr[i];
                minSumEnd[i - 1] = i;
            }
        }

        int right = 0;
        int sum = 0;
        for (int i = 0; i<N; i++) {
            while (right < N && sum + minSum[right] <= K) {
                sum += minSum[right];
                right = minSumEnd[right] + 1;
            }
            ans = Math.max(ans, right - 1);
            if (right > i) {
                sum -= arr[i];
            } else {
                right = i + 1;
            }
        }
        return ans;
    }
}
