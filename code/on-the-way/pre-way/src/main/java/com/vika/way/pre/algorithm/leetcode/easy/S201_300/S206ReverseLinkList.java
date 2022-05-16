package com.vika.way.pre.algorithm.leetcode.easy.S201_300;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class S206ReverseLinkList {

	public static void main(String[] args) {

	}
    public ListNode reverseList(ListNode head) {
    	if(head==null||head.next==null) {
    		return head;
    	}
    	ListNode newHead = reverseList(head.next);
    	head.next.next = head;
    	head.next = null;
    	return newHead;
    }
    public ListNode reverseList1(ListNode head) {
		if(head==null||head.next==null) {	return head;}
		ListNode pre = null;
		ListNode cur = head;
		while(cur.next!=null) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		cur.next = pre;
		return cur;
	}
    public ListNode reverseList3(ListNode head) {
	    if(head==null||head.next==null) {	return head;}
		ListNode pre = null;
		ListNode cur = head;
		while(cur!=null) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
    }
    public ListNode reverseList2(ListNode head) {
    	List<ListNode> list = new ArrayList<>();
    	ListNode cur = head;
    	while(cur!=null) {
    		list.add(cur);
    		cur = cur.next;
    	}
    	int size = list.size();
    	ListNode start = new  ListNode(0);
    	cur = start;
    	for(int i=size-1;i>=0;i--) {
    		cur.next = list.get(i);
    		cur = cur.next;
    	}
    	cur.next = null;
    	return start.next;
    }
        
}
