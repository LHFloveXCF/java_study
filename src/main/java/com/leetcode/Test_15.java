package com.leetcode;

import java.util.*;

/**
 * java_study
 * 指针的重要性
 */
public class Test_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int L = i + 1;
            int R = length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum > 0) {
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[L]);
                    temp.add(nums[R]);
                    result.add(temp);
                    // 去重操作
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                }
            }
        }
        return result;
    }

    // 超时了
    public List<List<Integer>> threeSum4(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new ArrayList<>();
        }
        int length = nums.length;
        int min = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        if (min > 0 || max < 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Map<Integer, Integer>> noRepeat = new ArrayList<>();
        // 暴力尝试
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        putMap(temp, result, noRepeat);
                    }
                }
            }
        }
        return result;

    }

    private void putMap(List<Integer> goal, List<List<Integer>> result, List<Map<Integer, Integer>> noRepeat) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer integer : goal) {
            if (map.containsKey(integer)) {
                map.put(integer, map.get(integer) + 1);
            } else {
                map.put(integer, 1);
            }
        }
        if (!contain(noRepeat, map)) {
            noRepeat.add(map);
            result.add(goal);
        }
    }

    private boolean contain(List<Map<Integer, Integer>> noRepeat, Map<Integer, Integer> map) {
        if (noRepeat.isEmpty()) {
            return false;
        }
        boolean contain = false;
        for (Map<Integer, Integer> integerMap : noRepeat) {
            boolean innerContain = true;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (!integerMap.containsKey(entry.getKey())) {
                    innerContain = false;
                } else if (!integerMap.get(entry.getKey()).equals(entry.getValue())) {
                    innerContain = false;
                }
            }
            if (innerContain) {
                contain = true;
            }
        }
        return contain;
    }

    private boolean contain(List<List<Integer>> source, List<Integer> goal) {
        boolean contain = false;
        if (source.isEmpty()) {
            return false;
        }
        for (List<Integer> list : source) {
            boolean innerContain = true;
            for (Integer integer : list) {
                if (!goal.contains(integer)) {
                    innerContain = false;
                    break;
                }
            }
            if (innerContain) {
                contain = true;
                break;
            }
        }
        return contain;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new ArrayList<>();
        }
        int length = nums.length;
        int min = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        if (min > 0 || max < 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> noRepeat = new HashSet<>();
        // 暴力尝试
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        if (noRepeat.contains(nums[i]) && noRepeat.contains(nums[j]) && noRepeat.contains(nums[k])) {
                            continue;
                        }
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        noRepeat.addAll(temp);
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new ArrayList<>();
        }
        int length = nums.length;
        int min = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        if (min > 0 || max < 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        // 暴力尝试
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        if (result.contains(temp)) {
                            continue;
                        }
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }


    // 时间复杂度太高
    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new ArrayList<>();
        }
        int[] hello = nums;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (hello[j + 1] < hello[j]) {
                    int temp = hello[j + 1];
                    hello[j + 1] = hello[j];
                    hello[j] = temp;
                }
            }
        }
        if (hello[0] > 0 || hello[length - 1] < 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        // 暴力尝试
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        if (result.contains(temp)) {
                            continue;
                        }
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 0, 1, 1, -1, -5, -5, 3, -3, -3, 0};

        System.out.println(new Test_15().threeSum(nums));

    }
}
