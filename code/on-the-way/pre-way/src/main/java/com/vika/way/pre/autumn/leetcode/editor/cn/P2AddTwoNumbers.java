//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4843 👎 0


//Java：两数相加

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            int x, y;
            ListNode dummy = new ListNode(0);
            ListNode prev = dummy;
            while (l1 != null || l2 != null || carry != 0) {
                if (l1 != null) {
                    x = l1.val;
                    l1 = l1.next;
                } else {
                    x = 0;
                }
                if (l2 != null) {
                    y = l2.val;
                    l2 = l2.next;
                } else {
                    y = 0;
                }
                int sum = x + y + carry;
                carry = sum / 10;
                sum %= 10;
                prev.next = new ListNode(sum);
                prev = prev.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}