package com.vika.way.pre.algorithm.leetcode.hard.S001_200;

public class S045JumpGameII {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = i;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[n - 1];
    }

    public int jump1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = nums[i]; j >= 0; j--) {
                if (i + j >= n - 1) {
                    return Math.min(dp[n - 1], dp[i] + 1);
                }
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[n - 1];
    }

    public int jump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int start = 0;
        int next = 1;
        int step = 0;
        while (next < n) {
            int max = start;
            for (int i = start; i < next; i++) {
                max = Math.max(i + nums[i], max);
            }
            start = next;
            next = max + 1;
            step++;
        }
        return step;
    }

    public int jump3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int max = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                step++;
            }

        }
        return step;
    }

    public int jump4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pos = nums.length - 1;
        int step = 0;
        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (nums[i] + i >= pos) {
                    pos = i;
                    step++;
                }
            }
        }
        return step;
    }
}
