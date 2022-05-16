package com.vika.way.pre.algorithm.interview;

import org.junit.Test;

public class BinarySortPerfectTree {

    public int getSubTreeRoot(int k, int m, int n, int l) {
        if (k <= 0) {
            return 0;
        }
        int root = (int) Math.pow(2, k - 1);
        int diff = root / 2;
        while (true) {
            if (root > m && root > n && root > l) {
                root -= diff;
            } else if (root < m && root < n && root < l) {
                root += diff;
            } else {
                break;
            }
            diff /=2;
        }
        return root;
    }

    @Test
    public void test() {
        System.out.println(getSubTreeRoot(31, 10, 15, 13));
    }
}
