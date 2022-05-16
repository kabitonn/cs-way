package com.vika.way.pre.algorithm.leetcode.midium.S001_100;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

/**
 * 
 * @author tokabi
 *
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

 */



public class S002AddTwoNumbers {
	public static void main(String[] args) {

	}


	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode start = new ListNode(0);
		ListNode pre = start;
		int carry = 0;
		while(l1!=null||l2!=null||carry != 0) {
			ListNode last = new ListNode(0);
			if(l1!=null) {
				last.val += l1.val;
				l1 = l1.next;
			}
			if(l2!=null) {
				last.val += l2.val;
				l2 = l2.next;
			}
			last.val += carry;
			carry = 0;
			if(last.val>=10) {
				carry = 1;
				last.val-=10;
				
			}
			pre.next = last;
			pre = last;
		}
		return start.next;
	}
	public ListNode addTwoNumbers02(ListNode l1, ListNode l2) {
		ListNode start = new ListNode(0);
		ListNode pre = start;
		int carry = 0;
		while(l1!=null||l2!=null||carry != 0) {
			ListNode last = new ListNode(carry);
			if(l1!=null) {
				last.val += l1.val;
				l1 = l1.next;
			}
			if(l2!=null) {
				last.val += l2.val;
				l2 = l2.next;
			}
			carry = last.val/10;
			last.val%=10;
			pre.next = last;
			pre = last;
		}
		return start.next;
	}
	public ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
		ListNode start = new ListNode(0);
		ListNode pre = start;
		int carry = 0;
		while(l1!=null||l2!=null) {
			ListNode last = new ListNode(carry);
			if(l1!=null) {
				last.val += l1.val;
				l1 = l1.next;
			}
			if(l2!=null) {
				last.val += l2.val;
				l2 = l2.next;
			}
			carry = last.val/10;
			last.val%=10;
			pre.next = last;
			pre = last;
		}
		if(carry!=0) {
			pre.next = new ListNode(carry);
		}
		return start.next;
	}
	public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
		ListNode start = new ListNode(0);
		ListNode pre = start;
		int carry = 0;
		int x,y,sum;
		while(l1!=null||l2!=null) {
			x=l1!=null?l1.val:0;
			y=l2!=null?l2.val:0;
			sum = x+y+carry;
			carry = sum / 10;
			pre.next = new ListNode(sum%10);
			if(l1!=null) {
				l1 = l1.next;
			}
			if(l2!=null) {
				l2 = l2.next;
			}
			pre = pre.next;
		}
		if(carry!=0) {
			pre.next = new ListNode(carry);
		}
		return start.next;
	}
}
