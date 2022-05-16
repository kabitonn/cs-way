//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表 
// 👍 710 👎 0


//Java：排序链表

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P148SortList {
    public static void main(String[] args) {
        Solution solution = new P148SortList().new Solution();
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
        public ListNode sortList1(ListNode head) {
            ListNode dummy = new ListNode(0);
            ListNode prev, next;
            ListNode node = head;
            while (node != null) {
                prev = dummy;
                while (prev.next != null && prev.next.val < node.val) {
                    prev = prev.next;
                }
                next = node.next;
                node.next = prev.next;
                prev.next = node;
                node = next;
            }
            return dummy.next;
        }

        public ListNode sortList(ListNode head) {
            ListNode[] listNodes = new ListNode[32];
            ListNode node = head;
            ListNode next;
            while (node != null) {
                next = node.next;
                node.next = null;
                int i = 0;
                while (listNodes[i] != null) {
                    node = mergeTwoList(listNodes[i], node);
                    listNodes[i++] = null;
                }
                listNodes[i] = node;
                node = next;
            }
            ListNode list = null;
            for (ListNode l : listNodes) {
                list = mergeTwoList(l, list);
            }
            return list;
        }

        public ListNode mergeTwoList(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode prev = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }
            if (l1 != null) {
                prev.next = l1;
            } else {
                prev.next = l2;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}