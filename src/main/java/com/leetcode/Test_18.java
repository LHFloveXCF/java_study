package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * java_study
 * 四数之和
 */
public class Test_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        /*if (nums[0] > target) {
            return result;
        }*/

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            /*if (nums[i] > target) {
                return result;
            }*/
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = length - 1; j > i + 2; j--) {
                if (j < length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                int L = i + 1;
                int R = j - 1;
                while (L < R) {
                    long sum = nums[i] + nums[j] +nums[L] +nums[R];
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
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[L]);
                        temp.add(nums[R]);
                        result.add(temp);
                        while (L < R && nums[R] == nums[R - 1]) {
                            R--;
                        }
                        while (L < R && nums[L] == nums[L + 1]) {
                            L++;
                        }
                        L++;
                        R--;
                    }
                }

            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] goal = new int[] {1,-2,-5,-4,-3,3,3,5};
        System.out.println(new Test_18().fourSum(goal, -11));
    }
}
