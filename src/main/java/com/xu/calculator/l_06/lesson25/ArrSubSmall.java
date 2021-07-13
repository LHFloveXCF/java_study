package com.xu.calculator.l_06.lesson25;

import com.xu.util.PrintUtils;

/**
 * java_study
 */
public class ArrSubSmall {
    private static int subSmall(int[] arr) {
        if (null == arr || arr.length < 1) {
            return 0;
        }
        int N = arr.length;
        int[][] smallArr;
        int[] sum = new int[N];
        sum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sum[i] += sum[i - 1] + arr[i];
        }
        smallArr = ArrStackRepeat.right(arr);

        PrintUtils.printInt2Arr(smallArr);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < smallArr.length; i++) {
            int[] index = smallArr[i];
            int left = index[0] == -1 ? i : index[0] - 1;
            int right = index[1] == -1 ? i : index[1] - 1;
            int total = sum[right] - sum[left];
            max = Math.max(max, total * arr[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 1, 3, 4, 5, 5, 4};
        System.out.println(subSmall(arr));
    }
}
