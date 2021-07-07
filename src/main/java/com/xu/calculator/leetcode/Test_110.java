package com.xu.calculator.leetcode;

/**
 * java_study
 */
public class Test_110 {
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

    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        Info f = f(root);
        return f.isBalance;
    }

    private Info f(TreeNode left) {
        if (null == left) {
            return new Info(true, 0);
        }

        Info leftInfo = f(left.left);
        Info rightInfo = f(left.right);
        int height = Math.max(leftInfo.height, rightInfo.height);
        boolean isBalance = false;
        if (leftInfo.isBalance && rightInfo.isBalance && Math.abs(leftInfo.height - rightInfo.height) <= 1) {
            isBalance = true;
        }
        return new Info(isBalance, height);
    }

    private static class Info{
        public boolean isBalance;
        public int height;

        public Info(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }
}
