package com.xu.calculator.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * java_study
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 二叉树的后序遍历
 */
public class Test_145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        process(root, result);
        return result;
    }

    private void process(TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }
        process(root.left, result);
        process(root.right, result);
        result.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Stack<TreeNode> help = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        help.push(root);
        while (!help.isEmpty()) {
            TreeNode node = help.pop();
            stack.push(node);
            if (null != node.left) {
                help.push(node.left);
            }
            if (null != node.right) {
                help.push(node.right);
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop().val);
        }
        return result;
    }
}
