package com.vika.way.pre.algorithm.leetcode.midium.S301_400;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

import java.util.Random;

public class S382LinkedListRandomNode_1 {

    ListNode head;
    int length;
    Random random;

    public S382LinkedListRandomNode_1(ListNode head) {
        this.head = head;
        random = new Random();
        while (head != null) {
            length++;
            head = head.next;
        }
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int randomIndex = random.nextInt(length);
        ListNode head = this.head;
        while (randomIndex-- > 0) {
            head = head.next;
        }
        return head.val;
    }
}
