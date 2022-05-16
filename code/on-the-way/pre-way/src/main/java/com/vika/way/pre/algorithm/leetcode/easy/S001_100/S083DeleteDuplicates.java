package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

import com.vika.way.pre.algorithm.leetcode.common.ListNode;

public class S083DeleteDuplicates {

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            if (cur.val == next.val) {
                cur.next = next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates3(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;

        }
        return head;
    }

    public ListNode deleteDuplicates4(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode pre = start;
        ListNode cur = pre.next;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            boolean equal = false;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                equal = true;
            }
            if (equal) {
                pre.next = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return start.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        //头结点和后一个时候相等
        if (head.next != null && head.val == head.next.val) {
            //跳过所有重复数字
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = deleteDuplicates(head);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }
        //头结点和后一个时候相等
        if (head.next != null && head.val == head.next.val) {
            head.next = head.next.next;
            head = deleteDuplicates2(head);
        } else {
            head.next = deleteDuplicates2(head.next);
        }
        return head;
    }
}
