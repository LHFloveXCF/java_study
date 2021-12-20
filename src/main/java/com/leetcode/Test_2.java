package com.leetcode;

import com.leetcode.help.ListNode;

/**
 * java_study
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Test_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int add = 0;
        while (null != l1 || null != l2) {
            int x = null == l1 ? 0 : l1.val;
            int y = null == l2 ? 0 : l2.val;
            int sum = x + y + add;
            if (sum >= 10) {
                add = 1;
                sum -= 10;
            } else {
                add = 0;
            }
            cur.next = new ListNode(sum);
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (add == 1) {
            cur.next = new ListNode(add);
        }
        return result.next;
    }
}
