package com.leetcode;

/**
 * java_study
 * https://leetcode-cn.com/problems/plus-one/
 * 加一
 */
public class Test_66 {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int lastValue = digits[length - 1] + 1;
        if (lastValue == 10) {
            for (int i = length - 1; i >= 0; i--) {
                digits[i] += 1;
                if (digits[i] < 10) {
                    return digits;
                } else {
                    digits[i] = 0;
                }
                if (i == 0) {
                    int[] result = new int[length + 1];
                    System.arraycopy(digits, i, result, 1, length);
                    result[0] = 1;
                    return result;
                }
            }
        } else {
            digits[length - 1] = lastValue;
            return digits;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = {9,9};
        System.out.println(new Test_66().plusOne(arr));
    }
}
