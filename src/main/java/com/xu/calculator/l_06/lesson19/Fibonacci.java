package com.xu.calculator.l_06.lesson19;

/**
 * java_study
 * 斐波那契数列
 * 记录一个缓存表，因为斐波那契数列有很多重复计算，所以加一个缓存把计算过的值放入缓存中；
 * 这就是动态规划的影子；
 */
public class Fibonacci {
    private static int f(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(f(5));
    }
}
