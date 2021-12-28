package com.leetcode;

/**
 * java_study
 * https://leetcode-cn.com/problems/climbing-stairs/submissions/
 * 爬楼梯
 */
public class Test_70 {

    public int climbStairs2(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i=2; i<=n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    public int climbStairs(int n) {
        return climb(n, 0);
    }

    private int climb(int n, int i) {
        if (i == n) {
            return 1;
        } else if (i > n) {
            return 0;
        }
        return climb(n,i + 1) +
        climb(n, i + 2);
    }

    public static void main(String[] args) {
        System.out.println(new Test_70().climbStairs2(4));
    }
}
