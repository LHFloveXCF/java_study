package com.xu.calculator.l_06.lesson19;

/**
 * java_study
 * 杨辉三角
 */
public class TriangleArray {

    private static void printTriangle(int n) {
        if (n == 1) {
            System.out.println(1);
        }
        // allocate array
        int[][] triangleArray = new int[n][n];
        triangleArray[0][0] = 1;
        for (int i=2; i<=n; i++) {
            // i是行数
            triangleArray[i - 1][0] = 1;
            triangleArray[i - 1][i - 1] = 1;
        }
        // fill data in array
        for (int i = 3; i<= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                triangleArray[i - 1][j] = triangleArray[i - 2][j - 1] + triangleArray[i - 2][j];
            }
        }
        // print arry
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.printf("%4d", triangleArray[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printTriangle(7);
    }
}
