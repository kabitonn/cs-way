package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

import java.util.PriorityQueue;

public class S264UglyNumberII {
    public static void main(String[] args) {
        S264UglyNumberII solution = new S264UglyNumberII();
        System.out.println(solution.nthUglyNumber1(10));
    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        //三指针指向仍能被继续使用的最后一个相对应的数
        int p2 = 0, p3 = 0, p5 = 0;
        int v2 = 0, v3 = 0, v5 = 0;
        for (int i = 1; i < n; i++) {
            v2 = dp[p2] * 2;
            v3 = dp[p3] * 3;
            v5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(v2, v3), v5);
            if (dp[i] >= v2) {
                p2++;
            }
            if (dp[i] >= v3) {
                p3++;
            }
            if (dp[i] >= v5) {
                p5++;
            }
        }
        return dp[n - 1];
    }

    public int nthUglyNumber1(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.add((long)1);
        long uglyNum = 1;
        long[] values = {2, 3, 5};
        for (int i = 0; i < n; i++) {
            uglyNum = minHeap.poll();
            while (!minHeap.isEmpty()&&uglyNum == minHeap.peek()) {
                minHeap.poll();
            }
            for (long v : values) {
                minHeap.add(v * uglyNum);
            }
        }
        return (int)uglyNum;
    }
}
