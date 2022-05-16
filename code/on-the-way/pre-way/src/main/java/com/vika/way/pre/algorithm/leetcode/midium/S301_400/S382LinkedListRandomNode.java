package com.vika.way.pre.algorithm.leetcode.midium.S301_400;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class S382LinkedListRandomNode {

    List<Integer> listNodes;
    Random random;

    public S382LinkedListRandomNode(ListNode head) {
        listNodes = new ArrayList<>();
        random = new Random();
        while (head != null) {
            listNodes.add(head.val);
            head = head.next;
        }
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int randomIndex = random.nextInt(listNodes.size());
        return listNodes.get(randomIndex);
    }
}
