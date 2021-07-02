package com.xu.calculator.l_06.lesson11;

import com.xu.calculator.entity.BinaryNode;

/**
 * java_study
 * 二叉树的最大深度
 */
public class MaxDepth {
    public static int maxDepth(BinaryNode root) {
        if (null == root) {
            return 0;
        }
        return process(root);
    }
    public static int process(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = process(node.left);
        int rightMax = process(node.right);
        return Math.max(leftMax, rightMax) + 1;
    }
}
