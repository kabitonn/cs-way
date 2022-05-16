package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S393UTF8Validation {

    public static void main(String[] args) {
        S393UTF8Validation solution = new S393UTF8Validation();
        int[] data = {237};
        System.out.println(solution.validUtf8(data));
    }

    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return true;
        }
        int len = data.length;
        int i = 0;
        while (i < len) {
            int bytes = oneBits(data[i]);
            if (bytes == 1 || bytes > 4 || i + bytes > len) {
                return false;
            }
            int j = 1;
            for (; j < bytes && i + j < len; j++) {
                int bits = oneBits(data[i + j]);
                if (bits != 1) {
                    return false;
                }
            }
            i = i + j;
        }
        return true;
    }

    public int oneBits(int n) {
        int mask = 1 << 7;
        int bits = 0;
        while ((n & mask) != 0) {
            bits++;
            mask >>= 1;
        }
        return bits;
    }
}
