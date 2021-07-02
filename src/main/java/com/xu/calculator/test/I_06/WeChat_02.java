package com.xu.calculator.test.I_06;

import java.util.*;

/**
 * java_study
 */
public class WeChat_02 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,5,5,6,7,8,9,9};
//        check3(arr);
//        check4(arr);
//        check(arr);
        check5(arr);
    }


    public static void check5(int[] arr) {
        int index = 0;
        System.out.println(arr[index]);
        int des = arr[index++];
        while (index < arr.length) {
            if (arr[index] != des) {
                System.out.println(arr[index]);
                des = arr[index];
            }
            index++;
        }
    }

    // stack
    public static void check4(int[] arr) {
        int[] result = new int[arr.length];
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                int before = stack.pop();
                if (before != i) {
                    stack.push(i);
                }
                result[index++] = before;
            }
        }
        for (int i = 0; i <= index; i++) {
            System.out.println(result[i]);
        }
    }

    // array
    public static void check(int[] arr) {
        if (null == arr || arr.length < 1) {
            return;
        }
        int[] help = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (help[i] == 0) {
                int cur = arr[i];
                System.out.println(cur);
                for (int j=i+1; j<arr.length; j++) {
                    if (help[j] == 1) {
                        continue;
                    }
                    if (arr[j] == cur) {
                        help[j] = 1;
                    }
                }
            }
        }
    }

    // hashMap
    public static void check3(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], 0);
        }
        map.keySet().forEach(System.out :: println);
    }

    // 有序表
    public static void check2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
