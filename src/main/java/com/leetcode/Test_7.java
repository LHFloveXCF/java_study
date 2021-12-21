package com.leetcode;

/**
 * java_study
 * https://leetcode-cn.com/problems/reverse-integer/submissions/
 */
public class Test_7 {

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x = digit / 10;

            result = result * 10 + digit;
        }
        return result;
    }
}
