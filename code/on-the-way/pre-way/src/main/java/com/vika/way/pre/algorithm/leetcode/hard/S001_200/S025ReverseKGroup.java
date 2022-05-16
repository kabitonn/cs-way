package com.vika.way.pre.algorithm.leetcode.hard.S001_200;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

public class S025ReverseKGroup {

	public static void main(String[] args) {
		S025ReverseKGroup solution = new S025ReverseKGroup();
		Integer[] nums = {1,2,3,4};
		ListNode head = new ListNode(nums);
		System.out.println(solution.reverseKGroup3(head, 3));
		

	}
    public ListNode reverseKGroup(ListNode head, int k) {
    	ListNode cur = head;
    	int n = 1;
    	while(cur!=null&&n++<k) {
    		cur = cur.next;
    	}
    	if(cur==null) {
            return head;
        }
    	cur = head;
    	ListNode[] listNodes = new ListNode[k];
    	for(int i=0;i<k;i++) {
    		listNodes[i] = cur;
    		cur = cur.next;
    	}
    	head.next = reverseKGroup(listNodes[k-1].next, k);
    	for(int i=k-1;i>0;i--) {
    		listNodes[i].next = listNodes[i-1];
    	}
        return listNodes[k-1];
    }
    public ListNode reverseKGroup1(ListNode head, int k) {
    	ListNode cur = head;
    	int n = 1;
    	while(cur!=null&&n++<k) {
    		cur = cur.next;
    	}
    	if(cur==null) {
            return head;
        }
    	ListNode tmp = cur.next;
    	cur.next = null;
    	ListNode newHead = reverse(head);
    	head.next = reverseKGroup1(tmp, k);
        return newHead;
    }
    public ListNode reverse(ListNode head) {
    	ListNode cur = head;
    	ListNode newHead = null;//newHead 即为prev
    	ListNode next;
    	while(cur!=null) {
    		next = cur.next;
    		cur.next = newHead;
    		newHead = cur;
    		cur = next;
    	}
    	return newHead;
    }
    public ListNode reverseKGroup2(ListNode head, int k) {
    	ListNode start = new ListNode(0);
    	start.next = head;
    	ListNode cur = start.next;
    	ListNode connect = start;
    	ListNode[] listNodes = new ListNode[k];
    	while(true) {
    		//当轮头结点
    		ListNode tmp = cur;
    		int n = 1;
        	while(cur!=null&&n++<k) {
        		cur = cur.next;
        	}
    		if(cur==null) {
                break;
            }
    		cur = tmp;
    		for(int i=0;i<k;i++) {
        		listNodes[i] = cur;
        		cur = cur.next;
        	}
    		//下一轮首结点cur
    		//ListNode next = cur;
    		for(int i=k-1;i>0;i--) {
        		listNodes[i].next = listNodes[i-1];
        	}
    		//接续点
    		connect.next = listNodes[k-1];
    		connect = listNodes[0];
    		connect.next = cur;
    		//cur = next;
    	}
        return start.next;
    }
    
    public ListNode reverseKGroup3(ListNode head, int k) {
    	ListNode start = new ListNode(0);
    	start.next = head;
    	ListNode cur = start.next;
    	ListNode connect = start;
    	while(true) {
    		//当轮头结点
    		ListNode tmp = cur;
    		int n = 1;
        	while(cur!=null&&n++<k) {
        		cur = cur.next;
        	}
    		if(cur==null) {
                break;
            }
    		//下一轮首结点next cur
    		ListNode next = cur.next;
    		//子链表断开
    		cur.next = null;
    		//当轮反转
    		ListNode newHead = reverse(tmp);
    		//接续点
    		connect.next = newHead;
			//当轮头结点逆置后为当轮尾结点，即为接续点
    		connect = tmp;
    		connect.next = next;
    		cur = next;
    	}
        return start.next;
    }
}
