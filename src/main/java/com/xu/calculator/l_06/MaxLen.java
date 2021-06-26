package com.xu.calculator.l_06;

import com.sun.org.apache.regexp.internal.RE;

/**
 * java_study
 * 二叉树的最大深度
 */
public class MaxLen {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return depth(root, 1);
    }

    public int depth(TreeNode root, int len) {
        if (root == null) {
            return len;
        }
        len++;
        int left = depth(root.left, 1);
        int right = depth(root.right, 1);
        return Math.max(left, right);
    }
}
