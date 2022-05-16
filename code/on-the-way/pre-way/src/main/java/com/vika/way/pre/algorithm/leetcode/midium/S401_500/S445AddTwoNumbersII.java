package com.vika.way.pre.algorithm.leetcode.midium.S401_500;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class S445AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = reverseListNode(l1);
        ListNode h2 = reverseListNode(l2);
        int carry = 0;
        ListNode start = new ListNode(0);
        ListNode prev = start;
        while (h1 != null || h2 != null || carry != 0) {
            ListNode last = new ListNode(0);
            int a = h1 != null ? h1.val : 0;
            int b = h2 != null ? h2.val : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            last.val += sum % 10;
            prev.next = last;
            prev = last;
            if (h1 != null) {
                h1 = h1.next;
            }
            if (h2 != null) {
                h2 = h2.next;
            }
        }
        ListNode head = reverseListNode(start.next);
        return head;
    }

    public ListNode reverseListNode(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        ListNode h1 = l1, h2 = l2;
        while (h1 != null) {
            list1.add(h1.val);
            h1 = h1.next;
        }
        while (h2 != null) {
            list2.add(h2.val);
            h2 = h2.next;
        }
        ListNode prev = null, head = null;
        int i = list1.size() - 1, j = list2.size() - 1;
        int carry = 0;
        int a, b, sum;
        while (i >= 0 || j >= 0 || carry != 0) {
            a = i >= 0 ? list1.get(i--) : 0;
            b = j >= 0 ? list2.get(j--) : 0;
            sum = a + b + carry;
            carry = sum / 10;
            head = new ListNode(sum % 10);
            head.next = prev;
            prev = head;
        }
        return prev;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int len1 = getListNodeLength(l1);
        int len2 = getListNodeLength(l2);
        if (len2 > len1) {
            ListNode l = l1;
            l1 = l2;
            l2 = l;
        }
        int lenDiff = Math.abs(len1 - len2);
        int carry = add(l1, l2, lenDiff);
        if (carry != 0) {
            ListNode head = new ListNode(carry);
            head.next = l1;
            return head;
        }
        return l1;
    }

    public int add(ListNode l1, ListNode l2, int len) {
        if (l1 == null || l2 == null) {
            return 0;
        }
        int carry, sum;
        if (len > 0) {
            carry = add(l1.next, l2, len - 1);
            sum = carry + l1.val;
        } else {
            carry = add(l1.next, l2.next, 0);
            sum = carry + l1.val + l2.val;
        }
        carry = sum / 10;
        l1.val = sum % 10;
        return carry;
    }

    public int getListNodeLength(ListNode head) {
        int len = 0;
        for (; head != null; head = head.next) {
            len++;
        }
        return len;
    }

}
