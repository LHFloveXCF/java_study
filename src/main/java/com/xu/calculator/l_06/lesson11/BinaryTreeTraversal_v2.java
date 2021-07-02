package com.xu.calculator.l_06.lesson11;

import com.xu.calculator.entity.BinaryNode;

import java.util.Stack;

/**
 * java_study
 * 非递归版本
 * 一定要用栈结构，潜移默化的知识
 */
public class BinaryTreeTraversal_v2 {

    public static void main(String[] args) {
        BinaryNode[] nodes = new BinaryNode[10];
        for (int i = 0; i < 10; i++) {
            nodes[i] = new BinaryNode(i);
        }
        for (int i = 0; i < 10; i++) {
            if (i * 2 + 1 < 10) {
                nodes[i].left = nodes[i * 2 + 1];
            }
            if (i * 2 + 2 < 10) {
                nodes[i].right = nodes[i * 2 + 2];
            }
        }
        BinaryTreeTraversal.pre(nodes[0]);
        System.out.println("***********");
        pre(nodes[0]);
        System.out.println("***********");
        pre2(nodes[0]);
    }

    public static void pre2(BinaryNode head) {
        if (null == head) {
            return;
        }
        Stack<BinaryNode> stack = new Stack<>();
        while (head != null || !stack.isEmpty()) {
            while (head != null) {
                System.out.print(head.value + "---->");
                stack.push(head);
                head = head.left;
            }
            if (!stack.isEmpty()) {
                head = stack.pop();
                head = head.right;
            }
        }
    }

    // 先序遍历 头 -- 左 -- 右
    public static void pre(BinaryNode head) {
        if (null == head) {
            return;
        }
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            BinaryNode cur = stack.pop();
            System.out.println(cur.value);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
    // 中序遍历 左 头 右
    // 入栈：右 -- 左 -- 头
    // 出栈：头 -- 左 -- 右
    public static void in(BinaryNode head) {
        if (null == head) {
            return;
        }
    }
    // 后序遍历 左 右 头
    public static void end(BinaryNode head) {
        if (null == head) {
            return;
        }
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(head);
        Stack<BinaryNode> stack2 = new Stack<>();
        while (!stack.isEmpty()) {
            BinaryNode cur = stack.pop();
            stack2.push(cur);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        while (!stack2.isEmpty()) {
            BinaryNode node = stack2.pop();
            System.out.println(node.value);
        }
    }

}
