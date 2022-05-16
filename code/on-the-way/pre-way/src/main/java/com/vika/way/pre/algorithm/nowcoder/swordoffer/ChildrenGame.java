package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import com.vika.way.pre.algorithm.nowcoder.datastructure.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 最后一个剩余数字
 */
public class ChildrenGame {

    public int LastRemaining_Solution(int n, int m) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        int count = n;
        int start = 0;
        while (count > 1) {
            int i = 0;
            for (; ; start = (start + 1) % n) {
                if (!set.contains(start)) {
                    continue;
                }
                i++;
                if (i == m) {
                    set.remove(start);
                    start = (start + 1) % n;
                    count--;
                    break;
                }
            }
        }
        int left = -1;
        for (int num : set) {
            left = num;
        }
        return left;
    }

    @Test
    public void test() {
        int n = LastRemaining_Solution2(5, 3);
        System.out.println(n);
    }

    public int LastRemaining_Solution1(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int cur = 0;
        while (list.size() > 1) {
            int i = 0;
            for (; ; cur = (cur + 1) % list.size()) {
                i++;
                if (i == m) {
                    list.remove(cur);
                    cur %= list.size();
                    break;
                }
            }
        }
        return list.get(0);
    }

    public int LastRemaining_Solution2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = head;
        while (cur.next != cur) {
            for (int i = 0; i < m - 1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return cur.val;
    }

    public int LastRemaining_Solution3(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int left = 0;
        for (int i = 2; i <= n; i++) {
            left = (left + m) % i;
        }
        return left;
    }
}
