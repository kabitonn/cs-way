package com.vika.way.pre.algorithm.leetcode.easy.S201_300;

import java.util.HashSet;
import java.util.Set;

public class S202HappyNumber {

    public static void main(String[] args) {
        S202HappyNumber solution = new S202HappyNumber();
        System.out.println(solution.isHappy1(19));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int num = 0;
            while (n != 0) {
                num += (n % 10) * (n % 10);
                n /= 10;
            }
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
            n = num;
        }
        return true;
    }

    public boolean isHappy1(int n) {
        int x = n;
        while (n != 1) {
            int num = 0;
            while (n != 0) {
                num += (n % 10) * (n % 10);
                n /= 10;
            }
            if (num == x || (num / 10 == 0 && num != 1 && num != 7)) {
                return false;
            }
            n = num;
        }
        return true;
    }

    public boolean isHappy2(int n) {
        int slow = n;
        int fast = bitSquareSum(n);
        while (slow != fast) {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        }
        return slow == 1;
    }

    public int bitSquareSum(int n) {
        int num = 0;
        while (n != 0) {
            num += (n % 10) * (n % 10);
            n /= 10;
        }
        return num;
    }
}
