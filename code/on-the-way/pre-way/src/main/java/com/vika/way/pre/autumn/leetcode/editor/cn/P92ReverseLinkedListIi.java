//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 497 👎 0


//Java：反转链表 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P92ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
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
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode node = dummy;
            for (int i = 0; i < m - 1; i++) {
                node = node.next;
            }
            ListNode left = node;
            ListNode tail = node.next;
            ListNode prev = null;
            node = node.next;
            for (int i = m; i <= n; i++) {
                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }
            left.next = prev;
            tail.next = node;
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}