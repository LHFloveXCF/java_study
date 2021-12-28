package com.leetcode;

import java.net.ResponseCache;
import java.util.Arrays;

/**
 * java_study
 * https://leetcode-cn.com/problems/add-binary/
 * 二进制求和
 */
public class Test_67 {
    public String addBinary(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        int lengthA = aChar.length;
        int lengthB = bChar.length;
        int maxLength = Math.max(lengthA, lengthB);
        char[] result = new char[maxLength];
        int len = maxLength;
        char carry = '0';
        for (int i = 1; i <= maxLength; i++) {
            char tempA = i <= lengthA ? aChar[lengthA - i] : '0';
            char tempB = i <= lengthB ? bChar[lengthB - i] : '0';
            int total = tempA - '0' + tempB - '0' + carry - '0';
            if (total == 0) {
                result[--len] = '0';
            } else if (total == 1) {
                result[--len] = '1';
                carry = '0';
            } else if (total == 2) {
                result[--len] = '0';
                carry = '1';
            } else {
                result[--len] = '1';
            }
        }
        if (carry == '1') {
            char[] arr = new char[result.length + 1];
            System.arraycopy(result,0, arr, 1, result.length);
            arr[0] = '1';
            return String.valueOf(arr);
        }
        return String.valueOf(result);
    }

    public String addBinary1(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        int lengthA = aChar.length;
        int lengthB = bChar.length;
        int maxLength = lengthA > lengthB ? lengthA : lengthB;
        char[] result = new char[maxLength];
        maxLength -= 1;
        char carry = '0';
        while (lengthA > 0 && lengthB > 0) {
            char first = aChar[lengthA - 1];
            char second = bChar[lengthB - 1];
            lengthA--;
            lengthB--;
            if (first == second) {
                result[maxLength--] = carry;
                if (first == '1') {
                    carry = '1';
                }
            } else {
                int sum = first - '0' + second - '0' + carry - '0';
                if (sum > 1) {
                    result[maxLength--] = '0';
                } else if (sum == 1) {
                    result[maxLength--] = '1';
                    carry = '0';
                } else {
                    result[maxLength--] = '0';
                    carry = '0';
                }
            }
        }
        while (lengthA > 0) {
            char first = aChar[lengthA - 1];
            int sum = first - '0' + carry - '0';
            if (sum > 1) {
                result[maxLength--] = '0';
            } else {
                result[maxLength--] = carry;
                carry = '0';
            }
            lengthA--;
        }
        while (lengthB > 0) {
            char first = aChar[lengthB - 1];
            int sum = first - '0' + carry - '0';
            if (sum > 1) {
                result[maxLength--] = '0';
            } else {
                result[maxLength--] = carry;
                carry = '0';
            }
            lengthB--;
        }
        if (carry - '0' != 0) {
            char[] arr = new char[result.length + 1];
            System.arraycopy(result,0, arr, 1, result.length);
            arr[0] = carry;
            return String.valueOf(arr);
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        String a = "1010",
                b = "1011";
        System.out.println(new Test_67().addBinary(a, b));

    }
}
