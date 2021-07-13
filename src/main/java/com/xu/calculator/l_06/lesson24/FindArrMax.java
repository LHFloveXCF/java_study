package com.xu.calculator.l_06.lesson24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * java_study
 * 双端队列
 *
 */
public class FindArrMax {
    private static List<Integer> findArrMax(int[] arr, int w) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> qMax = new LinkedList<>();
        int r = 0;
        while (r < arr.length) {
            while (!qMax.isEmpty() && arr[qMax.peekLast()] < arr[r]) {
                qMax.pollLast();
            }
            qMax.addLast(r);
            if (r >= w - 1) {
                result.add(arr[qMax.peekFirst()]);
            }
            r++;
            if (r - w == qMax.peekFirst()) {
                qMax.pollFirst();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,5,4,3,3,6,7};
        int w = 3;
        findArrMax(arr, w).forEach(System.out::println);
    }
}
