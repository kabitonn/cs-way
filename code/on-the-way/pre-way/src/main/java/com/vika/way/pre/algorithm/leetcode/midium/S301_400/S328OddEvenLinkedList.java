package com.vika.way.pre.algorithm.leetcode.midium.S301_400;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

public class S328OddEvenLinkedList {

    public static void main(String[] args) {
        S328OddEvenLinkedList solution = new S328OddEvenLinkedList();
        Integer[] nums = {1, 2, 3, 4,5};
        ListNode head = new ListNode(nums);
        System.out.println(solution.oddEvenList1(head));
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode cur = head.next.next;
        while (cur != null) {
            ListNode next = cur.next != null ? cur.next.next : null;
            ListNode tmpEven = odd.next;
            odd.next = cur;
            even.next = cur.next;
            odd = odd.next;
            odd.next = tmpEven;
            even = even.next;
            cur = next;
        }

        return head;
    }

    public ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head, odd = oddHead;
        ListNode evenHead = head.next, even = evenHead;
        while (even != null && even.next!=null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return oddHead;
    }

}
