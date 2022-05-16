package com.vika.way.pre.algorithm.leetcode.midium.S101_200;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;
import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S109ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {

        return sortedListToBST(head, null);
    }

    public TreeNode sortedListToBST(ListNode head, ListNode end) {
        if (head == end) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head, slow);
        root.right = sortedListToBST(slow.next, end);
        return root;
    }

    public TreeNode sortedListToBST0(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            nums.add(p.val);
            p = p.next;
        }
        return sortedArrayToBST(nums, 0, nums.size() - 1);
    }

    private TreeNode sortedArrayToBST(List<Integer> nums, int start, int end) {
        if (start > end) {
            return null;
        }
        //int mid = start + (end - start) / 2;
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }

    private ListNode curNode = null;

    public TreeNode sortedListToBST1(ListNode head) {
        curNode = head;
        return sortedListToBST(0, size(head));
    }

    private TreeNode sortedListToBST(int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = (start + end) >>> 1;
        TreeNode left = sortedListToBST(start, mid);
        TreeNode root = new TreeNode(curNode.val);
        root.left = left;
        curNode = curNode.next;
        root.right = sortedListToBST(mid + 1, end);
        return root;
    }

    private int size(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
