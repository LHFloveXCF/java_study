package com.xu.calculator.l_06.lesson25;

/**
 * java_study
 *  https://leetcode-cn.com/problems/count-submatrices-with-all-ones
 *
 *
 *  给定一个二维数组matrix，其中的值不是0就是1，
 * 返回全部由1组成的最大子矩形，内部有多少个1
 */
public class CountSubMatricesWithAllOnes {
    private static int numSubmat(int[][] mat) {
        int total = 0;
        if (null == mat || mat.length < 1 || mat[0].length < 1) {
            return total;
        }
        int[] bottom = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                bottom[j] = mat[i][j] == 0 ? 0 : bottom[j] + mat[i][j];
            }
            total += getCountByBottom(bottom);
        }
        return total;
    }

    private static int getCountByBottom(int[] bottom) {
        int total = 0;
        int N = bottom.length;
        int[] stack = new int[N];
        int index = -1;// 这是一个指针；；；；；；
        for (int i = 0; i < N; i++) {
            while (index != -1 && bottom[stack[index]] >= bottom[i]) {
                int cur = stack[index--];
                if (bottom[cur] > bottom[i]) {
                    int left = index == -1 ? -1 : stack[index];
                    int n = i - left - 1;
                    int down = Math.max(left == -1 ? 0 : bottom[left], bottom[i]);
                    total += (bottom[cur] - down) * count(n);
                }
            }
            stack[++index] = i;
        }

        while (index != -1) {
            int cur = stack[index--];
            int left = index == -1 ? -1 : stack[index];
            int n = bottom.length - left - 1;
            int down = left == -1 ? 0 : bottom[left];
            total += count(n) * (bottom[cur] - down);
        }

        return total;
    }

    private static int count(int n) {
        return (n * (n + 1)) >> 1;
    }


}
