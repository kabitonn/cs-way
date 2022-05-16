package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

public class S191Numberof1Bits {

    public static void main(String[] args) {
        S191Numberof1Bits solution = new S191Numberof1Bits();
        System.out.println(solution.hammingWeight1(Integer.MIN_VALUE));
    }

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((1 & n) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public int hammingWeight0(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n % 2 != 0 ? 1 : 0;
            n >>= 1;
        }
        return count;
    }

    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
