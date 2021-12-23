package com.leetcode;

/**
 * java_study
 * 边界条件没有处理
 * test git bash
 */
public class Test_29 {
    public int divide(int dividend, int divisor) {
        int a = dividend < 0 ? add(~dividend, 1) : dividend;
        int b = divisor < 0 ? add(~divisor, 1) : divisor;
        int quotient = 0;
        while (a >= b) {
            quotient = add(quotient, 1);
            a = sub(a, b);
        }
        if ((dividend ^ divisor) < 0) {
            quotient = add(~quotient, 1);
        }
        System.out.println(quotient);
        return quotient;
    }

    public int divide2(int dividend, int divisor) {
        int a = dividend < 0 ? add(~dividend, 1) : dividend;
        int b = divisor < 0 ? add(~divisor, 1) : divisor;
        int quotient = 0;
        while (a >= b) {
            int multi = 1;
            while (multiply(multi, b) <= (a >> 1)) {
                multi = multi << 1;
            }
            quotient = add(quotient, multi);
            a = sub(a, multiply(b, multi));
        }
        if ((dividend ^ divisor) < 0) {
            quotient = add(~quotient, 1);
        }
        return quotient;
    }

    private int add(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        return add(sum, carry);
    }

    private int sub(int num1, int num2) {
        return add(num1, add(~num2,  1));
    }

    private int multiply(int num1, int num2) {
        int a = num1 < 0 ? add(~num1, 1) : num1;
        int b = num2 < 0 ? add(~num2, 1) : num2;

        /*int result = 0;
        int count = 0;
        while (count < b) {
            int multi = 1;
            while (b * multi <= (a >> 1)) {
                multi = multi << 1;
            }
            result = add(result, a);
            count = add(count, multi);
        }*/

        int result = 0;
        while (b > 0) {
            if ((b & 1) > 0) {
                result = add(result, a);
            }
            a = a << 1;
            b = b>> 1;
        }

        if ((num1 ^ num2) < 0) {
            result = add(~result, 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Test_29().divide2(-2147483648, -1));

        System.out.println();
        System.out.println(~Integer.MIN_VALUE + 1);
        System.out.println(Integer.MIN_VALUE);
    }

}
