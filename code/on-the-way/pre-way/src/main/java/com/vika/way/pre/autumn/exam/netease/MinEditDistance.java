package com.vika.way.pre.autumn.exam.netease;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author tangjiawei
 * @Date 2020/9/12
 */
public class MinEditDistance {


    public static int minDistance(String stop, String string1, String string2) {
        //dp[i][j]表示源串A位置i到目标串B位置j处最低需要操作的次数
        String[] s = string1.split(" ");
        String[] p = string2.split(" ");
        Set<String> set = Arrays.stream(stop.split(" ")).collect(Collectors.toSet());
        int m = s.length;
        int n = 0;
        for (String p0 : p) {
            if (!set.contains(p0)) {
                p[n++] = p0;
            }
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s[i - 1].equals(p[j - 1])) {  // 第i个字符是字符串下标为i-1第哪个
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = (Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        String s1 = "hello ,";
        String sa = "I'm a coder";
        String sb = "hello , I'm a singer";
        int dis = minDistance(s1, sa, sb);
        System.out.println(dis);
    }
}
