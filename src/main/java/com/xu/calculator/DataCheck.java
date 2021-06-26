package com.xu.calculator;

import com.xu.calculator.l_06.MergerSort2;
import com.xu.calculator.l_06.MergerSort_Zuo;
import com.xu.calculator.l_06.MergerSort_Zuo2;
import com.xu.calculator.l_06.lesson4.MergerSort;
import com.xu.util.SortUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * java_study
 */
public class DataCheck {
    public static int[] generateArr(int len) {
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(len);
        }
        return arr;
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                int j = i + 1;
                while (j < nums.length - 1 && nums[j] == val)
                    j++;
                if (nums[j] == val) {
                    nums[i] = 0;
                    break;
                } else {
                    nums[i] = nums[j];
                    nums[j] = val;
                    count++;
                }
            } else {
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static void check() {
        int len = 50;
        int[] arr = generateArr(len);
        int[] arr2 = new int[len];
        System.arraycopy(arr, 0, arr2, 0, len);

        SortUtil.print(arr);

        System.out.println("---------------------------");
        SortUtil.print(arr2);

        Arrays.sort(arr);
//        InsertSort.sort(arr2);
//        SelectionSort.sort(arr2);
//        BubbleSort.sort(arr2);
//        ShellSort.sort(arr2);
//        MergerSort_Zuo.sort(arr2);
//        MergerSort_Zuo2.sort(arr2);
//        MergerSort2.sort(arr2);
        MergerSort.sort(arr2);
        SortUtil.print(arr2);
        boolean isRight = true;
        for (int i = 0; i < len; i++) {
            if (arr[i] != arr2[i]) {
                isRight = false;
                break;
            }
        }
        System.out.println("最终结果：" + isRight);
    }

    public static void main(String[] args) {
        check();
//        removeElement(new int[]{3,2,2,3}, 3);
    }
}
