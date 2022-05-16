//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法 
// 👍 820 👎 0


//Java：合并K个排序链表

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
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
        public ListNode mergeKLists1(ListNode[] lists) {
            ListNode l = null;
            for (ListNode listNode : lists) {
                l = mergeTwoList(l, listNode);
            }
            return l;
        }

        public ListNode mergeKLists2(ListNode[] lists) {
            if (null == lists || lists.length == 0) {
                return null;
            }
            int n = lists.length;
            while (n > 1) {
                for (int i = 0; i < n / 2; i++) {
                    lists[i] = mergeTwoList(lists[i], lists[n - i - 1]);
                }
                n = n % 2 == 0 ? n / 2 : n / 2 + 1;
            }
            return lists[0];
        }

        ListNode mergeTwoList(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            if (l1 != null) {
                cur.next = l1;
            } else {
                cur.next = l2;
            }
            return dummy.next;
        }

        public ListNode mergeKLists3(ListNode[] lists) {
            int n = lists.length;
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while (true) {
                int minIndex = -1;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    if (lists[i] != null && lists[i].val < min) {
                        min = lists[i].val;
                        minIndex = i;
                    }
                }
                if (minIndex == -1) {
                    break;
                }
                cur.next = lists[minIndex];
                cur = cur.next;
                lists[minIndex] = cur.next;
            }
            return dummy.next;
        }

        public ListNode mergeKLists(ListNode[] lists) {
            ListNode dummy = new ListNode(0);
            List<Integer> vals = new ArrayList<>();
            ListNode cur = dummy;
            for (ListNode l : lists) {
                while (l != null) {
                    vals.add(l.val);
                    l = l.next;
                }
            }
            Collections.sort(vals);
            for (int val : vals) {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
            return dummy.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}