package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * java_study
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
