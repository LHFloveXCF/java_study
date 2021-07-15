package com.xu.calculator.l_06.lesson25;

import java.util.Stack;

/**
 * java_study
 * 数组中子数组中最小值的累加和；
 * https://leetcode-cn.com/problems/sum-of-subarray-minimums/
 */
public class SubOfSubArrayMinimums {

    private static int sumSubarrayMins1(int[] arr) {
        if (null == arr || arr.length < 1) {
            return 0;
        }
        int N = arr.length;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int min = arr[i];
                for (int k = i + 1; k <= j; k++) {
                    min = Math.min(min, arr[k]);
                }
                ans += min;
            }
        }
        return ans;
    }

    // no repeat
    private static int sumSubarrayMins2(int[] arr) {
        if (null == arr || arr.length < 1) {
            return 0;
        }
        int ans = 0;
        int N = arr.length;
        int[] stack = new int[N];
        int index = -1;
        for (int i = 0; i < N; i++) {
            while (index != -1 && arr[stack[index]] >= arr[i]) {
                int cur = stack[index--];
                int left = index != -1 ? stack[index] : -1;
                int count = (i - cur) * (cur - left);
                ans += arr[cur] * count;
            }
            stack[++index] = i;
        }
        while (index != -1) {
            int cur = stack[index--];
            int left = index != -1 ? stack[index] : -1;
            int right = arr.length;
            int count = (right - cur) * (cur - left);
            ans += count * arr[cur];
        }
        return ans;
    }

    private static int sumSubarrayMins(int[] arr) {
        if (null == arr || arr.length < 1) {
            return 0;
        }
        int[] left = leftEqualArr(arr);
        int[] right = rightEqualArr(arr);
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            long l = i - left[i];
            long r = right[i] - i;
            ans += l * r * (long) arr[i];
            ans %= 1000000007;
        }
        return (int) ans;
    }

    /**
     * 找到左边比i小的最近元素
     * @param arr
     * @return
     */
    private static int[] leftEqualArr(int[] arr) {
        int N = arr.length;
        int[] left = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            left[stack.pop()] = -1;
        }
        return left;
    }

    private static int[] rightEqualArr(int[] arr) {
        int N = arr.length;
        int[] right = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            right[stack.pop()] = N;
        }
        return right;
    }

    public static void main(String[] args) {
//        int[] arr = {3, 1, 2, 4};
//        int[] arr = {11,81,94,43,3};
        int[] arr = {71,55,82,55};
        System.out.println(sumSubarrayMins2(arr));
        System.out.println(sumSubarrayMins1(arr));
    }
}
