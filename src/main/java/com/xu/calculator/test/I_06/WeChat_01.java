package com.xu.calculator.test.I_06;

import com.xu.util.SortUtil;

import java.util.Stack;

/**
 * java_study
 * 不使用递归实现斐波那契数列
 */
public class WeChat_01 {
    public static int sum(int n) {
        int[] res = {0, 1};
        if (n < 2) {
            return res[n];
        }
        int first = 0;
        int next = 1;
        int cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = first + next;
            first = next;
            next = cur;
        }
        return cur;
    }

    public static int sum3(int n) {
        int[] res = {0, 1};
        if (n < 2) {
            return res[n];
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(1);
        for (int i = 2; i < n; i++) {
            int second = stack.pop();
            int first = stack.pop();
            stack.push(second);
            stack.push(first + second);
        }
        return stack.pop();
    }

    public static int sum4(int n) {
        System.out.println(34 % 1000000007);
        for (int i = 2; i <= n; i++) {
            System.out.println(i);
        }
        return 1;
    }

    public static int sum2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return sum2(n - 1) + sum2(n - 2);
    }

    public static void main(String[] args) {
//        System.out.println(sum4(9));
        int[] nums = {5, 2, 3, 1};
        SortUtil.print(sortArray2(nums));

    }

    public static int[] sortArray(int[] nums) {
        if (null == nums || nums.length < 2) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    public static int[] sortArray2(int[] nums) {
        if (null == nums || nums.length < 2) {
            return nums;
        }
        process(nums, 0, nums.length - 1);
        return nums;
    }

    private static void process(int[] nums, int L, int R) {
        if (L == R) {
            return;
        }
        int[] range = partition(nums, L, R);
        if (range[0] > 0) {
            process(nums, L, range[0]);
        }
        process(nums, range[1], R);
    }

    private static int[] partition(int[] nums, int l, int r) {
        int little = l - 1;
        int more = r;
        int cur = l;
        int des = nums[r];
        while (cur < more) {
            if (nums[cur] < des) {
                swap(nums, cur++, ++little);
            } else if (nums[cur] > des) {
                swap(nums, cur, --more);
            } else {
                cur++;
            }
        }
        swap(nums, r, more);
        return new int[]{little, more};
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
