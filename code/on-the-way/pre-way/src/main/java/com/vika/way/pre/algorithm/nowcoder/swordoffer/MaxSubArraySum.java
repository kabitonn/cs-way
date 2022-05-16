package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class MaxSubArraySum {

    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = Integer.MIN_VALUE;
        int max = 0;
        for (int num : array) {
            if (sum < 0) {
                sum = num;
            } else {
                sum += num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }



}
