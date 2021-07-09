package com.xu.calculator.l_06.lesson20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * java_study
 * N个人排队接咖啡
 * 有i台咖啡机,arr[i]表示第i台咖啡机冲一杯的时间
 * 求：N个人都接到咖啡的最后时间点数组
 * 思路：
 * 创建一个小根堆，堆里存放每台咖啡机的开始工作时刻和冲完一杯咖啡的时刻；
 * 想象出来N个人都很聪明，能预知等待哪台咖啡机能最快结束；
 * 这样从0-N进行尝试，然后求所有尝试的最小值，就是结果
 */
public class CoffeeGet {
    private static class Machine{
        public int timeLine;
        public int need;

        public Machine(int start, int need) {
            this.timeLine = start;
            this.need = need;
        }
    }

    private static class MyComparator implements Comparator<Machine> {

        @Override
        public int compare(Machine o1, Machine o2) {
            return o1.need + o1.timeLine - o2.need + o2.timeLine;
        }
    }

    /**
     *
     * @param arr   咖啡机生产数组
     * @param n     总共的人数
     * @return      最早结束的时刻
     */
    public static int[] minTime(int[] arr, int n) {
        if (null == arr || 0 == n) {
            return null;
        }
        PriorityQueue<Machine> pq = new PriorityQueue<>(new MyComparator());
        for (int i : arr) {
            Machine machine = new Machine(0, i);
            pq.add(machine);
        }
        int[] coffee = new int[n];
        for (int i=0; i<n; i++) {
            Machine cur = pq.poll();
            cur.timeLine = cur.timeLine + cur.need;
            coffee[i] = cur.timeLine;
            pq.add(cur);
        }
        return coffee;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(Arrays.toString(minTime(arr, 3)));
    }


}
