package com.xu.calculator.l_06.lesson11;

import com.xu.calculator.entity.Node;

import javax.sound.midi.Soundbank;

/**
 * java_study
 *
 */
public class CheckLoop {

    /**
     * 检查链表中是否有环,如果有环返回入环的第一个节点，如果没环返回null
     * @param head
     * @return
     */
    public static Node checkLoop(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (slow != fast) {//比较的是内存地址
            fast = fast.next.next;
            if (fast == null) {
                return null;
            }
            slow = slow.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }


    /**
     * 找到第一个相交的节点
     * @param first
     * @param second
     * @return
     */
    public static Node findCrossNode(Node first, Node second) {
        if (null == first || null == second) {
            return null;
        }
        Node firstLoop = checkLoop(first);
        Node secondLoop = checkLoop(second);
        if (null != firstLoop && null != secondLoop) {
            // 两个链表都有环
            // 如果入环节点相同直接返回入环节点
            if (firstLoop == secondLoop) {
                return firstLoop;
            }
            Node roundFirst  = firstLoop.next;
            Node roundSecond = secondLoop.next;
            while (roundFirst != roundSecond && firstLoop != roundFirst && secondLoop != roundSecond) {
                roundFirst = roundFirst.next;
                roundSecond = roundSecond.next;
            }
            return roundFirst == roundSecond ? roundFirst : null;
        } else if (null == firstLoop && null == secondLoop) {
            // 两个链表都没有环
            int n = 0;
            Node firstOne = first;
            while (firstOne.next != null) {
                n++;
                firstOne = firstOne.next;
            }
            Node secondOne = second;
            while (secondOne.next != null) {
                n--;
                secondOne = secondOne.next;
            }
            if (firstOne != secondOne) {
                return null;
            }
            Node largest = n > 0 ? first : second;
            secondOne = largest == first ? second : first;
            n = Math.abs(n);
            while (n > 0) {
                n--;
                largest = largest.next;
            }
            while (largest != secondOne && secondOne != null) {
                largest = largest.next;
                secondOne = secondOne.next;
            }
            return largest;
        } else {
            return null;
        }
    }


    public static void main(String[] args) {
        int i = 1;
//        System.out.println((i << 33));

        int result = i << 31;
        System.out.println(result);
        int state = 0;
        state |= (1 << 1);
        state |= result;
        if ((state & (1 << 31)) > 0) {
            System.out.println("-----------");
        }
    }
}
