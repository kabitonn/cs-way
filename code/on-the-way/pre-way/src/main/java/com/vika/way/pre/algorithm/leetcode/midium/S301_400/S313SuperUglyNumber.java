package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.Arrays;
import java.util.PriorityQueue;

public class S313SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] point = new int[k];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int p = 0; p < primes.length; p++) {
                min = Math.min(dp[point[p]] * primes[p], min);
            }
            dp[i] = min;
            for (int p = 0; p < primes.length; p++) {
                if (min >= dp[point[p]] * primes[p]) {
                    point[p]++;
                }
            }
        }
        return dp[n - 1];
    }

    public int nthSuperUglyNumber1(int n, int[] primes) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.add((long) 1);
        long uglyNum = 1;
        long[] values = Arrays.stream(primes).asLongStream().toArray();
        for (int i = 0; i < n; i++) {
            uglyNum = minHeap.poll();
            while (!minHeap.isEmpty() && uglyNum == minHeap.peek()) {
                minHeap.poll();
            }
            for (long v : values) {
                minHeap.add(v * uglyNum);
            }
        }
        return (int) uglyNum;
    }
}
