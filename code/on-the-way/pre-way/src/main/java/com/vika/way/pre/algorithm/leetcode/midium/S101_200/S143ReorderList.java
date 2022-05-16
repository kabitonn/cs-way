package com.vika.way.pre.algorithm.leetcode.midium.S101_200;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class S143ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int i = 0, j = nodes.size() - 1;
        for (; i < j; i++, j--) {
            ListNode n1 = nodes.get(i);
            ListNode n2 = nodes.get(j);
            n2.next = n1.next;
            n1.next = n2;
        }
        nodes.get(i).next = null;
    }

    public void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        reorderList(head, len);
    }

    public ListNode reorderList(ListNode head, int len) {
        if (len == 1) {
            ListNode next = head.next;
            head.next = null;
            return next;
        }
        if (len == 2) {
            ListNode next = head.next.next;
            head.next.next = null;
            return next;
        }
        ListNode tail = reorderList(head.next, len - 2);
        ListNode next = tail.next;
        tail.next = head.next;
        head.next = tail;
        return next;
    }

    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        newHead = reverseNode(newHead);
        ListNode first = head, second = newHead;
        ListNode temp1, temp2;
        while (second != null) {
            temp2 = second.next;
            second.next = first.next;
            first.next = second;
            first = second.next;
            second = temp2;
        }
    }

    public ListNode reverseNode(ListNode node) {
        ListNode cur = node;
        ListNode pre = null, next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

