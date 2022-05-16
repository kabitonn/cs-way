package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

public class S598RangeAdditionII {

    public int maxCount(int m, int n, int[][] ops) {
        int mina = m;
        int minb = n;
        for (int[] op : ops) {
            if (op[0] > 0 && op[1] > 0) {
                mina = Math.min(mina, op[0]);
                minb = Math.min(minb, op[1]);
            } else {
                return 0;
            }
        }
        return mina * minb;
    }
}
