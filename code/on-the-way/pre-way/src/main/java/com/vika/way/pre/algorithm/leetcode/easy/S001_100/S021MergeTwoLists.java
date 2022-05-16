package com.vika.way.pre.algorithm.leetcode.easy.S001_100;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

public class S021MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode ln1 = l1, ln2 = l2;
        ListNode cur = start;
        while (ln1 != null && ln2 != null) {
            if (ln1.val < ln2.val) {
                cur.next = new ListNode(ln1.val);
                ln1 = ln1.next;
            } else {
                cur.next = new ListNode(ln2.val);
                ln2 = ln2.next;
            }
            cur = cur.next;
        }
        while (ln1 != null) {
            cur.next = new ListNode(ln1.val);
            ln1 = ln1.next;
            cur = cur.next;
        }
        while (ln2 != null) {
            cur.next = new ListNode(ln2.val);
            ln2 = ln2.next;
            cur = cur.next;
        }
        return start.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode cur = start;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return start.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
