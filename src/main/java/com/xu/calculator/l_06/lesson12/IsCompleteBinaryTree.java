package com.xu.calculator.l_06.lesson12;

import com.xu.calculator.entity.BinaryNode;

/**
 * java_study
 * 判断一颗二叉树是否是完全二叉树
 * 堆：一个二叉树都是从左到右，依次变满的；要么是满树，要么是在变满的路上
 * 解题思路：
 * 1、如果是空返回false；
 * 2、如果一个节点有右节点，但是没有左节点，返回false
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

    public static void main(String[] args) {
        BinaryNode head = BinaryNode.generate(2);
        BinaryNode.pre(head);
        System.out.println(isComplete(head));
    }

}
