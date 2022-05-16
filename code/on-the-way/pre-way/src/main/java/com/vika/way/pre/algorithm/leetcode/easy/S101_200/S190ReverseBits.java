package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

public class S190ReverseBits {

    public static void main(String[] args) {

    }

    public int reverseBits(int n) {
        int a = 0;
        for (int i = 0; i <= 31; i++) {
            a = a + ((1 & (n >> i)) << (31 - i));
        }
        return a;
    }

    public int reverseBits1(int n) {
        int a = 0;
        for (int i = 0; i <= 31; i++) {
            a = a | ((1 & (n >> i)) << (31 - i));
        }
        return a;
    }

    public int reverseBits2(int n) {
        return Integer.reverse(n);
    }

    public int reverseBits3(int n) {
        int a = 0;
        for (int i = 0; i <= 31; i++) {
            a <<= 1;
            a += n & 1;
            n >>= 1;
        }
        return a;
    }
}
