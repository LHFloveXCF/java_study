package com.xu.calculator.l_06.lesson25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * java_study
 * 可能有重复数据的数组
 * 解题思路：用链表存储数据
 *
 * [2,3,4,5,4,5,12]
 */
public class ArrStackRepeat {
    public static int[][] right(int[] arr) {
        if (null == arr || arr.length < 1) {
            return null;
        }
        int N = arr.length;
        int[][] ans = new int[N][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> list = stack.pop();
                for (Integer index : list) {
                    ans[index][0] = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                    ans[index][1] = i;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> list = stack.pop();
            for (Integer index : list) {
                ans[index][0] = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                ans[index][1] = -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4,4,3};
        int[][] right = right(arr);
        for (int i = 0; i < right.length; i++) {
            System.out.println(Arrays.toString(right[i]));
        }
    }











}
