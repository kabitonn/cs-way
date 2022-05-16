package com.vika.way.pre.algorithm.leetcode.easy.S201_300;

public class S258AddDigits {

    public static void main(String[] args) {

    }

    public int addDigits(int num) {
        while (num / 10 != 0) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public int addDigits1(int num) {
        if (num == 0) {
            return 0;
        }
        num %= 9;
        return num == 0 ? 9 : num;
    }
}
