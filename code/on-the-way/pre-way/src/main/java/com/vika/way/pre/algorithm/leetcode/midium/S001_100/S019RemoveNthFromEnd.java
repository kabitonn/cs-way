package com.vika.way.pre.algorithm.leetcode.midium.S001_100;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class S019RemoveNthFromEnd {

	public static void main(String[] args) {

	}
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
    	ListNode last = start;
        int num = 0;
    	while(num++<n) {
    		last = last.next;
    	}
    	ListNode first = start;
    	while(last.next!=null) {
    		last = last.next;
    		first = first.next;
    	}
    	first.next = first.next.next;
    	return start.next;
    }
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
    	ListNode first = start;
    	int len = 0;
        while(first.next!=null) {
    		first = first.next;
    		len++;
    	}
    	len-=n;
    	first = start;
    	while(len-->0) {
    		first = first.next;
    	}
    	first.next = first.next.next;
    	return start.next;
    }
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
    	ListNode first = start;
    	List<ListNode> list = new ArrayList<>();
    	int len = 0;
        while(first.next!=null) {
        	list.add(first);
    		first = first.next;
    		len++;
    	}
    	len-=n;
    	first = list.get(len);
    	first.next = first.next.next;
    	return start.next;
    }
}

