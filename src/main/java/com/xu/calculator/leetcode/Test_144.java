package com.xu.calculator.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * java_study
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Test_144 {
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
    public List<Integer> preorderTraversal1(TreeNode root) {
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
        result.add(root.val);
        process(root.left, result);
        process(root.right, result);
    }

    // 非递归实现
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if (null !=pop.right) {
                stack.push(pop.right);
            }
            if (null != pop.left) {
                stack.push(pop.left);
            }
        }
        return result;
    }
}
