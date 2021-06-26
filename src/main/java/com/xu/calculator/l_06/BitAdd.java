package com.xu.calculator.l_06;

/**
 * java_study
 */
public class BitAdd {
    public static int add(int a, int b) {
        int sum = a;
        while (b!= 0) {
            sum = a ^ b;
            b = ((a & b) << 1);
            a = sum;
        }
        return sum;
    }

    public static int negative(int a) {
        return add(~a, 1);
    }

    public static int minus(int a, int b) {
        return add(a, negative(b));
    }

    public static boolean isNegative(int a) {
        return !(a < 0);
    }

    public static int multi(int a, int b) {
        int ans = 0;
        while (b != 0) {
            if ((b & 1) > 0) {
                ans = add(ans, a);
            }
            a <<= 1;
            b >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(minus(-5, 3));
        System.out.println(multi(6, 3));
    }
}
