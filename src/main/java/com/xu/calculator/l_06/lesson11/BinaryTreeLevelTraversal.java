package com.xu.calculator.l_06.lesson11;

import com.xu.calculator.entity.BinaryNode;

import java.util.Stack;

/**
 * java_study
 * 二叉树的分层遍历（深度遍历）
 * 用栈来处理
 */
public class BinaryTreeLevelTraversal {
    public static void partition(BinaryNode node) {
        if (null == node) {
            System.out.println("null");
            return;
        }
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            BinaryNode pop = stack.pop();
            System.out.println(pop.value + "---->");
            if (null != pop.right) {
                stack.push(pop.right);
            }
            if (null != pop.left) {
                stack.push(pop.left);
            }
        }
    }

    public static void main(String[] args) {
        BinaryNode root = BinaryNode.generate2(5, 100);
        BinaryNode.pre(root);
        System.out.println();
        partition(root);
    }
}
