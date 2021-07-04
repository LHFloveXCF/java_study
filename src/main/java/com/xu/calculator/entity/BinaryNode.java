package com.xu.calculator.entity;

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
     * @param maxLevel      二叉树可能的最大层数
     * @param maxValue      二叉树树种节点可能出现的最大值
     * @return              随机二叉树头结点
     */
    public static BinaryNode generate2(int maxLevel, int maxValue) {
        return generate_2(1, maxLevel, maxValue);
    }

    /**
     * 生成二叉树
     * @param level         二叉树当前层数
     * @param maxLevel      二叉树可能的最大层数
     * @param maxValue      二叉树树种节点可能出现的最大值
     * @return              随机二叉树头结点
     */
    private static BinaryNode generate_2(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        BinaryNode node = new BinaryNode((int) (Math.random() * maxValue));
        node.left = generate_2(level + 1, maxLevel, maxValue);
        node.right = generate_2(level + 1, maxLevel, maxValue);
        return node;
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
        if (Math.random() < 0.5) {
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
