package com.xu.calculator.l_06.lesson03;

/**
 * java_study
 */
public class ReverseNode {
    public static void main(String[] args) {
        NodeTest head = NodeTest.generateNode(4, 5);
        NodeTest.printNode(head);
        NodeTest reverse = reverse(head);
        NodeTest.printNode(reverse);

    }
    public static NodeTest reverse(NodeTest head) {
        if (null == head || head.next == null) {
            return head;
        }
        NodeTest pre = null;
        NodeTest next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
