package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * java_study
 * 可以运用ASCLL码来进行比较
 */
public class Test_8 {
    public int myAtoi(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int index = 0;
        while (index < length && chars[index] == ' ') {
            index++;
        }
        if (index == length) {
            return 0;
        }
        int sign = 1;
        char nextChar = chars[index];
        if (nextChar == '-') {
            sign = -1;
            index++;
        } else if (nextChar == '+') {
            index++;
        }
        if (index == length) {
            return 0;
        }
        int result = 0;
        for (int i=index; i<length; i++) {
            nextChar = chars[i];
            if (nextChar < '0' || nextChar > '9') {
                break;
            }
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (nextChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && (nextChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + sign * (nextChar - '0');
        }

        return result;
    }

    public int myAtoi2(String s) {
        /*Character[] num = new Character[] {
                '1', '2','3', '4','5', '6','7', '8','9', '0'
        };*/
        Map<Character, Integer> numMap = new HashMap<>();
        numMap.put('1', 1);
        numMap.put('2', 2);
        numMap.put('3', 3);
        numMap.put('4', 4);
        numMap.put('5', 5);
        numMap.put('6', 6);
        numMap.put('7', 7);
        numMap.put('8', 8);
        numMap.put('9', 9);
        numMap.put('0', 0);


        while (s.startsWith(" ")) {
            int i = s.indexOf(" ");
            s = s.substring(i + 1);
            // System.out.println(s);
        }
        // 2. 判断符号
        long result = 0;
        boolean isNegative = false;
        if (s.startsWith("-")) {
            isNegative = true;
            s = s.substring(s.indexOf("-") + 1);
        } else if (s.startsWith("+")) {
            s = s.substring(s.indexOf("+") + 1);
        } else {
            if (s.length() <= 0) {
                return 0;
            } else {
                if (!numMap.containsKey(s.charAt(0))) {
                    return 0;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!numMap.containsKey(c)) {
                if (result > Integer.MAX_VALUE && !isNegative) {
                    return Integer.MAX_VALUE;
                } else if (result > Integer.MAX_VALUE + 1L && isNegative) {
                    return Integer.MIN_VALUE;
                } else {
                    break;
                }
            }
            if (result >= Long.MAX_VALUE / 10) {
                return check(result, isNegative);
            }
            result = result * 10 + numMap.get(c);
        }
        return check(result, isNegative);

    }

    private int check(long result, boolean isNegative) {
        if (isNegative) {
            result *= -1;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test_8().myAtoi("      -11919730356x"));
    }
}
