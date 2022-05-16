package com.vika.way.pre.algorithm.leetcode.easy.S201_300;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class S234PalindromeLink {

    public static void main(String[] args) {
        S234PalindromeLink solution = new S234PalindromeLink();
        Integer[] nums = new Integer[]{1, 1, 1, 1, 2, 1, 1, 1, 1};
        ListNode head = new ListNode(nums);
        System.out.println(solution.isPalindrome(head));

    }

    public boolean isPalindrome(ListNode head) {
        Deque<Integer> queue = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            queue.add(cur.val);
            cur = cur.next;
        }
        int size = queue.size();
        for (int i = 0; i < size / 2; i++) {
            if (!queue.pop().equals(queue.pollLast())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
            count++;
        }
        cur = head;
        for (int i = 0; i < count / 2; i++) {
            if (cur.val != stack.pop()) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    public boolean isPalindrome1_1(ListNode head) {
        if (head == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            //链表长度为偶数,slow指向偏左中点仍未入栈
            //若链表长度为奇数，slow指向中间节点，中点左侧节点已入栈
            stack.push(slow.val);
        }
        //此时slow指向中点偏右侧
        slow = slow.next;
        while (!stack.isEmpty()) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //mid为中间或中间偏左
        ListNode mid = slow;
        mid.next = reverseList(mid.next);
        ListNode left = head, right = mid.next;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public boolean isPalindrome3(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        ListNode left = prev;   //prev为中间偏左，slow为中间或中间偏右
        ListNode right = fast == null ? slow : slow.next;

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }


    //有问题,第一次遇到和头指针相等的节点不一定是尾结点，也可能是回文链
    //[1,2,1,2,1]
    public boolean isPalindrome4(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.val == head.next.val;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null) {
            if (slow.val == fast.next.val) {
                if (fast.next.next != null) {
                    return false;
                }
                fast.next = null;
                slow = slow.next;
                fast = slow.next;
                if (fast == null || slow.val == fast.val) {
                    return true;
                }
            } else {
                fast = fast.next;
            }
        }
        return false;
    }

}
