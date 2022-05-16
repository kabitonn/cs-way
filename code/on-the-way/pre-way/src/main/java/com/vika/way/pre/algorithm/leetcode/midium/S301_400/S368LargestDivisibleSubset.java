package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S368LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;
        int[] last = new int[n];
        int end = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] <= dp[j]) {
                    dp[i] = dp[j];
                    last[i] = j;
                }
            }
            dp[i]++;
            if (dp[i] > max) {
                max = dp[i];
                end = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            list.add(0, nums[end]);
            end = last[end];
        }
        return list;
    }

}
