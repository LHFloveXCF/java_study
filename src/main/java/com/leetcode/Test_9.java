package com.leetcode;

import org.apache.commons.lang3.StringUtils;

/**
 * java_study
 */
public class Test_9 {
    public boolean isPalindrome1(int x) {
        String str = String.valueOf(x);
        return str.equals(StringUtils.reverse(str));
    }

    public static void main(String[] args) {
        new Test_9().isPalindrome(121);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int mid = x;
        int result = 0;
        while (x > 0) {
            int temp = x % 10;
            x /= 10;
            result = result * 10 + temp;
        }
        return result == mid;
    }
}
