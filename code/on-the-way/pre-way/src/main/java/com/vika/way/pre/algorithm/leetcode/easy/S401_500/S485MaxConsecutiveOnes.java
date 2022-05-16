package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

public class S485MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0, j = 0;
        int max = 0;
        while (j < nums.length) {
            if (nums[j] == 1) {
                j++;
            } else {
                max = Math.max(j - i, max);
                i = ++j;
            }
        }
        max = Math.max(j - i, max);
        return max;
    }

    public int findMaxConsecutiveOnes1(int[] nums) {
        int count = 0;
        int max = 0;
        for (int n : nums) {
            if (n == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        max = Math.max(count, max);
        return max;
    }
}
