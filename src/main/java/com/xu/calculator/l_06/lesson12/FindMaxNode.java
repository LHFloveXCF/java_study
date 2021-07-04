package com.xu.calculator.l_06.lesson12;

import com.xu.calculator.entity.BinaryNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树的头节点head，
 * 返回这颗二叉树中最大的二叉搜索子树的头节点
 * 分析可能性：
 * 左子树是二叉搜索树，右子树也是二叉搜索树，直接返回自己
 * 左子树有部分是二叉搜索树，可以从左子树中得到一个头结点；
 *  右子树可能是二叉搜索树：1、是，返回跟左子树去比较
 *                      2、不是，找到右子树中的二叉搜索树，返回
 *  比较两者；
 *
 */
public class FindMaxNode {
    public static BinaryNode findMaxNode(BinaryNode head) {
        Info info = process(head);
        if (null == info) {
            return null;
        }
        return info.head;
    }

    /**
     * 二叉树的递归套路
     * @param root  节点
     * @return      节点信息
     */
    private static Info process(BinaryNode root) {
        if (null == root) {
            return null;
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int min = root.value;
        if (leftInfo != null) {
            min = Math.min(leftInfo.min, min);
        }
        if (rightInfo != null) {
            min = Math.min(rightInfo.min, min);
        }
        int max = root.value;
        if (leftInfo != null) {
            max = Math.max(leftInfo.max, max);
        }
        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
        }
        int height = 0;
        BinaryNode head = null;

//        if (leftInfo != null) {
//            height = leftInfo.height;
//            head = leftInfo.head;
//        }
//        if (rightInfo != null) {
//            if (rightInfo.height > height) {
//                head = rightInfo.head;
//                height = rightInfo.height;
//            }
//        }
//        if ((leftInfo == null || (leftInfo.head == root.left && leftInfo.max < root.value))
//                && (rightInfo == null || (rightInfo.head == root.right && rightInfo.min > root.value))) {
//            head = root;
//            height = (null == leftInfo ? 0 : leftInfo.height) + (null == rightInfo ? 0 : rightInfo.height) + 1;
//        }

        if (leftInfo == null && rightInfo == null) {
            height = 1;
            head = root;
        }
        if (leftInfo != null && rightInfo == null) {
            height = leftInfo.height;
            head = leftInfo.head;
            if (leftInfo.head == root.left && leftInfo.max < root.value) {
                height += 1;
                head = root;
            }

        }
        if (leftInfo == null && rightInfo != null) {
            height = rightInfo.height;
            head = rightInfo.head;
            if (rightInfo.head == root.right && rightInfo.min > root.value) {
                height += 1;
                head = root;
            }
        }
        if (leftInfo != null && rightInfo != null) {
            height = Math.max(leftInfo.height, rightInfo.height);
            head = leftInfo.height >= rightInfo.height ? leftInfo.head : rightInfo.head;
            if (leftInfo.max < root.value && rightInfo.min > root.value
                    && leftInfo.head == root.left && rightInfo.head == root.right) {
                height = rightInfo.height + leftInfo.height + 1;
                head = root;
            }
        }
        return new Info(min, max, head, height);
    }

    private static class Info{
        // 最小值
        public int min;
        // 最大值
        public int max;
        public BinaryNode head;
        public int height;

        public Info(int min, int max, BinaryNode head, int height) {
            this.min = min;
            this.max = max;
            this.head = head;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int times = 1000;
        for (int i = 0; i < times; i++) {
            BinaryNode node = BinaryNode.generate2(maxLevel, maxValue);
            BinaryNode maxNode = findMaxNode(node);
            BinaryNode maxNode2 = findMaxNode2(node);
            if (maxNode != maxNode2) {
                System.out.println("Oops");
            }
        }
        System.out.println("finish");
    }

    private static BinaryNode findMaxNode2(BinaryNode root) {
        if (root == null) {
            return null;
        }
        if (getBSTSize(root) != 0) {
            return root;
        }
        BinaryNode left = findMaxNode2(root.left);
        BinaryNode right = findMaxNode2(root.right);
        return getBSTSize(left) >= getBSTSize(right) ? left : right;

    }

    private static int getBSTSize(BinaryNode root) {
        if (null == root) {
            return 0;
        }
        List<BinaryNode> arr = new ArrayList<>();
        in(root, arr);
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i).value >= arr.get(i + 1).value) {
                return 0;
            }
        }
        return arr.size();
    }

    /**
     * 二叉树的中序遍历
     * @param root  节点
     * @param arr   节点集合
     */
    private static void in(BinaryNode root, List<BinaryNode> arr) {
        if (null == root) {
            return;
        }
        in(root.left, arr);
        arr.add(root);
        in(root.right, arr);
    }


}
