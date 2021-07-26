package com.xu.calculator.l_07.lesson30;

import com.xu.calculator.entity.BinaryNode;

public class MorrisPrint {
    public static void morrisPrint(BinaryNode head) {
        if (null == head) {
            return;
        }
        BinaryNode cur = head;
        BinaryNode mostRight;
        while (null != cur) {
            mostRight = cur.left;
            if (null != mostRight) {
                while (null != mostRight.right && cur != mostRight.right) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == cur) {
                    cur = cur.right;
                    mostRight.right = null;
                } else {
                    System.out.print(cur.value + " ");
                    mostRight.right = cur;
                    cur = cur.left;
                }
            } else {
                System.out.print(cur.value + " ");
                cur = cur.right;
            }
        }
        System.out.println();

    }

    public static void print(BinaryNode head) {
        if (null == head) {
            return;
        }
        process(head);
        System.out.println();
    }

    private static void process(BinaryNode head) {
        if (null == head) {
            return;
        }
        // 先序遍历
        System.out.print(head.value + " ");
        process(head.left);
        // 中序遍历
        process(head.right);
        // 后序遍历
    }

    public static void main(String[] args) {
        BinaryNode node = BinaryNode.generate2(3, 10);
        print(node);
        morrisPrint(node);
    }


}
