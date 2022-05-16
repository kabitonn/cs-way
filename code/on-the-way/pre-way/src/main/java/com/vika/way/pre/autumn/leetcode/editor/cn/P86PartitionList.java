//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 248 👎 0


//Java：分隔链表

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P86PartitionList {
    public static void main(String[] args) {
        Solution solution = new P86PartitionList().new Solution();
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
        public ListNode partition1(ListNode head, int x) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode node = dummy;
            while (node.next != null && node.next.val < x) {
                node = node.next;
            }
            ListNode left = node;
            while (node.next != null) {
                if (node.next.val < x) {
                    ListNode insert = node.next;
                    node.next = insert.next;
                    insert.next = left.next;
                    left.next = insert;
                    left = insert;
                } else {
                    node = node.next;
                }
            }
            return dummy.next;
        }

        public ListNode partition2(ListNode head, int x) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode left = dummy;
            ListNode right = null, rightHead = null;
            ListNode node = head;
            while (node != null) {
                ListNode next = node.next;
                node.next = null;
                if (node.val < x) {
                    left.next = node;
                    left = node;
                } else if (rightHead == null) {
                    rightHead = node;
                    right = node;
                } else {
                    right.next = node;
                    right = node;
                }
                node = next;
            }
            left.next = rightHead;
            return dummy.next;
        }

        public ListNode partition(ListNode head, int x) {
            ListNode leftHead = new ListNode(0);
            ListNode rightHead = new ListNode(0);
            ListNode left = leftHead, right = rightHead;
            ListNode node = head;
            while (node != null) {
                if (node.val < x) {
                    left.next = node;
                    left = left.next;
                } else {
                    right.next = node;
                    right = right.next;
                }
                node = node.next;
            }
            right.next = null;
            left.next = rightHead.next;
            return leftHead.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}