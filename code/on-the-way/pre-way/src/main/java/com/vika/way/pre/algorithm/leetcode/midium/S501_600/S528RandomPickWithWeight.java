package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.Random;

public class S528RandomPickWithWeight {

    int[] sumWeight;
    Random random;

    public S528RandomPickWithWeight(int[] w) {
        sumWeight = new int[w.length];
        random = new Random();
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            sumWeight[i] = sum;
        }
    }

    public int pickIndex() {
        int target = random.nextInt(sumWeight[sumWeight.length - 1]);
        int left = 0, right = sumWeight.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (sumWeight[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
