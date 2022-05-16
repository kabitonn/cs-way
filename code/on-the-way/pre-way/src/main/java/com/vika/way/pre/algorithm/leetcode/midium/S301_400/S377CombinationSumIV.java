package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S377CombinationSumIV {
    public static void main(String[] args) {
        S377CombinationSumIV solution = new S377CombinationSumIV();
        int[] nums = {3, 33, 333};
        System.out.println(solution.combinationSum4(nums, 100));
    }
    //超时
    public int combinationSum4(int[] nums, int target) {
        if (target < 0) {
            return 0;
        } else if (target == 0) {
            return 1;
        }
        int count = 0;
        for (int num : nums) {
            count += combinationSum4(nums, target - num);
        }
        return count;
    }


    public int combinationSum4_1(int[] nums, int target) {
        Integer[] memo = new Integer[target + 1];
        memo[0] = 1;
        return combinationSum(nums, target, memo);
    }

    public int combinationSum(int[] nums, int target, Integer[] memo) {
        if (target < 0) {
            return 0;
        }
        if (memo[target] != null) {
            return memo[target];
        }
        int count = 0;
        for (int num : nums) {
            count += combinationSum(nums, target - num, memo);
        }
        memo[target] = count;
        return count;
    }

    public int combinationSum4_2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
