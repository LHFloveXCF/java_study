package com.xu.calculator.l_06.lesson11;

import com.xu.calculator.entity.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java_study
 * 二叉树的序列化
 */
public class BinaryTreeSerial {
    public static Queue<String> serial(BinaryNode root) {
        Queue<String> result = new LinkedList<>();
        preSerial(root, result);
        return result;
    }

    // 先续遍历实现序列化
    public static void preSerial(BinaryNode node, Queue<String> queue) {
        if (node == null) {
            queue.add(null);
            return;
        }
        queue.add(String.valueOf(node.value));
        preSerial(node.left, queue);
        preSerial(node.right, queue);
    }

    public static BinaryNode preDeSerial(Queue<String> queue) {
        BinaryNode root = null;
        if (queue.isEmpty()) {
            return null;
        }
        String val = queue.poll();
        if (null != val) {
            root = new BinaryNode(Integer.parseInt(val));
            root.left = preDeSerial(queue);
            root.right = preDeSerial(queue);
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryNode root = BinaryNode.generate2(2, 100);
        BinaryNode.pre(root);
        System.out.println();
        System.out.println("serial *******");
        Queue<String> queue = serial(root);
//        while (!queue.isEmpty()) {
//            String s = queue.poll();
//            System.out.print(s + "--->");
//        }
        BinaryNode binaryNode = preDeSerial(queue);
        BinaryNode.pre(binaryNode);
    }

}
