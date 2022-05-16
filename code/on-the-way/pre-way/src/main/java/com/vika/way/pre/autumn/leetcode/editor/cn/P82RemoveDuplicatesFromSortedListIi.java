//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 356 👎 0


//Java：删除排序链表中的重复元素 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
        // TO TEST
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public ListNode deleteDuplicates1(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;
            while (prev.next != null) {
                ListNode node = prev.next;
                boolean dup = false;
                while (node.next != null && node.val == node.next.val) {
                    dup = true;
                    node.next = node.next.next;
                }
                if (dup) {
                    prev.next = node.next;
                } else {
                    prev.next = node;
                    prev = node;
                }
            }
            return dummy.next;
        }

        public ListNode deleteDuplicates2(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;
            while (prev.next != null) {
                ListNode node = prev.next;
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
                if (prev.next != node) {
                    prev.next = node.next;
                } else {
                    prev = node;
                }
            }
            return dummy.next;
        }

        public ListNode deleteDuplicates(ListNode head) {
            return removeDuplicate(head);
        }

        public ListNode removeDuplicate(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            boolean dup = false;
            while (head.next != null && head.val == head.next.val) {
                dup = true;
                head = head.next;
            }
            if (dup) {
                return removeDuplicate(head.next);
            } else {
                head.next = removeDuplicate(head.next);
                return head;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}