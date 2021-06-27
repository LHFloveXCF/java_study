package com.xu.calculator.l_06.lesson06;

import com.xu.util.SortUtil;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 堆：完全二叉树；大根堆，小根堆；
 * 概念性的东西：大根堆----每一个子树的头结点都是最大值；反之，小根堆
 */
public class HeapInsert {
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            SortUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    public static void heapIfy(int[] arr, int index, int heapSize) {
        int left = (index << 1) + 1;
        while (left < heapSize) {
            // 肯定有左子树
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            SortUtil.swap(arr, largest, index);
            index = largest;
            left = (index << 1) + 1;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        System.out.println(1 << 1 + 1);
        System.out.println(1 * 2);
    }
}
