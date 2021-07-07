package com.xu.calculator.leetcode;

/**
 * java_study
 */
public class Test_136 {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
