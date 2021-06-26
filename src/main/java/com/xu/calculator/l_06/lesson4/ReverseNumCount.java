package com.xu.calculator.l_06.lesson4;

/**
 * java_study
 * 逆序对问题:给定一个数组，如果左边元素比 右边元素大，就可组成一对；找出所有的对数；
 * 解题思路：采用mergerSort的思想，利用最终的有序性，单调性，不回退，一路合并下去就可找到最终的answer
 */
public class ReverseNumCount {
    public static void main(String[] args) {
        int[] arr = {8, 8, 3, 0, 0, 1};
        System.out.println(findCount(arr));
    }
    public static int findCount(int[] arr) {
        // 边界条件的判断
        if (null == arr || arr.length < 2) {
            return 0;
        }
        int ans = process(arr, 0, arr.length - 1);
        return ans;
    }

    private static int process(int[] arr, int L, int R) {
        int ans = 0;
        if (L == R) {
            return ans;
        }
        int M = L + ((R - L) >> 1);
        ans += process(arr, L, M);
        ans += process(arr, M + 1, R);
        ans += merge(arr, M, L, R);
        return ans;
    }

    public static int merge(int[] arr, int M, int L, int R) {
        int answer = 0;
        int[] help = new int[R - L + 1];
        int index = 0;
        int m = M + 1;
        int l = L;
        while (l <= M && m <= R) {
            if (arr[l] > arr[m]) {
                help[index++] = arr[m++];
                answer += M - l + 1;
            } else {
                help[index++] = arr[l++];
            }
        }
        while (l <= L)
            help[index++] = arr[l++];
        while (m <= R)
            help[index++] = arr[m++];
        if (help.length >= 0) System.arraycopy(help, 0, arr, L, help.length);
        return answer;
    }
}
