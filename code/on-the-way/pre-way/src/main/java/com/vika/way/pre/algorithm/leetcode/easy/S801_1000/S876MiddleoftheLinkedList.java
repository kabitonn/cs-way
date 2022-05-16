package com.vika.way.pre.algorithm.leetcode.easy.S801_1000;

import com.vika.way.pre.algorithm.nowcoder.datastructure.ListNode;

public class S876MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = null;
        if (fast.next == null) {
            mid = slow;
        } else {
            mid = slow.next;
        }
        return mid;
    }

    public ListNode middleNode1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
