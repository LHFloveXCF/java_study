package com.xu.calculator.l_06.lesson20;

/**
 * java_study
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubStr {

    private static int longestSubStr(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        return process(str1, str2, str1.length - 1, str2.length - 1);
    }

    private static int process(char[] str1, char[] str2, int length, int length2) {
        if (length == 0 && length2 == 0) {
            return str1[length] == str2[length2] ? 1 : 0;
        } else if (length == 0) {
            if (str1[length] == str2[length2]) {
                return 1;
            } else {
                return process(str1, str2, length, length2 - 1);
            }
        } else if (length2 == 0) {
            if (str1[length] == str2[length2]) {
                return 1;
            } else {
                return process(str1, str2, length - 1, length2);
            }
        } else {
            // 都不等于0
            int p1 = process(str1, str2, length, length2 - 1);
            int p2 = process(str1, str2, length - 1, length2);
            int p3 = str1[length] == str2[length2] ? (process(str1, str2, length - 1, length2 - 1) + 1) : 0;
            return Math.max(p1, Math.max(p2, p3));
        }
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        int length1 = str1.length;
        int length2 = str2.length;
        int[][] dp = new int[length1][length2];

        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int j = 1; j < text2.length(); j++) {
            dp[0][j] = str1[0] == str2[j] ? 1 : dp[0][j - 1];
        }

        for (int j = 1; j < text1.length(); j++) {
            dp[j][0] = str1[j] == str2[0] ? 1 : dp[j - 1][0];
        }

        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                int p1 = dp[i][j - 1];
                int p2 = dp[i - 1][j];
                int p3 = str1[i] == str2[j] ? dp[i - 1][j - 1] + 1 : 0;
                dp[i][j] = Math.max(p1, Math.max(p2, p3));
            }
        }
        return dp[length1 - 1][length2 - 1];
    }

    public static void main(String[] args) {
        String s1 = "absolute";
        String s2 = "helloustbe";

        System.out.println(longestSubStr(s1, s2));
        System.out.println(longestCommonSubsequence(s1, s2));
    }
}
