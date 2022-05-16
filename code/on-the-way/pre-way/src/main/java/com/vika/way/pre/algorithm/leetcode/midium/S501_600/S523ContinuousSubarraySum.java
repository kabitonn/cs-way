package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class S523ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) {
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] == 0 && nums[i + 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        for (int i = 0; i < n - 1; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum0(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 2; j <= n; j++) {
                int sum = sums[j] - sums[i];
                if (k == 0) {
                    if (sum == 0) {
                        return true;
                    }
                } else if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum1(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            if (sumMap.containsKey(sum)) {
                if (i - sumMap.get(sum) > 1) {
                    return true;
                }
            } else {
                sumMap.put(sum, i);
            }
        }
        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int prev = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            sum = k != 0 ? sum % k : sum;
            if (set.contains(sum)) {
                return true;
            }
            set.add(prev);
            prev = sum;
        }
        return false;
    }
}
