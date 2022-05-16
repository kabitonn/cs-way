package com.vika.way.pre.algorithm.nowcoder.swordoffer;

/**
 * 割绳子
 * 整数拆分
 */
public class CutRope {

    public int cutRope(int target) {
        if (target <= 3) {
            return target - 1;
        }
        int r = target % 3;
        int n = target / 3;
        if (r == 1) {
            return (int) Math.pow(3, n - 1) * 2 * 2;
        } else if (r == 2) {
            return (int) Math.pow(3, n) * 2;
        } else {
            return (int) Math.pow(3, n);
        }
    }

    public int cutRope1(int target) {
        Integer[] memo = new Integer[target + 1];

        return cutRope(target, memo);
    }

    public int cutRope(int n, Integer[] memo) {
        if (n <= 3) {
            return n - 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        int product = 1;
        for (int i = 1; i < n; i++) {
            product = Math.max(product, Math.max(i * (n - i), i * cutRope(n - i, memo)));
        }
        memo[n] = product;
        return memo[n];
    }
}
