package com.xu.calculator.entity;

import sun.applet.Main;

/**
 * java_study
 * 二叉树
 */
public class BinaryNode {
    public int value;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(int value) {
        this.value = value;
    }

    /**
     * 随机生成一个二叉树
     *
     * @param len 二叉树的深度
     * @return
     */
    public static BinaryNode generate(int len) {
        BinaryNode head = new BinaryNode((int) (Math.random() * len));
        process(head, 0, len);
        return head;
    }

    public static void process(BinaryNode node, int nodes, int maxNodes) {
        if (nodes > maxNodes || node == null) {
            return;
        }
        int range = (int) (Math.random() * 20);
        if (Math.random() < 1) {
            node.left = new BinaryNode((int) (Math.random() * range));
            node.right = new BinaryNode((int) (Math.random() * range));
        } else {
            node.right = new BinaryNode((int) (Math.random() * range));
        }
        nodes += 2;
        process(node.left, nodes, maxNodes);
        process(node.right, nodes, maxNodes);
    }

    public static void pre(BinaryNode head) {
        if (null == head) {
            return;
        }
        System.out.print(head.value + "   ");
        pre(head.left);
        pre(head.right);
    }

    public static void main(String[] args) {
        BinaryNode node = generate(2);
        pre(node);
    }
}
