//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 388 👎 0


//Java：删除排序链表中的重复元素

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P83RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
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
            ListNode node = head;
            while (node != null) {
                while (node.next != null && node.val == node.next.val) {
                    node.next = node.next.next;
                }
                node = node.next;
            }
            return head;
        }

        public ListNode deleteDuplicates(ListNode head) {
            return removeDuplicate(head);
        }

        public ListNode removeDuplicate(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            removeDuplicate(head.next);
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}