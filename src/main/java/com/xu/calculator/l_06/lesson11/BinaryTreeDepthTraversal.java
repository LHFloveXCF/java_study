package com.xu.calculator.l_06.lesson11;

import com.xu.calculator.entity.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java_study
 * 二叉树的宽度遍历
 */
public class BinaryTreeDepthTraversal {
    public static void partition(BinaryNode head) {
        if (null == head) {
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            BinaryNode node = queue.remove();
            System.out.println(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryNode node = BinaryNode.generate(5);
        BinaryNode.pre(node);
        partition(node);
    }
}
