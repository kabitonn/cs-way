package com.vika.way.pre.algorithm.nowcoder.swordoffer;


import com.vika.way.pre.algorithm.nowcoder.datastructure.ListNode;

import java.util.ArrayList;
import java.util.Collections;

public class LinkListReverse {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> array = new ArrayList<>();
        ListNode head = listNode;
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }
        Collections.reverse(array);
        return array;
    }

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> array = new ArrayList<>();
        reversePrint(listNode, array);
        return array;
    }

    public void reversePrint(ListNode head, ArrayList<Integer> array) {
        if (head == null) {
            return;
        }
        reversePrint(head.next, array);
        array.add(head.val);
    }
}
