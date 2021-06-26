package com.xu.calculator;

/**
 * java_study
 */
public class InsertArray {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 1) {
            if (target > nums[0] || target < nums[0]) {
                return 0;
            }
        }

        if ((nums[0] < nums[1] && target < nums[0]) || nums[0] > nums[1] && target > nums[0]) {
            return 0;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] < target && nums[i + 1] >= target) || (nums[i] > target && nums[i + 1] <= target)) {
                return i + 1;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
//        int insert = searchInsert(new int[]{1, 6, 8, 10}, 7);
//        System.out.println(insert);

        int[] test = new int[]{0,0,1,1,1,2,2,3,3,4};
        int len = remove3(test);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.println(test[i]);
        }

    }

    public static int remove(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j=i + 1; j<nums.length; j++) {
                if (nums[i] == nums[j] && j <= nums.length - count - 1) {
                    swap(nums, j, nums.length - count - 1);
                    count++;
                }
            }
        }

        return nums.length - count;
    }

    static int remove2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - count; i++) {
            for (int j=i + 1; j<nums.length; j++) {
                if (nums[i] == nums[j] && j <= nums.length - count - 1) {
                    int k = j;
                    while (k < nums.length - count - 1) {
                        swap(nums, k, k + 1);
                        k++;
                    }
                    count++;
                    j--;
                }
            }
        }

        return nums.length - count;
    }

    static int remove3(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int fast = 1; int slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public static void swap(int[] nums, int begin, int end) {
//        int tem = nums[begin];
//        nums[begin] = nums[end];
//        nums[end] = tem;

        nums[begin] = nums[begin] ^ nums[end];
        nums[end] = nums[begin] ^ nums[end];
        nums[begin] = nums[begin] ^ nums[end];
    }
}
