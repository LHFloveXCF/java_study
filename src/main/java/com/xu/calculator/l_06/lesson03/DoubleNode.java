package com.xu.calculator.l_06.lesson03;

/**
 * java_study
 */
public class DoubleNode {
    private int value;
    public DoubleNode next;
    public DoubleNode pre;

    public DoubleNode(int value) {
        this.value = value;
    }

    public void addNode(int value) {
        if (this.next == null) {
            this.next = new DoubleNode(value);
            this.next.pre = this;
        } else {
            this.next.addNode(value);
        }
    }
}
