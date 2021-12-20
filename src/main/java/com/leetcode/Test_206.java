package com.leetcode;

import com.leetcode.help.ListNode;

/**
 * java_study
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Test_206 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        new Test_206().reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;

        while (null != cur) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
