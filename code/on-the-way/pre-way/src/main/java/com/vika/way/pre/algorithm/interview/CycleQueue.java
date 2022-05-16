package com.vika.way.pre.algorithm.interview;

import org.junit.Test;

public class CycleQueue {

    class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public int[] dequeueSequence(int n, int m) {
        int[] seq = new int[n];
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= n; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        cur.next = head;
        int count = 0;
        while (cur.next != cur) {
            for (int i = 0; i < m - 1; i++) {
                cur = cur.next;
            }
            seq[count++] = cur.next.val;
            cur.next = cur.next.next;
        }
        seq[count] = cur.val;
        return seq;
    }

    public void printSeq(int n, int m) {
        int[] seq = dequeueSequence(n, m);
        for (int s : seq) {
            System.out.print(s + " ");
        }
    }

    @Test
    public void test() {
        printSeq(5, 2);
    }
}
