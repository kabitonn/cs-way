package com.vika.way.pre.autumn.exam.meituan;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：tangjiawei
 * @date ：2020/9/13 10:15
 */
public class SubsetSum {

    final int mod = 998244353;

    public int sum(int target, int k, int d, int max, int[][] memo) {
        if (target == 0 && max >= d) {
            return 1;
        } else if (target < 0) {
            return 0;
        }
        if (memo[target][max] != -1) {
            return memo[target][max];
        }
        int total = 0;
        for (int i = 1; i <= k; i++) {
            int m = Math.max(i, max);
            total = (total + sum(target - i, k, d, m, memo)) % mod;
        }
        memo[target][max] = total;
        return total;
    }

    public int sum(int target, int k, int d, int max) {
        if (target == 0 && max >= d) {
            return 1;
        } else if (target < 0) {
            return 0;
        }

        int total = 0;
        for (int i = 1; i <= k; i++) {
            int m = Math.max(i, max);
            total = (total + sum(target - i, k, d, m)) % mod;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int d = sc.nextInt();
        SubsetSum main = new SubsetSum();
        int[][] memo = new int[n + 1][k + 1];
        int r = main.sum(n, k, d, 0, memo);
        System.out.println(r);
    }

    @Test
    public void test() {
        int target = 40;
        int k = 5;
        int[][] memo = new int[target + 1][k + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        int r = sum(target, k, 2, 0, memo);
        System.out.println(r);
        int s = sum(target, k, 2, 0);
        System.out.println(s);
    }
}
