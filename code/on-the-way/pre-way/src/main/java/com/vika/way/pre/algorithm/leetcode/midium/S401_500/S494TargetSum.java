package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class S494TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, S, 0, 0);
    }

    public int dfs(int[] nums, int S, int sum, int index) {
        if (index == nums.length) {
            return S == sum ? 1 : 0;
        }
        int num = 0;
        num += dfs(nums, S, sum + nums[index], index + 1);
        num += dfs(nums, S, sum - nums[index], index + 1);
        return num;
    }

    public int findTargetSumWays0(int[] nums, int S) {
        Map<Integer, Integer>[] memo = new Map[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = new HashMap<>();
        }
        return dfs(nums, S, 0, 0, memo);
    }

    public int dfs(int[] nums, int S, int sum, int index, Map<Integer, Integer>[] memo) {
        if (index == nums.length) {
            return S == sum ? 1 : 0;
        }
        if (memo[index].containsKey(sum)) {
            return memo[index].get(sum);
        }
        int num = 0;
        num += dfs(nums, S, sum + nums[index], index + 1, memo);
        num += dfs(nums, S, sum - nums[index], index + 1, memo);
        memo[index].put(sum, num);
        return num;
    }

    public int findTargetSumWays2(int[] nums, int S) {
        int n = nums.length;
        int base = 0;
        for (int num : nums) {
            base += num;
        }
        if (S > base) {
            return 0;
        }
        int[][] dp = new int[n + 1][base * 2 + 1];
        dp[0][base] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = -base; j <= base; j++) {
                if (j + base - nums[i - 1] >= 0) {
                    dp[i][j + base] += dp[i - 1][j + base - nums[i - 1]];
                }
                if (j + base + nums[i - 1] <= base * 2) {
                    dp[i][j + base] += dp[i - 1][j + base + nums[i - 1]];
                }
            }
        }
        return dp[n][S + base];
    }

    public int findTargetSumWays3(int[] nums, int S) {
        int base = 0;
        for (int num : nums) {
            base += num;
        }
        if (S > base || (S + base) % 2 == 1) {
            return 0;
        }
        int[] dp = new int[base * 2 + 1];
        dp[base] = 1;
        for (int num : nums) {
            int[] next = new int[base * 2 + 1];
            for (int sum = -base; sum <= base; sum++) {
                if (sum + base + num <= base * 2) {
                    next[sum + base + num] += dp[sum + base];
                }
                if (sum + base - num >= 0) {
                    next[sum + base - num] += dp[sum + base];
                }
            }
            dp = next;
        }
        return dp[S + base];
    }

    public int findTargetSumWays4(int[] nums, int S) {
        int base = 0;
        for (int num : nums) {
            base += num;
        }
        if (S > base || (S + base) % 2 == 1) {
            return 0;
        }
        int target = (S + base) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    //超时
    public int findTargetSumWays1(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        for (int num : nums) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int n = queue.poll();
                queue.add(n + num);
                queue.add(n - num);
            }
        }
        int count = 0;
        for (int n : queue) {
            count += n == S ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        S494TargetSum solution = new S494TargetSum();
        int[] nums = {35, 34, 21, 14, 46, 49, 36, 7, 17, 39, 41, 12, 38, 18, 8, 31, 10, 22, 39, 11};
        //int[] nums = {1};
        System.out.println(solution.findTargetSumWays4(nums, 26));
    }
}
