package com.vika.way.pre.algorithm.leetcode.easy.S201_300;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

public class S237DeleteLinkNode {

	public static void main(String[] args) {

	}
    public void deleteNode(ListNode node) {
    	node.val = node.next.val;
        node.next = node.next.next;
    }
}
