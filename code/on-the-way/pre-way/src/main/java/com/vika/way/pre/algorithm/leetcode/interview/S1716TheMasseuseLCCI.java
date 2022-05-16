package com.vika.way.pre.algorithm.leetcode.interview;

public class S1716TheMasseuseLCCI {

    public int massage(int[] nums) {
        int pre = 0, cur = 0;
        int tmp;
        for (int n : nums) {
            tmp = cur;
            cur = Math.max(n + pre, cur);
            pre = tmp;
        }
        return cur;
    }
}
