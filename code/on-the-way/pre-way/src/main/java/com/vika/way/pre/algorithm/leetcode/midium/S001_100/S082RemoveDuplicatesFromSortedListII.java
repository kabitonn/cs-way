package com.vika.way.pre.algorithm.leetcode.midium.S001_100;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

public class S082RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates0(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = new ListNode(0);
        ListNode pre = start, cur = head;
        while (cur != null) {
            boolean unique = true;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                unique = false;
            }
            if (unique) {
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;
        }
        //防止pre后面还有重复的节点
        pre.next = null;
        return start.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode pre = start, cur = head;
        while (cur != null) {
            boolean dup = false;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                dup = true;
            }
            if (dup) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return start.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode pre = start, cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = cur;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return start.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null ) {
            return null;
        }
        //如果头结点和后边的节点相等
        if (head.next != null && head.val == head.next.val) {
            //跳过所有重复数字
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            //将所有重复数字去掉后，进入递归
            return deleteDuplicates(head.next);
            //头结点和后边的节点不相等
        } else {
            //保留头结点，后边的所有节点进入递归
            head.next = deleteDuplicates(head.next);
        }
        //返回头结点
        return head;
    }
}
