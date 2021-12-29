package com.leetcode;

import com.leetcode.help.ListNode;

/**
 * java_study
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 删除排序链表中的重复元素
 */
public class Test_83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode();
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = result.next;
            result.next = cur;
            cur = temp;
        }
        return result.next;
    }
}
