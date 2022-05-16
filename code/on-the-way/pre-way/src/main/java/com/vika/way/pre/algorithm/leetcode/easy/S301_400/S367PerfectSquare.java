package com.vika.way.pre.algorithm.leetcode.easy.S301_400;

public class S367PerfectSquare {

    public static void main(String[] args) {

    }

    public boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        }
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == num * 1.0 / mid) {
                return true;
            } else if (mid > num * 1.0 / mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare1(int num) {
        if (num <= 0) {
            return false;
        }
        int left = 1;
        int right = num;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid >= num / mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left * left == num;
    }

    public boolean isPerfectSquare2(int num) {
        if (num <= 0) {
            return false;
        }
        int left = 1;
        int right = num;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > num / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left * left == num;
    }

    public boolean isPerfectSquare3(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    public boolean isPerfectSquare4(int num) {
        long a = num;
        while (a * a > num) {
            a = (a + num / a) / 2;
        }
        return a * a == num;
    }
}
