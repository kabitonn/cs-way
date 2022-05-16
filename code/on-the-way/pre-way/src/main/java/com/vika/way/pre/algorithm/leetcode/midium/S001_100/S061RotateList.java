package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import com.vika.way.pre.algorithm.leetcode.common.ListNode;

public class S061RotateList {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        ListNode node = new ListNode(nums);
        S061RotateList solution = new S061RotateList();
        System.out.println(solution.rotateRight(node, 0));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 1;
        int last = 0;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode cur = head;
        while (last < k && cur.next != null) {
            cur = cur.next;
            last++;
            len++;
        }
        if (last < k) {
            k = k % len;
            last = 0;
            cur = head;
            while (last < k && cur.next != null) {
                cur = cur.next;
                last++;
            }
        }
        ListNode pre = head;
        while (cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        cur.next = head;
        start.next = pre.next;
        pre.next = null;


        return start.next;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int len = 0;
        ListNode h = head;
        ListNode tail = null;
        //求出链表长度，保存尾指针
        while (h != null) {
            h = h.next;
            len++;
            if (h != null) {
                tail = h;
            }
        }
        //求出需要整体移动多少个节点
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode slow = head;
        for (int i = 1; i < len - k; i++) {
            slow = slow.next;
        }
        //尾指针指向头结点
        tail.next = head;
        //头指针更新为倒数第 n 个节点
        head = slow.next;
        //尾指针置为 null
        slow.next = null;
        return head;
    }
}
