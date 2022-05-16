package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

public class S495TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        int total = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] - timeSeries[i - 1] < duration) {
                total += timeSeries[i] - timeSeries[i - 1];
            } else {
                total += duration;
            }
        }
        return total;
    }
}
