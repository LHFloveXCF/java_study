package com.xu.calculator.l_06.lesson18;

/**
 * java_study
 * 汉诺塔问题
 */
public class Hanoi {
    /**
     * 汉诺塔问题解法1
     * @param n     最大层数
     */
    private static void leftToRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 from left to right");
            return;
        }
        leftToMid(n - 1);
        System.out.println("Move " + n + " from left to right");
        midToRight(n - 1);
    }

    private static void midToRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 from mid to right");
            return;
        }
        midToLeft(n - 1);
        System.out.println("Move " + n + " from mid to right");
        leftToRight(n - 1);
    }

    private static void midToLeft(int n) {
        if (n == 1) {
            System.out.println("Move 1 from mid to left");
            return;
        }
        midToRight(n - 1);
        System.out.println("Move " + n + " from mid to left");
        rightToLeft(n - 1);
    }

    private static void leftToMid(int n) {
        if (n == 1) {
            System.out.println("Move 1 from left to mid");
            return;
        }
        leftToRight(n - 1);
        System.out.println("Move " + n + " from left to mid");
        rightToMid(n - 1);
    }

    private static void rightToMid(int n) {
        if (n == 1) {
            System.out.println("Move 1 from right to mid");
            return;
        }
        rightToLeft(n - 1);
        System.out.println("Move " + n + " from right to mid");
        leftToMid(n - 1);
    }

    private static void rightToLeft(int n) {
        if (n == 1) {
            System.out.println("Move 1 from right to left");
            return;
        }
        rightToMid(n - 1);
        System.out.println("Move " + n + " from right to left");
        midToLeft(n - 1);
    }

    private static void process(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("Move " + n + " from " + from + " to " + to);
            return;
        }
        process(n - 1, from, other, to);
        System.out.println("Move " + n + " from " + from + " to " + to);
        process(n - 1, other, to, from);
    }

    public static void main(String[] args) {
//        leftToRight(3);
        process(3, "left", "right", "mid");
    }

}
