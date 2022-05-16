package com.vika.way.pre.algorithm.leetcode.midium.S101_200;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

import java.util.HashSet;

public class S142CycleLink {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            set.add(head);
            head = head.next;
            if (set.contains(head)) {
                return head;
            }
        }
        return null;
    }
}
