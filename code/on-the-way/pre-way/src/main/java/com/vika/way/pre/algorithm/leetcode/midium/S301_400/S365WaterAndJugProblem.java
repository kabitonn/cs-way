package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.HashSet;
import java.util.Set;

public class S365WaterAndJugProblem {

    public static void main(String[] args) {
        S365WaterAndJugProblem solution = new S365WaterAndJugProblem();
        System.out.println(solution.canMeasureWater(2, 0, 3));
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        int r = gcd(x, y);
        if (r == 0 || x + y < z) {
            return false;
        }
        return z % r == 0;
    }

    public int gcd(int a, int b) {
        int r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public boolean canMeasureWater1(int x, int y, int z) {
        if (z == 0 || z == x + y) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        set.add(x + y);
        if (x > y) {
            x = x ^ y;
            y = x ^ y;
            x = x ^ y;
        }
        int hold = y;
        while (!set.contains(hold)) {
            set.add(hold);
            if (hold >= x) {
                hold -= x;
            } else {
                hold += y;
            }
            if (hold == z) {
                return true;
            }
        }
        return false;
    }
}
