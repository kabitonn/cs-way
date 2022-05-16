package com.vika.way.pre.algorithm.leetcode.midium.S101_200;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

public class S147InsertionSortList {

    public static void main(String[] args) {
        Integer[] nums = {4, 3, 2, 5, 1};
        ListNode head = new ListNode(nums);
        S147InsertionSortList solution = new S147InsertionSortList();
        System.out.println(solution.insertionSortList0(head));
    }

    public ListNode insertionSortList(ListNode head) {
        int sorted = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = head, next, pre;
        while (node != null) {
            next = node.next;
            node.next = null;
            pre = dummy;
            int i = 0;
            while (i < sorted && pre.next != null && pre.next.val < node.val) {
                i++;
                pre = pre.next;
            }
            if (pre.next != node) {
                node.next = pre.next;
                pre.next = node;
            }
            node = next;
            sorted++;
        }
        return dummy.next;
    }

    public ListNode insertionSortList0(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head, pre = dummy;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }
        return dummy.next;
    }

    public ListNode insertionSortList1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head, pre = dummy;
        ListNode next;
        while (cur != null) {
            // 记录下一个要插入排序的值
            next = cur.next;
            // 只有 cur.next 比 cur 小才需要向前寻找插入点
            if (next != null && next.val < cur.val) {
                while (pre.next.val < next.val) {
                    pre = pre.next;
                }
                //将next插入在pre后,并将next的后继连接在cur的后面
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
                pre = dummy;
            } else {
                // 都这直接把 cur 指针指向到下一个
                cur = next;
            }
        }
        return dummy.next;
    }

}
