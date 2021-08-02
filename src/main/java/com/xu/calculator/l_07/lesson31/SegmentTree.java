package com.xu.calculator.l_07.lesson31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * java_study
 * 1）void add(int L, int R, int V) :  让数组arr[L…R]上每个数都加上V
 * 2）void update(int L, int R, int V) :  让数组arr[L…R]上每个数都变成V
 * 3）int sum(int L, int R) :让返回arr[L…R]这个范围整体的累加和
 * 怎么让这三个方法，时间复杂度都是O(logN)
 */
public class SegmentTree {
    public static class Segment {
        public int[] arr;
        // 累加和数组
        public int[] sum;
        // 懒更新数组
        public int[] lazy;
        // 更新数组
        public int[] update;
        // 更新状态数组
        public boolean[] change;

        public Segment(int[] source) {
            int len = arr.length + 1;
            arr = new int[len];
            System.arraycopy(source, 0, arr, 1, len);
            sum = new int[len << 2];
            lazy = new int[len << 2];
            update = new int[len << 2];
            change = new boolean[len << 2];
        }

        // 构建累加和数组
        public void build(int L, int R, int root) {
            if (L == R) {
                sum[root] = arr[root];
                return;
            }
            int mid = (L + R) >> 1;
            build(L, mid, root << 1);
            build(mid + 1, R, root << 1 | 1);
            pushUp(root);
        }

        public void pushUp(int root) {
            sum[root] = sum[root << 1] + sum[root << 1 | 1];
        }

        /**
         * 派发任务
         *
         * @param rt 需要派发的节点
         * @param ln 左边包含的节点个数
         * @param rn 右边包含的节点个数
         */
        public void pushDown(int rt, int ln, int rn) {
            if (change[rt]) {
                change[rt << 1] = true;
                change[rt << 1 | 1] = true;
                update[rt << 1] = update[rt];
                update[rt << 1 | 1] = update[rt];

                lazy[rt << 1] = 0;
                lazy[rt << 1 | 1] = 0;
                sum[rt << 1] = update[rt] * ln;
                sum[rt << 1 | 1] = update[rt] * rn;
                change[rt] = false;
            }
            if (lazy[rt] != 0) {
                sum[rt << 1] += lazy[rt] * ln;
                sum[rt << 1 | 1] += lazy[rt] * rn;
                lazy[rt << 1] += lazy[rt];
                lazy[rt << 1 | 1] += lazy[rt];
                lazy[rt] = 0;
            }
        }

        public void add(int L, int R, int V, int l, int r, int rt) {
            // 任务被全包了
            if (L <= l && R >= r) {
                lazy[rt] += V;
                sum[rt] += V * (r - l + 1);
                return;
            }
            // 任务需要下发
            int mid = (l + r) >> 1;
            pushDown(rt, mid - l + 1, r - mid);
            if (L <= mid) {
                add(L, R, V, l, mid, rt >> 1);
            }
            if (R >= mid) {
                add(L, R, V, mid + 1, r, rt >> 1 | 1);
            }
            pushUp(rt);
        }

        /**
         * 区间更新数值
         * @param L
         * @param R
         * @param V
         * @param l
         * @param r
         * @param rt
         */
        public void update(int L, int R, int V, int l, int r, int rt) {
            // 任务全包无需下发
            if (L <= l && r <= R) {
                update[rt] = V;
                change[rt] = true;
                lazy[rt] = 0;
                sum[rt] = V * (r - l + 1);
            }
            int mid = (l + r) << 1;
            pushDown(rt, mid - l + 1, r - mid);
            if (L <= mid) {
                update(L, R, V, l, mid, rt << 1);
            }

            if (R >= mid) {
                update(L, R, V, mid + 1, r, rt << 1 | 1);
            }
            pushUp(rt);
        }
    }

    public static void main(String[] args) {
        System.out.println(223 + 1);
        System.out.println(223 | 1);

        Object object = new Object();
        List list = new ArrayList<>();
    }
}
