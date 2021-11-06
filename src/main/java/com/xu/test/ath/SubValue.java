package com.xu.test.ath;

/**
 * java_study
 */
public class SubValue {
    private static int count;

    public static void main(String[] args) {
        int value = 38;
        int subNum = 3;
        calcCount(38, 3);
        System.out.println(count);
        System.out.println(SubValue.count);
    }

    private static void calcCount(int value, int num) {
        if (17 == value) {
            return;
        }
        count++;
        calcCount(value - num, num);
    }
}
