//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 53 👎 0


//Java：从尾到头打印链表

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;

public class P剑指06从尾到头打印链表 {
    public static void main(String[] args) {
        Solution solution = new P剑指06从尾到头打印链表().new Solution();
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
        public int[] reversePrint(ListNode head) {
            LinkedList<Integer> list = new LinkedList<>();
            while (head != null) {
                list.addFirst(head.val);
                head = head.next;
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}