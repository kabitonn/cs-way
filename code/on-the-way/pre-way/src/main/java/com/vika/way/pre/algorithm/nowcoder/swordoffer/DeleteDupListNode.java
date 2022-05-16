package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import com.vika.way.pre.algorithm.nowcoder.datastructure.ListNode;

public class DeleteDupListNode {

    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode pre = dummy, cur = dummy.next;
        while (cur != null) {
            boolean dup = false;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                dup = true;
            }
            if (dup) {
                pre.next = cur.next;
            } else {
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode pre = dummy, cur = dummy.next;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplication(head.next);
        } else {
            head.next = deleteDuplication(head.next);
            return head;
        }
    }

}
