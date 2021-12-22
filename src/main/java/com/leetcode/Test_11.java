package com.leetcode;

/**
 * java_study
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * 指针的牛逼之处，跟数组链表有关的题，要考虑用指针来处理
 */
public class Test_11 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        int i = new Test_11().maxArea(arr);
        System.out.println(i);
    }

    private int maxArea(int[] arr) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int result = 0;
        while (leftIndex < rightIndex) {
            int gap = rightIndex - leftIndex;
            result = Math.max(result, arr[arr[leftIndex] >= arr[rightIndex] ? rightIndex-- : leftIndex++] * gap);
        }
        return result;
    }

    public int maxArea1(int[] height) {
        int result = 0;
        int length = height.length;
        for (int i = 0; i < length - 1; i++) {
            int value = height[i];
            for (int j = i + 1; j < length; j++) {
                if (height[j] < value) {
                    result = Math.max(result, height[j] * (j - i));
                } else {
                    result = Math.max(result, value * (j - i));
                }
            }
        }
        return result;
    }

}
