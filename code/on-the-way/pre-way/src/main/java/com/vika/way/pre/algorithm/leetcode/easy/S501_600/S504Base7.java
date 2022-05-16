package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

public class S504Base7 {
    public static void main(String[] args) {
        S504Base7 solution = new S504Base7();
        System.out.println(solution.convertToBase7(-1));
    }

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder base7 = new StringBuilder();
        int n = Math.abs(num);
        while (n != 0) {
            base7.append(n % 7);
            n /= 7;
        }
        if (num < 0) {
            base7.append('-');
        }
        return base7.reverse().toString();
    }

}
