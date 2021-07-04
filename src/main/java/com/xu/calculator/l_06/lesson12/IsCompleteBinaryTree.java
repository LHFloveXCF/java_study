package com.xu.calculator.l_06.lesson12;

import com.xu.calculator.entity.BinaryNode;

/**
 * java_study
 * 判断一颗二叉树是否是完全二叉树
 * 堆：一个二叉树都是从左到右，依次变满的；要么是满树，要么是在变满的路上
 * 解题思路：
 * 1、如果是空返回false；
 * 2、如果一个节点有右节点，但是没有左节点，返回false
 * 上面的解题思路是错误的
 * 第一步：分析可能性
 * 第二步：求合集
 * 想要判断一颗树是否是完全二叉树，通过如下步骤：
 * 1）左右子树都是满树
 * 2）左满，右完全，左树高度 = 右树高度
 * 3）左完全，右满，左树高度 = 右树高度 + 1
 * 4）左完全，右完全，左树高度 = 右树高度 + 1
 */
public class IsCompleteBinaryTree {
    public static boolean isComplete(BinaryNode node) {
        if (null == node) {
            return false;
        }
        return process(node);
    }

    public static boolean process(BinaryNode node) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right != null) {
            return false;
        }
        boolean leftComplete = process(node.left);
        boolean rightComplete = process(node.right);
        return leftComplete && rightComplete;
    }
    // 套路主体信息
    private static class Info {
        public boolean isFull;
        public boolean isCBT;
        public int height;

        public Info(boolean isFull, boolean isCBT, int height) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
        }
    }

    private static Info process2(BinaryNode x){
        if (x == null) {
            return new Info(true, true, 0);
        }

        Info leftInfo = process2(x.left);
        Info rightInfo = process2(x.right);

        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        int height = Math.max(leftInfo.height, rightInfo.height);
        boolean isCBT = isFull;
        if (leftInfo.isFull && rightInfo.isCBT && leftInfo.height == rightInfo.height + 1) {
            isCBT = true;
        }
        if (leftInfo.isCBT && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
            isCBT = true;
        }
        return new Info(isFull, isCBT, height);
    }

    public static void main(String[] args) {
        BinaryNode head = BinaryNode.generate(2);
        BinaryNode.pre(head);
        System.out.println(isComplete(head));
    }

}
