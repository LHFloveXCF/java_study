package com.xu.calculator.l_06.lesson20;

import java.util.Arrays;

/**
 * java_study
 * 洗咖啡杯
 * 只有一台咖啡机，一次只能洗一个杯子，时间耗费a，洗完才能洗下一杯
 * 每个咖啡杯也可以自己挥发干净，时间耗费b，咖啡杯可以并行挥发
 * 假设所有人拿到咖啡之后立刻喝干净，
 * 返回从开始等到所有咖啡机变干净的最短时间
 * <p>
 * 已知一个长度为N的数组arr,arr[i]表示第i个人喝完咖啡的时间点；
 * 暴力尝试：
 */
public class CoffeeWash {

    private static int minWashTime(int[] arr, int wash, int wind) {
        return process(arr, 0, 0, wash, wind);
    }

    private static int process(int[] arr, int index, int free, int wash, int wind) {
        if (index == arr.length) {
            return 0;
        }

        // index 决定洗
        int selfClean = Math.max(arr[index], free) + wash;
        int restClean = process(arr, index + 1, selfClean, wash, wind);
        int p1 = Math.max(selfClean, restClean);

        // index决定风干
        int selfClean2 = arr[index] + wind;
        int restClean2 = process(arr, index + 1, free, wash, wind);
        int p2 = Math.max(selfClean2, restClean2);

        return Math.min(p1, p2);
    }

    private static int dp(int[] arr, int wash, int wind) {
        int maxFree = 0;
        for (int i : arr) {
            maxFree = Math.max(i, maxFree) + wash;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][maxFree + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int free = 0; free <= maxFree; free++) {
                int selfClean = Math.max(arr[index], free) + wash;
                if (selfClean > maxFree) {
                    break;
                }
                // 决定洗
                int restClean = dp[index + 1][selfClean];
                int p1 = Math.max(selfClean, restClean);
                // 决定风干
                int selfClean2 = arr[index] + wind;
                int restClean2 = dp[index + 1][free];
                int p2 = Math.max(selfClean2, restClean2);
                dp[index][free] = Math.min(p1, p2);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5};
        System.out.println(minWashTime(arr, 2, 3));
        System.out.println(dp(arr, 2, 3));
    }
}
