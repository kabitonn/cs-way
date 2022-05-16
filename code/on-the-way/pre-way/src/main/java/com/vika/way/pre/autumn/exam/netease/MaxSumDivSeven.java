package com.vika.way.pre.autumn.exam.netease;

import org.junit.Test;

/**
 * @Author tangjiawei
 * @Date 2020/9/12
 */
public class MaxSumDivSeven {
    public int maxSumDivSeven(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][7];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 7; j++) {
                int sum = dp[i - 1][(j + 7 - nums[i - 1] % 7) % 7] + nums[i - 1];
                if (sum % 7 == j) {
                    dp[i][j] = Math.max(dp[i - 1][j], sum);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][0];
    }

    @Test
    public void test() {
        //int[] nums = {7, 3, 1, 4,3,4,3,6};
        int[] nums = {10, 20, 2, 29};
        int sum = maxSumDivSeven(nums);
        System.out.println(sum);
    }
}
