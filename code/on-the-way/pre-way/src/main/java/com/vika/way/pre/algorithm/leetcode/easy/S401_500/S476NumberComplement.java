package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

public class S476NumberComplement {

    public static void main(String[] args) {
        S476NumberComplement solution = new S476NumberComplement();
        System.out.println(solution.findComplement2(0));
    }

    //取反截取原位数
    public int findComplement(int num) {
        int mask = 0;
        int n = num;
        do {
            n >>= 1;
            mask = mask << 1 | 1;
        } while (n != 0);
        n = ~num;
        return n & mask;
    }

    public int findComplement1(int num) {
        int mask = 1;
        while ((num & mask) != num) {
            mask = mask << 1 | 1;
        }
        return num ^ mask;
    }

    //与全1的数进行异或之后，实现按位取反
    public int findComplement2(int num) {
        int mask = 1;
        int n = num;
        do {
            n >>= 1;
            mask <<= 1;
        } while (n != 0);
        mask--;
        return num ^ mask;
    }

    //仅符合正整数计算要求，不满足0
    public int findComplement3(int num) {
        int mask = num;
        // 不断将低位1置0，留下最高位为1的mask
        while ((mask & (mask - 1)) != 0) {
            mask &= mask - 1;
        }
        mask = (mask << 1) - 1;
        return num ^ mask;
    }

    // HashMap的tableSizeFor求掩码,右移x位或即把1右边第x位置1
    public int findComplement4(int num) {
        int sum = num;
        sum |= sum >> 1;
        sum |= sum >> 2;
        sum |= sum >> 4;
        sum |= sum >> 8;
        sum |= sum >> 16;
        return num ^ sum;
    }
}
