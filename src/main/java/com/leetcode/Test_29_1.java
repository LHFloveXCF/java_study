package com.leetcode;

/**
 * java_study
 */
public class Test_29_1 {
    public int divide2(int dividend, int divisor) {
        long a = dividend < 0 ? add(~dividend, 1) : dividend;
        long b = divisor < 0 ? add(~divisor, 1) : divisor;
        long quotient = 0;
        while (a >= b) {
            long multi = 1;
            while (multiply(multi, b) <= (a >> 1)) {
                multi = multi << 1;
            }
            quotient = add(quotient, multi);
            a = sub(a, multiply(b, multi));
        }
        if ((dividend ^ divisor) < 0) {
            quotient = add(~quotient, 1);
        }
        if (quotient >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) quotient;
    }

    private long add(long num1, long num2) {
        if (num2 == 0) {
            return num1;
        }
        long sum = num1 ^ num2;
        long carry = (num1 & num2) << 1;
        return add(sum, carry);
    }

    private long sub(long num1, long num2) {
        return add(num1, add(~num2,  1));
    }

    private long multiply(long num1, long num2) {
        long a = num1 < 0 ? add(~num1, 1) : num1;
        long b = num2 < 0 ? add(~num2, 1) : num2;
        long result = 0;
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
        System.out.println(new Test_29_1().divide2(-2147483648
                , -1));

        System.out.println();
        System.out.println(~Integer.MIN_VALUE + 1);
        System.out.println(Integer.MIN_VALUE);
    }

}
