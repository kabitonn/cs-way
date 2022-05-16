package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

import java.util.Arrays;

public class S561ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < n; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public int arrayPairSum1(int[] nums) {
        int min = -10000;
        int max = 10000;
        int[] bucket = new int[max - min + 1];
        for (int n : nums) {
            bucket[n - min]++;
        }
        int sum = 0;
        int count = nums.length;
        for (int n = bucket.length - 1; n >= 0; n--) {
            while (bucket[n] > 0) {
                bucket[n]--;
                if ((count & 1) != 0) {
                    sum += n + min;
                }
                count--;
            }
        }
        return sum;
    }

}
