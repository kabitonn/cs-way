package com.vika.way.pre.autumn.interview.tencent;

import com.vika.way.pre.algorithm.leetcode.common.ListNode;
import org.junit.Test;

/**
 * @Author tangjiawei
 * @Date 2020/9/1
 */
public class RemoveReverseNthListNode {

    public ListNode removeNthNode(ListNode head, int n) {
        int len = 0;
        ListNode h = head;
        while (h != null) {
            len++;
            h = h.next;
        }
        if (n > len) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        h = dummy;
        n = len - n;
        while (n-- > 0) {
            h = h.next;
        }
        h.next = h.next.next;
        return dummy.next;
    }

    @Test
    public void test() {
        Integer[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        ListNode newHead = removeNthNode(head, 2);
        System.out.println(newHead);
    }
}
