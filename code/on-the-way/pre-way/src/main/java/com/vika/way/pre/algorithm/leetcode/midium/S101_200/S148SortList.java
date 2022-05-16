package com.vika.way.pre.algorithm.leetcode.midium.S101_200;


import com.vika.way.pre.algorithm.leetcode.common.ListNode;

public class S148SortList {
    public ListNode sortList0(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head, pre = dummy;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }
        return dummy.next;
    }

    public ListNode sortList1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head, pre = dummy;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            if (next != null && next.val < cur.val) {
                while (pre.next.val < next.val) {
                    pre = pre.next;
                }
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
                pre = dummy;
            } else {
                cur = next;
            }
        }
        return dummy.next;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = sortList2(slow.next);
        slow.next = null;
        ListNode left = sortList2(head);

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return dummy.next;
    }

    public ListNode sortList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode[] counter = new ListNode[32];
        int maxIndex = 0;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            // 拿出的节点就和原来的链表没有关系了，我们在 counter 数组中完成排序，所以要切断它和原链表的关系
            cur.next = null;
            int i = 0;
            ListNode newMergeNode;
            // 只要非空当前位置非空，就进行一次 merge，merge 以后尝试放到下一格，如果下一格非空就继续合并
            // 合并以后再尝试放到下一格，直到下一格为空，直接放在那个为空的下一格就好

            while (counter[i] != null) {
                newMergeNode = mergeTwoLists(cur, counter[i]);
                cur = newMergeNode;
                counter[i] = null;
                i++;
            }
            maxIndex = Math.max(maxIndex, i);
            counter[i] = cur;
            cur = next;
        }
        ListNode newHead = null;
        // 遍历整个 count 数组，将它们全部归并，这个操作就和归并 n 个有序单链表是一样的了，这里采用两两归并
        for (ListNode l : counter) {
            newHead = mergeTwoLists(newHead, l);
        }
        return newHead;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
