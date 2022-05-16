package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.HashMap;
import java.util.Map;

public class S560SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for (int n : nums) {
            sum += n;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public int subarraySum1(int[] nums, int k) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            sum += n;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        int[] sums = new int[max - min + 1];
        int count = 0;
        sum = 0;
        for (int n : nums) {
            sum += n;
            int target = sum - min - k;
            if (target >= 0 && target < sums.length) {
                count += sums[target];
            }
            sums[sum - min]++;
        }
        if (k - min >= 0 && k - min < sums.length) {
            count += sums[k - min];
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
