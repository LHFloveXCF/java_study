package com.mt.test;

/**
 * 计算需要的羽翼碎片数量
 */
public class CalcWingCounts {
    /**
     * 1 - 20
     * 2 - 3_1 - 3_20 - 60
     * 3 - 3_2 - 3_3_1 - 3_3_20 = 180
     * 4 - 3_3 - 3_3_2 - 3_3_3_1 - 3_3_3_20 = 540
     * @param n     羽翼阶数
     * @return      羽翼碎片的数量
     */
    public static int calcWingCounts(int n) {
        if (n == 0) {
            return 0;
        }
        return process(n);
    }

    private static int process(int n) {
        if (n == 1) {
            return 20;
        }
        return 3 * process(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(calcWingCounts(1));
    }
}
