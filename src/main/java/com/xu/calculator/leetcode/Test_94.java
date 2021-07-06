package com.xu.calculator.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * java_study
 */
public class Test_94 {
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

    public List<Integer> inorderTraversal1(TreeNode root) {
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
        result.add(root.val);
        process(root.right, result);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while (null != cur.left) {
            stack.push(cur.left);
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            cur = node.right;
            while (null != cur) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return result;
    }

}
