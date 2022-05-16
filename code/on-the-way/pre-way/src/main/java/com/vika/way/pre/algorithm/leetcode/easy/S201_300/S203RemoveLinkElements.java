package com.vika.way.pre.algorithm.leetcode.easy.S201_300;

import com.vika.way.pre.algorithm.leetcode.common.ListNode;

public class S203RemoveLinkElements {

    public static void main(String[] args) {

    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode prev = start;
        ListNode cur = prev.next;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return start.next;
    }
    public ListNode removeElements2(ListNode head, int val) {
        while(head!=null&&head.val==val){
            head = head.next;
        }
        if(head==null){return head;}
        ListNode prev = head;
        while(prev.next!=null){
            if(prev.next.val==val){
                prev.next = prev.next.next;
            }
            else {
                prev = prev.next;
            }
        }
        return head;
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){return null;}
        head.next = removeElements(head.next,val);
        if(head.val == val){return  head.next;}
        else{return head;}
    }

}