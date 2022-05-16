package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

public class S070ClimbStairs {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs0(int n) {
        return climbStairsNth(n, new int[n + 1]);
    }

    private int climbStairsNth(int n, int[] memo) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int n1 = 0;
        if (memo[n - 1] == 0) {
            n1 = climbStairsNth(n - 1, memo);
            memo[n - 1] = n1;
        } else {
            n1 = memo[n - 1];
        }
        int n2 = 0;
        if (memo[n - 2] == 0) {
            n2 = climbStairsNth(n - 2, memo);
            memo[n - 2] = n2;

        } else {
            n2 = memo[n - 2];
        }
        return n1 + n2;
    }

    public int climbStairs1(int n) {
        int pre2 = 1;
        int pre1 = 1;
        int cur = 1;
        while (n-- != 1) {
            cur = pre2 + pre1;
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }

    public int climbStairs2(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fibn / sqrt5);
    }
}
