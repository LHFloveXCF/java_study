package com.xu.calculator.l_06.lesson12;

import com.xu.calculator.entity.BinaryNode;

/**
 * 是否是搜索二叉树
 * 分析可能性：
 * 1）有左子树，左子树必须是搜索二叉树
 * 2）有右子树，右子树必须是搜索二叉树
 * 3）左子树的最大值，比头结点小
 * 4）右子树的最小值，比头结点大
 */
public class IsBinarySearchTree {
    public static void main(String[] args) {
        BinaryNode node = BinaryNode.generate2(4,10);
        BinaryNode.pre(node);
        System.out.println(isBinarySearchTree(node));
    }
    public static boolean isBinarySearchTree(BinaryNode head) {
        if (null == head) {
            return true;
        }
        Info info = process(head);
        return info == null || info.isBST;
    }

    private static class Info {
        public boolean isBST;
        public int min;
        public int max;

        public Info(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    private static Info process(BinaryNode head) {
        if (null == head) {
            return null;
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int min = head.value;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.max);
        }
        int max = head.value;
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
        }
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
        }

        boolean isBST = true;
        if (leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }
        if (leftInfo != null && leftInfo.min < head.value) {
            isBST = false;
        }
        if (rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }
        if (rightInfo != null && rightInfo.max > head.value) {
            isBST = false;
        }
        return new Info(isBST, min, max);
    }

}
