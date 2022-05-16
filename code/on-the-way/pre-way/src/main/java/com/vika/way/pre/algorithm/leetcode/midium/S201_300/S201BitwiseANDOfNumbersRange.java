package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

public class S201BitwiseANDOfNumbersRange {
    public static void main(String[] args) {
        S201BitwiseANDOfNumbersRange solution = new S201BitwiseANDOfNumbersRange();
        System.out.println(solution.rangeBitwiseAnd(2147483646, 2147483647));
    }

    public int rangeBitwiseAnd(int m, int n) {
        int and = Integer.MAX_VALUE;
        for (int i = m; i <= n && i >= 0 && and != 0; i++) {
            and &= i;
        }
        return and;
    }

    public int rangeBitwiseAnd1(int m, int n) {
        while (n > m) {
            n = n & (n - 1);
        }
        return n;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        // 统计移位次数
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        n <<= count;
        return n;
    }

    public int rangeBitwiseAnd3(int m, int n) {
        int a = 0;
        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            if (mask > n) {
                continue;
            }
            if ((mask & n) == (mask & m)) {
                a |= mask & n;
            } else {
                break;
            }
        }
        return a;
    }
}
