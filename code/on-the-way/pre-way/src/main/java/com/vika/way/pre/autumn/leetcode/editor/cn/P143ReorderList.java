//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 292 👎 0


//Java：重排链表

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P143ReorderList {
    public static void main(String[] args) {
        Solution solution = new P143ReorderList().new Solution();
        // TO TEST
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public void reorderList1(ListNode head) {
            if (head == null) {
                return;
            }
            int len = 0;
            ListNode p = head;
            while (p != null) {
                p = p.next;
                len++;
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

        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            ListNode slow = head, fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode right = slow.next;
            slow.next = null;
            right = reverseList(right);
            mergeList(head, right);
        }

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode prev = null;
            ListNode node = head;
            while (node != null) {
                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }
            return prev;
        }

        public void mergeList(ListNode left, ListNode right) {
            while (right != null) {
                ListNode nextRight = right.next;
                right.next = left.next;
                left.next = right;
                left = right.next;
                right = nextRight;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}