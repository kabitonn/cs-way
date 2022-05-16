package com.vika.way.pre.autumn.exam.bytedance;

import org.junit.Test;

/**
 * @Author tangjiawei
 * @Date 2020/9/6
 */
public class ClimbStair {

    public long climbStair(int n) {
        long[][] dp = new long[n + 1][2];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            if (i > 1) {
                dp[i][1] = dp[i - 2][0];
            }
        }
        return dp[n][0] + dp[n][1];
    }

    @Test
    public void test() {
        long total = climbStair(0);
        System.out.println(total);
    }
}
