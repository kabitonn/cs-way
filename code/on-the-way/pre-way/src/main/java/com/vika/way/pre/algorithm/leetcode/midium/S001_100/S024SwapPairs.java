package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import com.vika.way.pre.algorithm.leetcode.common.ListNode;

public class S024SwapPairs {
    public ListNode swapPairs(ListNode head) {
    	if(head==null||head.next==null) {
            return head;
        }
    	ListNode start = new ListNode(0);
        ListNode cur=start;
        cur.next = head;
        ListNode first = cur.next;
        ListNode second = first.next;
        while(first!=null&&second!=null) {
        	first.next = second.next;
        	second.next = first;
        	cur.next = second;
        	cur = first;
        	first = first.next;
        	if(first!=null) {
        		second = first.next;
        	}
        }
        
        return start.next;
    }
    public ListNode swapPairs1(ListNode head) {
    	if(head==null||head.next==null) {
            return head;
        }
    	ListNode next = head.next;
    	head.next = swapPairs1(next.next);
    	next.next= head;
        return next;
    }

}
