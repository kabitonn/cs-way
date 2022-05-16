package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S319BulbSwitcher {
    public int bulbSwitch(int n) {
        boolean[] switchs = new boolean[n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j % i == 0) {
                    switchs[j - 1] = !switchs[j - 1];
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += switchs[i] ? 1 : 0;
        }
        return count;
    }

    public int bulbSwitch1(int n) {
        return (int) Math.sqrt(n);
    }
}
