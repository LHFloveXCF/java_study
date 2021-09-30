package com.xu.calculator.l_08.lesson41;

/**
 * java_study
 */
public class Code04_PostMail {
    private static int min1(int[] arr, int num) {
        if (null == arr || arr.length < num) {
            return 0;
        }
        int N = arr.length;
        int[][] help = new int[N + 1][N + 1];
        for (int L = 0; L < N; L++) {
            for (int R = L + 1; R < N; R++) {
                help[L][R] = arr[R] - arr[(L + R) >> 1] + help[L][R - 1];
            }
        }
        int[][] dp = new int[N][num + 1];
        for (int i = 0; i < N; i++) {
            dp[i][1] = help[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 2; j < Math.min(i, num); j++) {
                int ans = Integer.MAX_VALUE;
                for (int k = 0; k <= i; k++) {
                    ans = Math.min(ans, dp[k][j - 1] + help[k + 1][i]);
                }
                dp[i][j] = ans;
            }
        }
        return dp[N - 1][num];
    }

    private static int min2(int[] arr, int num) {
        if (null == arr || arr.length < num) {
            return 0;
        }
        int N = arr.length;
        int[][] help = new int[N + 1][N + 1];
        for (int L = 0; L < N; L++) {
            for (int R = L + 1; R < N; R++) {
                help[L][R] = help[L][R - 1] + arr[R] - arr[(R + L) / 2];
            }
        }
        int[][] dp = new int[N][num + 1];
        int[][] best = new int[N][num + 1];
        for (int i = 0; i < N; i++) {
            dp[i][1] = help[0][i];
            best[i][1] = -1;
        }
        for (int j = 2; j < num; j++) {
            for (int i = N - 1; i >= j; i--) {
                int down = best[i][j - 1];
                int up = i == N - 1 ? N - 1 : best[i + 1][j];
                int ans = Integer.MAX_VALUE;
                int bestChoose = -1;
                for (int leftEnd = down; leftEnd<=up; leftEnd++) {
                    int leftCost = leftEnd == -1 ? 0 : dp[leftEnd][j - 1];
                    int rightCost = leftEnd == -1 ? 0 : help[leftEnd + 1][i];
                    int cur = leftCost + rightCost;
                    if (cur <= ans) {
                        ans = cur;
                        bestChoose = leftEnd;
                    }
                }
                dp[i][j] = ans;
                best[i][j] = bestChoose;
            }
        }
        return dp[N - 1][num];
    }
}
