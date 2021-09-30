package com.xu.calculator.l_08.lesson41;

/**
 * java_study
 */
public class Code05_ThrowEggsProblem {
    private static int min1(int floor, int num) {
        if (floor <= 0 || num <= 0) {
            return 0;
        }
        return process(floor, num);
    }

    private static int process(int restFloor, int restNum) {
        // baseCase
        if (restFloor == 0) {
            return 0;
        }
        if (restNum == 1) {
            return restFloor;
        }
        int min = Integer.MAX_VALUE;
        for (int i=1; i!= restFloor + 1; i++) {
            min = Math.min(min, Math.max(process(i - 1, restNum -1 ), process(restFloor - 1, restNum)));
        }
        return min + 1;
    }

    private static int superEggDrop2(int kChess, int nLevel) {
        if (nLevel < 1 || kChess < 1) {
            return 0;
        }
        if (kChess == 1) {
            return nLevel;
        }
        int[][] dp = new int[nLevel + 1][kChess + 1];
        for (int i=0; i != dp.length; i++) {
            dp[i][1] = i;
        }
        for (int i=1; i != dp.length; i++) {
            for (int j=2; j!=dp[0].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k=1; k != i+1; k++) {
                    min = Math.min(min, Math.max(dp[k - 1][j - 1], dp[i - k][j]));
                }
                dp[i][j] = min;
            }
        }
        return dp[nLevel][kChess];
    }
}
