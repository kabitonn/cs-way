package com.vika.way.pre.autumn.exam.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author tangjiawei
 * @Date 2020/9/6
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int _val) {
        val = _val;
    }
}

public class LinkCommonNode {


    public List<Integer> commonNode(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();
        int m = a.length, n = b.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (a[i] == b[j]) {
                list.add(a[i]);
                i++;
                j++;
            } else if (a[i] > b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return list;
    }

    public List<Integer> commonNode(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        List<Integer> list = new ArrayList<>();
        while (head1 != null && head2 != null) {
            if (head1.val == head2.val) {
                list.add(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.val > head2.val) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        ListNode dummy1 = new ListNode(0);
        ListNode node = dummy1;
        for (int i = 0; i < m; i++) {
            node.next = new ListNode(sc.nextInt());
            node = node.next;
        }
        int n = sc.nextInt();
        ListNode dummy2 = new ListNode(0);
        node = dummy2;
        for (int i = 0; i < n; i++) {
            node.next = new ListNode(sc.nextInt());
            node = node.next;
        }
        LinkCommonNode main = new LinkCommonNode();
        List<Integer> list = main.commonNode(dummy1.next, dummy2.next);
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
/*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        LinkCommonNode main = new LinkCommonNode();
        List<Integer> list = main.commonNode(a, b);
        for (int num : list) {

            System.out.print(num + " ");
        }
    }

 */
}
