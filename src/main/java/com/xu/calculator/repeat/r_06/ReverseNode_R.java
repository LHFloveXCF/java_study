package com.xu.calculator.repeat.r_06;

/**
 * java_study
 */
public class ReverseNode_R {
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = cur;
            cur = head;
            head = next;
        }
        return cur;
    }

    public static class Node{
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
