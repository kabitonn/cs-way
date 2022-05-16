package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

public class S507PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        int sum = 1;
        int i = 2;
        for (; i < num / i; i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        if (i * i == num) {
            sum += i;
        }
        return sum == num;
    }

    public boolean checkPerfectNumber0(int num) {
        switch (num) {
            case 6:
            case 28:
            case 496:
            case 8128:
            case 33550336:
                return true;
            default:
                break;
        }
        return false;
    }
}
