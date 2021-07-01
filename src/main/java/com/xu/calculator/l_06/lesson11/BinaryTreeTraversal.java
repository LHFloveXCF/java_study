package com.xu.calculator.l_06.lesson11;

import com.xu.calculator.entity.BinaryNode;

/**
 * java_study
 * 二叉树遍历
 */
public class BinaryTreeTraversal {
    // 先序遍历
    public static void pre(BinaryNode head) {
        if (null == head) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    // 中序遍历
    public static void in(BinaryNode head) {
        if (null == head) {
            return;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    public static void end(BinaryNode head) {
        if (null == head) {
            return;
        }
        end(head.left);
        end(head.right);
        System.out.println(head.value);
    }
}
