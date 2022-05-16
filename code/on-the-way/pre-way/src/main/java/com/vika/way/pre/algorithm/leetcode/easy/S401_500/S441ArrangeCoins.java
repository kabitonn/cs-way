package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

public class S441ArrangeCoins {

    public static void main(String[] args) {
        S441ArrangeCoins solution = new S441ArrangeCoins();
        System.out.println(solution.arrangeCoins1(6));
    }

    public int arrangeCoins(int n) {
        int stage = 1;
        while (n >= stage) {
            n -= stage++;
        }
        return stage - 1;
    }

    public int arrangeCoins1(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (1L * mid * (mid + 1) / 2 <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low - 1;
    }

    public int arrangeCoins2(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (1L * mid * (mid + 1) / 2 <= n) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int arrangeCoins3(int n) {
        return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
    }

}
