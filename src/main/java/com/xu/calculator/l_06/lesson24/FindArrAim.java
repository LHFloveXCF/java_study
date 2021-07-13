package com.xu.calculator.l_06.lesson24;

import java.util.LinkedList;

/**
 * java_study
 * 找出数组中满足条件的子数组之和
 */
public class FindArrAim {
    private static int right(int[] arr, int aim) {
        if (null == arr || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int count = 0;
        for (int L = 0; L < N; L++) {
            for (int R = L; R < N; R++) {
                int max = arr[L];
                int min = arr[L];
                for (int i = L + 1; i <= R; i++) {
                    max = Math.max(max, arr[i]);
                    min = Math.min(min, arr[i]);
                }
                if (max - min <= aim) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int right2(int[] arr, int aim) {
        if (null == arr || aim < 0) {
            return 0;
        }
        int count = 0;
        int N = arr.length;
        LinkedList<Integer> qMax = new LinkedList<>();
        LinkedList<Integer> qMin = new LinkedList<>();
        int R = 0;
        for (int L = 0; L < N; L++) {
            while (R < N) {
                while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[R]) {
                    qMax.pollLast();
                }
                qMax.addLast(R);
                while (!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[R])
                    qMin.pollLast();
                qMin.addLast(R);

                if (arr[qMax.peekFirst()] - arr[qMin.peekFirst()] > aim) {
                    break;
                }
                R++;
            }
            count += R - L;
            if (qMax.peekFirst() == L) {
                qMax.pollFirst();
            }
            if (qMin.peekFirst() == L) {
                qMin.pollFirst();
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 9};
        int w = 3;
        System.out.println(right(arr, w));
        System.out.println(right2(arr, w));
    }
}
