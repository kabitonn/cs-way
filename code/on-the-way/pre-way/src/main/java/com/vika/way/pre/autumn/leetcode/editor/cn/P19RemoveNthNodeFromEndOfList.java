//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 975 👎 0


//Java：删除链表的倒数第N个节点

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int len = 0;
            ListNode node = head;
            while (node != null) {
                len++;
                node = node.next;
            }
            if (n > len) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;
            for (int i = 0; i < len - n; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}