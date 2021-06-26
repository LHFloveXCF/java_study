package com.xu.calculator.l_06.lesson03;

/**
 * java_study
 * 单向链表
 */
public class NodeTest {
    private int value;
    public NodeTest next;

    public NodeTest(int value) {
        this.value = value;
    }

    public void addNode(int value) {
        if (this.next == null) {
            this.next = new NodeTest(value);
        } else {
            this.next.addNode(value);
        }
    }

    public static void printNode(NodeTest head) {
        System.out.println("开始打印链表");
        StringBuilder stringBuilder = new StringBuilder();
        while (head.next != null) {
            stringBuilder.append(head.value + "--->");
            head = head.next;
        }
        stringBuilder.append(head.value);
        System.out.println("head: " + stringBuilder.toString());
    }

    public static NodeTest generateNode(int len, int range) {
        NodeTest head = null;
        for (int i = 0; i < len; i++) {
            int value = (int) (Math.random() * range);
            if (head == null) {
                head = new NodeTest(value);
            } else {
                head.addNode(value);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        NodeTest head = generateNode(10, 10);
        NodeTest.printNode(head);
    }
}
