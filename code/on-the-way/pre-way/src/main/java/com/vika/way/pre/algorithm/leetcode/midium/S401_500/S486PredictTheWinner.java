package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

public class S486PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        return canWin(nums, 0, nums.length - 1, 0, 0);
    }

    public boolean canWin(int[] nums, int i, int j, int sum1, int sum2) {
        if (i > j) {
            return sum1 > sum2 || (sum1 == sum2 && nums.length % 2 == 0);
        }
        if (!canWin(nums, i + 1, j, sum2, sum1 + nums[i]) || !canWin(nums, i, j - 1, sum2, sum1 + nums[j])) {
            return true;
        }
        return false;
    }

    public boolean PredictTheWinner1(int[] nums) {
        return score(nums, 0, nums.length - 1) >= 0;
    }

    public int score(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }
        int left = nums[i] - score(nums, i + 1, j);
        int right = nums[j] - score(nums, i, j - 1);
        return Math.max(left, right);
    }

    public boolean PredictTheWinner2(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        return score(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]) >= 0;
    }

    public int score(int[] nums, int i, int j, Integer[][] memo) {
        if (i == j) {
            return nums[i];
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int left = nums[i] - score(nums, i + 1, j, memo);
        int right = nums[j] - score(nums, i, j - 1, memo);
        memo[i][j] = Math.max(left, right);
        return memo[i][j];
    }

    public boolean PredictTheWinner3(int[] nums) {
        int n = nums.length;
        if (n % 2 == 0) {
            return true;
        }
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = nums[i];
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public boolean PredictTheWinner3_1(int[] nums) {
        int n = nums.length;
        if (n % 2 == 0) {
            return true;
        }
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[j][j] = nums[j];
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public boolean PredictTheWinner4(int[] nums) {
        int n = nums.length;
        if (n % 2 == 0) {
            return true;
        }
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = nums[i];
            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[n - 1] >= 0;
    }
}

