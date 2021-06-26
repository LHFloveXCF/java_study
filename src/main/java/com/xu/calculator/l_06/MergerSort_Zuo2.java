package com.xu.calculator.l_06;

/**
 * java_study
 * 非递归
 */
public class MergerSort_Zuo2 {
    public static void sort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int step = 1;
        int N = arr.length;
        while (true) {
            int L = 0;
            while (L < N) {
                int M;
                int R;
                if ((N - 1 - L) >= step) {
                    M = L + step - 1;
                } else {
                    M = N - 1;
                }
                if (M == N -1) {
                    break;
                }
                if ((M + step) > N) {
                    R = N - 1;
                } else {
                    R = M + step;
                }
                merger(arr, M, L, R);
                L = R + 1;
            }
            if (step > (N >> 1)) {
                break;
            }
            step <<= 1;
        }
    }

    private static void merger(int[] arr, int m, int l, int r) {
        int[] temp = new int[r - l + 1];
        int left = l;
        int index = 0;
        int right = m + 1;
        while (left <= m && right <= r)
            temp[index++] = arr[left] < arr[right] ? arr[left++] : arr[right++];
        while (left <= m)
            temp[index++] = arr[left++];
        while (right <= r)
            temp[index++] = arr[right++];
        for (int i=0; i<temp.length; i++) {
            arr[l + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        System.out.println(2 >> 1);
    }
}
