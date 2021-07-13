package com.xu.calculator.l_06.lesson25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * java_study
 * 无重复元素的单调栈实现
 */
public class ArrStackNoRepeat {

    private static int[][] right2(int[] arr){
        if (null == arr || arr.length < 1) {
            return null;
        }
        int N = arr.length;
        int[][] ans = new int[N][2];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int j = stack.pop();
                ans[j][0] = stack.isEmpty() ? -1 : stack.peek();
                ans[j][1] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            ans[j][0] = stack.isEmpty() ? -1 : stack.peek();
            ans[j][1] = -1;
        }
        return ans;
    }

    private static List<Info> singleStack(int[] arr) {
        if (null == arr || arr.length < 1) {
            return null;
        }
        List<Info> ans = new ArrayList<>();
        // 这是一个数组下标为元素的栈
        Stack<Integer> indexStack = new Stack<>();
        int N = arr.length;
        indexStack.push(0);
        for (int i = 1; i < N; i++) {
            while (!indexStack.isEmpty() && arr[indexStack.peek()] > arr[i]) {
                indexStack.pop();
                int left = indexStack.isEmpty() ? -1 : indexStack.peek();
                Info info = new Info(left, i);
                ans.add(info);
            }
            indexStack.push(i);
        }
        while (!indexStack.isEmpty()) {
            indexStack.pop();
            int left = indexStack.isEmpty() ? -1 : indexStack.peek();
            Info info = new Info(left, -1);
            ans.add(info);
        }
        return ans;
    }

    // 暴力方法
    private static List<Info> right(int[] arr) {
        if (null == arr || arr.length < 1) {
            return null;
        }
        List<Info> ans = new ArrayList<>();
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            Info info = new Info(-1, -1);
            // 遍历每个元素
            for (int j = i; j >= 0; j--) {
                // 遍历左边元素,发现第一个小的元素break；
                if (arr[j] < arr[i]) {
                    info.left = j;
                    break;
                }
            }
            for (int k = i; k < N; k++) {
                // 遍历右边元素发现第一个小的元素break；
                if (arr[k] < arr[i]) {
                    info.right = k;
                    break;
                }
            }
            ans.add(info);
        }
        return ans;
    }

    private static class Info{
        public int left;
        public int right;

        public Info() {
        }

        public Info(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


    public static void main(String[] args) {
        int[] arr = {2,1,2,3};

        right(arr).forEach(System.out :: println);
//        singleStack(arr).forEach(System.out :: println);
        int[][] ans = right2(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
