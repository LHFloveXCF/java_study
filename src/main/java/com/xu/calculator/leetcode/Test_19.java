package com.xu.calculator.leetcode;

/**
 * java_study
 */
public class Test_19 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode pre = head;
        if (pre.next == null) {
            return null;
        }
        while (pre.next != null) {
            size++;
            pre = pre.next;
        }
        if (size == n) {
            return null;
        }
        int aim = size - n;
        ListNode cur = head;
        while (cur.next != null) {
            size--;
            if (size == aim) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }
}
