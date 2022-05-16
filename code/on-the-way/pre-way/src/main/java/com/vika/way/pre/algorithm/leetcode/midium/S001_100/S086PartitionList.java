package com.vika.way.pre.algorithm.leetcode.midium.S001_100;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

public class S086PartitionList {

    public static void main(String[] args) {
        Integer[] nums = {1, 4, 3, 2, 5, 2};
        ListNode head = new ListNode(nums);
        S086PartitionList solution = new S086PartitionList();
        System.out.println(solution.partition(head, 3));
    }

    public ListNode partition(ListNode head, int x) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode tail = null;
        head = start;
        //找到第一个大于等于分区点的节点，tail 指向它的前边
        while (head.next != null && head.next.val<x) {
            head=head.next;
        }
        tail = head;
        while (head.next != null) {
            //如果当前节点小于分区点，就把它插入到 tail 的后边
            if (head.next.val < x) {
                //拿出要插入的节点
                ListNode insert = head.next;
                //将要插入的结点移除
                head.next = insert.next;
                //将 move 插入到 tail 后边
                insert.next = tail.next;
                tail.next = insert;
                //更新 tail
                tail = insert;
            }else{
                head = head.next;
            }

        }
        return start.next;
    }

    public ListNode partition0(ListNode head, int x) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode left = start, right1 = null, right2 = null, cur = head;
        while (cur != null) {
            if (cur.val < x) {
                left.next = cur;
                left = cur;
            } else if (right1 != null) {
                right2.next = cur;
                right2 = cur;
            } else if (right1 == null) {
                right1 = cur;
                right2 = cur;
            }
            cur = cur.next;
        }
        left.next = right1;
        if (right2 != null) {
            right2.next = null;
        }
        return start.next;
    }

    public ListNode partition1(ListNode head, int x) {
        //小于分区点的链表
        ListNode minHead = new ListNode(0);
        ListNode min = minHead;
        //大于等于分区点的链表
        ListNode maxHead = new ListNode(0);
        ListNode max = maxHead;
        //遍历整个链表
        while (head != null) {
            if (head.val < x) {
                min.next = head;
                min = min.next;
            } else {
                max.next = head;
                max = max.next;
            }
            head = head.next;
        }
        //这步不要忘记，不然链表就出现环了
        max.next = null;
        //两个链表接起来
        min.next = maxHead.next;
        return minHead.next;
    }
}
