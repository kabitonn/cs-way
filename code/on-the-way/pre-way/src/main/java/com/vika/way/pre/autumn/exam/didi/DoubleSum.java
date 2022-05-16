package com.vika.way.pre.autumn.exam.didi;

import org.junit.Test;

/**
 * @author ：tangjiawei
 * @date ：2020/9/13 20:43
 */
public class DoubleSum {


    public int backtrack(int n, int m, double target, int index, int max) {
        if (Math.abs(target) < 1e-6 && n == 0) {
            return 1;
        } else if (target <= 0) {
            return 0;
        }
        int total = 0;
        int k = 100;
        if (max >= m) {
            k = m;
        }
        for (int i = index; i < k; i++) {
            total += backtrack(n - 1, m, target - 1.0 / i, i, Math.max(max, i));
        }
        return total;
    }

    @Test
    public void test() {
        int r = backtrack(3, 6, 1, 1, 0);
        System.out.println(r);
    }
}
