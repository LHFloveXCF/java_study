package com.leetcode;

import sun.security.provider.Sun;

import java.util.*;

/**
 * java_study
 * 最接近的三数之和
 */
public class Test_16 {
    public int sum(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int subValue = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                int sub = Math.abs(sum - target);
                if (sub < subValue) {
                    subValue = sub;
                    result = sum;
                } else if (sub == subValue && sum >= 0) {
                    result = sum;
                }

                if (sum > target) {
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    R--;
                } else if (sum < target) {
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    L++;
                } else {
                    return result;
                }
            }
        }
        return result;
    }

    public int sum1(int[] nums, int target) {
        int length = nums.length;
        int subValue = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int sub = Math.abs(sum - target);
                    if (sub < subValue) {
                        subValue = sub;
                        result = sum;
                    } else if (sub == subValue && sum >= 0) {
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
    public int threeSumClosest1(int[] nums, int target) {
        Set<Integer> sumList = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    sumList.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        int subValue = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;
        for (Integer integer : sumList) {
            int sub = Math.abs(integer - target);
            if (sub < subValue) {
                subValue = sub;
                result = integer;
            } else if (sub == subValue && integer >= 0) {
                result = integer;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        System.out.println(new Test_16().sum(nums, 1));
    }
}
