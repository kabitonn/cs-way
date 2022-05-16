package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import com.vika.way.pre.algorithm.nowcoder.datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkListCycleEntry {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode slow = pHead, fast = pHead;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                slow = pHead;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = pHead;
        while (p != null) {
            if (!set.contains(p)) {
                set.add(p);
            } else {
                return p;
            }
            p = p.next;
        }
        return null;
    }
}
