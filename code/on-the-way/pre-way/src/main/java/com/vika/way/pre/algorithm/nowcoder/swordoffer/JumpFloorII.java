package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class JumpFloorII {

    public int JumpFloorII(int target) {
        if (target == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int n = 1; n <= target; n++) {
            for (int i = 1; i <= n; i++) {
                dp[n] += dp[n - i];
            }
        }
        return dp[target];
    }

    public int JumpFloorII1(int target) {
        return (int) Math.pow(2, target - 1);
    }

}
