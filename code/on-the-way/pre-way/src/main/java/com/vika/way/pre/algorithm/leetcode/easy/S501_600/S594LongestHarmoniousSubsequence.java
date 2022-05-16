package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S594LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int prev = nums[0];
        int sum = 0;
        int count1 = 0, count2 = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 == prev) {
                count1 = count2;
                count2 = 0;
            } else if (nums[i] - 1 > prev) {
                count1 = 0;
                count2 = 0;
            }
            count2++;
            if (count1 != 0) {
                sum = Math.max(sum, count1 + count2);
            }
            prev = nums[i];
        }
        return sum;
    }

    public int findLHS0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int prev = nums[0];
        int sum = 0;
        int count1 = 0, count2 = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                count2++;
            } else {
                if (count1 != 0) {
                    sum = Math.max(sum, count1 + count2);
                }
                if (nums[i] - 1 == prev) {
                    count1 = count2;
                    count2 = 1;
                } else if (nums[i] - 1 > prev) {
                    count1 = 0;
                    count2 = 1;
                }
                prev = nums[i];
            }
        }
        if (count1 != 0) {
            sum = Math.max(sum, count1 + count2);
        }
        return sum;
    }

    public int findLHS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int len = 0;
        for (int j = 1; j < n; j++) {
            while (nums[j] - nums[i] > 1) {
                i++;
            }
            if (nums[j] - nums[i] == 1) {
                len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }

    public int findLHS2(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                } else if (nums[j] + 1 == nums[i]) {
                    count++;
                    flag = true;
                }
            }
            if (flag) {
                len = Math.max(count, len);
            }
        }
        return len;

    }

    public int findLHS3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                len = Math.max(len, map.get(key) + map.get(key + 1));
            }
        }
        return len;
    }

    public int findLHS4(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num + 1)) {
                len = Math.max(len, map.get(num) + map.get(num + 1));
            }
            if (map.containsKey(num - 1)) {
                len = Math.max(len, map.get(num) + map.get(num - 1));
            }
        }
        return len;
    }

    public static void main(String[] args) {
        S594LongestHarmoniousSubsequence solution = new S594LongestHarmoniousSubsequence();
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 4, 5};
        System.out.println(solution.findLHS0(nums));
    }

}
