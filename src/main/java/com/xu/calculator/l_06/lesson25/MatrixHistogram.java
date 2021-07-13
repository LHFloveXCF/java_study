package com.xu.calculator.l_06.lesson25;

/**
 * java_study
 * https://leetcode-cn.com/problems/maximal-rectangle/
 */
public class MatrixHistogram {

    public int maximalRectangle(char[][] matrix) {
        if (null == matrix || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] arr = new int[matrix[0].length];
        for (char[] chars : matrix) {
            for (int j = 0; j < chars.length; j++) {
                arr[j] = chars[j] == '0' ? 0 : arr[j] + 1;
            }
            // 求最大直方图的和
            max = Math.max(max, getMaximalHistogram(arr));
        }
        return max;
    }

    private static int getMaximalHistogram(int[] arr) {
        int N = arr.length;
        int[] stack = new int[N];
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            while (index != -1 && arr[stack[index]] >= arr[i]) {
                int j = stack[index--];
                int left = index != -1 ? stack[index] : -1;
                max = Math.max(max, (arr[j] * (i - left - 1)));
            }
            stack[++index] = i;
        }
        while (index != -1) {
            int j = stack[index--];
            int right = arr.length;
            int left = index != -1 ? stack[index] : -1;
            max = Math.max(max, (arr[j] * (right - left - 1)));
        }
        return max;
    }


}
