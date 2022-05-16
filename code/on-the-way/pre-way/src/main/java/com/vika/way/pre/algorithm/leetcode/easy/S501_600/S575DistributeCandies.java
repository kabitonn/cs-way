package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

import java.util.Arrays;

public class S575DistributeCandies {

    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int n = candies.length;
        int sum = (n >> 1);
        int count = 1;
        for (int i = 1; i < n && count < sum; i++) {
            if (candies[i] != candies[i - 1]) {
                count++;
            }
        }
        return count;
    }

    public int distributeCandies1(int[] candies) {
        final int min = -100000;
        final int max = 100000;
        int[] bucket = new int[max - min + 1];
        for (int num : candies) {
            bucket[num - min]++;
        }
        int n = candies.length;
        int sum = n >> 1;
        int count = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > 0) {
                if (++count >= sum) {
                    return sum;
                }
            }
        }
        return count;
    }
}
