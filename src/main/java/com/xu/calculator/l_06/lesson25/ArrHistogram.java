package com.xu.calculator.l_06.lesson25;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * java_study
 * 给定一个非负数组arr，代表直方图
 * 返回直方图的最大长方形面积
 */
public class ArrHistogram {
    public static int histogram(int[] heights) {
        if (null == heights || heights.length < 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int N = heights.length;
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[stack.peek().get(0)] > heights[i]) {
                List<Integer> list = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                max = Math.max(max, (i - left - 1) * heights[list.get(0)]);
            }
            if (!stack.isEmpty() && heights[stack.peek().get(0)] == heights[i]) {
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> list = stack.pop();
            int right = heights.length;
            int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            max = Math.max(max, (right - left - 1) * heights[list.get(0)]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4};
        System.out.println(histogram(arr));
    }
}
