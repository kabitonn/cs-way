package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S338CountingBits {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int n = i;
            while (n != 0) {
                n = n & (n - 1);
                bits[i]++;
            }
        }
        return bits;
    }

    public int[] countBits1(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = 1 + bits[i & (i - 1)];
        }
        return bits;
    }

    public int[] countBits2(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

    public int[] countBits3(int num) {
        int[] bits = new int[num + 1];
        int n = 1, i = 0;
        while (n <= num) {
            while (i < n && i + n <= num) {
                bits[i + n] = bits[i] + 1;
                i++;
            }
            i = 0;
            n <<= 1;
        }
        return bits;
    }
}
