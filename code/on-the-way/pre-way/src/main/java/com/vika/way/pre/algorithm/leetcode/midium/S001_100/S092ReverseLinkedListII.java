package com.vika.way.pre.algorithm.leetcode.midium.S001_100;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

public class S092ReverseLinkedListII {

    public static void main(String[] args) {
        S092ReverseLinkedListII solution = new S092ReverseLinkedListII();
        Integer[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(solution.reverseBetween(head, 2, 2));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode left = start;
        for (int i = 1; i < m; i++) {
            left = left.next;
        }
        ListNode cur = left.next;
        ListNode right = cur;
        ListNode pre = null;
        ListNode next = null;
        for (int i = m; i <= n; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        right.next = next;
        left.next = pre;
        return start.next;
    }
}
