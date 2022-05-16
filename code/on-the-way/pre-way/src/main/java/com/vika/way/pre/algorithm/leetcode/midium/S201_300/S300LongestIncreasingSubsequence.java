package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

public class S300LongestIncreasingSubsequence {

    public static void main(String[] args) {
        S300LongestIncreasingSubsequence solution = new S300LongestIncreasingSubsequence();
        int[] nums = {0, 1, 1, 2};
        System.out.println(solution.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int maxLen = 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public int lengthOfLIS1(int[] nums) {
        int len = 0;
        int n = nums.length;
        int[] tails = new int[n];
        for (int num : nums) {
            int left = 0, right = len;
            // 二分找到大于等于num的左边界，即num在tails中应该存在的位置
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = num;
            if (left == len) {
                len++;
            }
        }
        return len;
    }
}
