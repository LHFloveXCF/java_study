package com.xu.calculator.l_08.lesson39;

/**
 * java_study
 * 连续正数和的数
 * n > 1;
 * 3 = 1 + 2;
 * 5 = 2 + 3;
 * 6 = 1 + 2 + 3;
 * 7 = 3 + 4;
 * 9 = 2 + 3 + 4;
 * ....
 */
public class ContinueNumSum {
    private static boolean force(int n) {
        for (int i = 1; i <= n; i++) {
            int sum = i;
            for (int j = i + 1; j <= n; j++) {
                if (sum + j > n) {
                    break;
                } else if (sum + j == n) {
                    return true;
                } else
                    sum += j;
            }
        }
        return false;
    }

    private static boolean awesome(int n) {
        return n != (n & (-n + 1));
    }

    public static void main(String[] args) {

//        int n = 100;
//        for (int i = 0; i < n; i++) {
//            System.out.println(i + " " + force(i));
//        }

        System.out.println(force(4));
        System.out.println(awesome(4));
    }
}
