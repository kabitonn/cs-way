package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import java.util.PriorityQueue;

public class UglyNumber {

    public int GetUglyNumber_Solution(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n];
        int p2 = 0, p3 = 0, p5 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int v2 = dp[p2] * 2, v3 = dp[p3] * 3, v5 = dp[p5] * 5;
            int next = Math.min(v2, Math.min(v3, v5));
            if (next >= v2) {
                p2++;
            }
            if (next >= v3) {
                p3++;
            }
            if (next >= v5) {
                p5++;
            }
            dp[i] = next;
        }
        return dp[n - 1];
    }

    public int GetUglyNumber(int n) {
        if (n < 1) {
            return 0;
        }
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.add(1L);
        long ugly = 1;
        for (int i = 0; i < n; i++) {
            ugly = minHeap.poll();
            while (!minHeap.isEmpty() && minHeap.peek() == ugly) {
                minHeap.poll();
            }
            minHeap.add(ugly * 2);
            minHeap.add(ugly * 3);
            minHeap.add(ugly * 5);
        }
        return (int) ugly;
    }
}
