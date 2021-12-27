package com.leetcode;

import org.springframework.context.annotation.Bean;

/**
 * java_study
 * https://leetcode-cn.com/problems/remove-element/
 * 移除元素
 */
public class Test_27 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        if (length == 0) {
            return length;
        }
        int index = 0;
        int start = 0;
        while (index < length) {
            while (index < length && nums[index] == val) {
                index++;
            }
            if (index >= length) {
                break;
            }
            if (start != index) {
                nums[start] = nums[index];
            }
            start++;
            index++;
        }
        return start;
    }
}
