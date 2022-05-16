package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

public class S461HammingDistance {

    public int hammingDistance(int x, int y) {
        int distance = 0;
        for (int i = 0; i < 31; i++) {
            distance += (x & 1) ^ (y & 1);
            x >>= 1;
            y >>= 1;
        }
        return distance;
    }

    public int hammingDistance1(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance++;
            xor = xor & (xor - 1);
        }
        return distance;
    }

    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
