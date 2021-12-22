package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * java_study
 */
public class Test_13 {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int value = roman.get(s.charAt(i));
            if (i + 1 < length && roman.get(s.charAt(i + 1)) > value) {
                result -= value;
            } else {
                result += value;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Test_13().romanToInt("II");
    }
}
