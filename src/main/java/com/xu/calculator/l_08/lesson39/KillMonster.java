package com.xu.calculator.l_08.lesson39;

/**
 * java_study
 */
public class KillMonster {
    private static int process(int[] d, int[] p, int index, int ability) {
        if (index == d.length) {
            return 0;
        }
        if (ability < d[index]) {
            return p[index] + process(d, p, index + 1, ability + d[index]);
        } else {
            return Math.min(p[index] + process(d, p, index + 1, ability + d[index]), process(d, p, index + 1, ability));
        }
    }

    public static void main(String[] args) {
        // 动态规划的题目，改写DP

    }
}
