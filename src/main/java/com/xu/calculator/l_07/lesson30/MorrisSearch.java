package com.xu.calculator.l_07.lesson30;

import com.xu.calculator.entity.BinaryNode;

/**
 * java_study
 * 给定一棵二叉树的头节点head
 * 求以head为头的树中，最小深度是多少？
 *
 *
 * 解题思路：
 * 1,先搞定Morris序
 * 2,分析目标问题需要的变量；
 * 3,用二叉树递归序进行实现，不是所有的二叉树递归序可以实现的题目都能改写成Morris；
 * 4,
 */
public class MorrisSearch {

    public static int morrisMin(BinaryNode head) {
        if (null == head) {
            return 0;
        }
        BinaryNode cur = head;
        BinaryNode mostRight;
        int curLevel = 1;
        int min = Integer.MAX_VALUE;
        while (null != cur) {
            mostRight = head.left;
            if (null != mostRight) {
                int mostRightLevel = 1;
                while (null != mostRight.right && cur != mostRight.right) {
                    mostRightLevel++;
                    mostRight = mostRight.right;
                }
                if (mostRight.right == cur) {
                    if (null == mostRight.left) {
                        min = Math.min(min, curLevel);
                    }
                    curLevel -= mostRightLevel;
                    mostRight.right = null;
                } else {
                    curLevel++;
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
            } else {
                curLevel++;
            }
            cur = cur.right;
        }
        int finalRight = 1;
        cur = head;
        while (cur.right != null) {
            finalRight++;
            cur = cur.right;
        }

        if (null == cur.left) {
            min = Math.min(min, finalRight);
        }
        return min;
    }

    public static int findMin(BinaryNode head) {
        if (null == head) {
            return 0;
        }
        return process(head);
    }

    private static int process(BinaryNode head) {
        if (null == head) {
            return 0;
        }
        int leftLen = process(head.left);
        int rightLen = process(head.right);
        return 1 + Math.min(leftLen, rightLen);
    }
}
