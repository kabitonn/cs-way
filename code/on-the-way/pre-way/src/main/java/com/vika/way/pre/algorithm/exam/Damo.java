package com.vika.way.pre.algorithm.exam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Damo {
    public int uglyNumber(int low, int high) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int p3 = 0, p5 = 0;
        int next = 1;
        while (next <= high) {
            int v3 = list.get(p3) * 3;
            int v5 = list.get(p5) * 5;
            next = Math.min(v3, v5);
            if (next >= v3) {
                p3++;
            }
            if (next >= v5) {
                p5++;
            }
            list.add(next);
        }
        list.remove(list.size() - 1);
        int first = 0;
        for (; list.get(first) < low; first++) {
        }
        int count = list.size() - first;
        return count;
    }


    public int ways(int target, int k) {
        int count = combine(target, 1, k);
        System.out.println(count);
        int[][] memo = new int[target + 1][k];
        combine(target, 1, k, memo);
        return memo[target][0];
    }

    public int combine(int target, int low, int high) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        }
        int count = 0;
        for (int i = low; i <= high; i++) {
            count += combine(target - i, i, high);
        }
        return count;
    }

    public int combine(int target, int low, int high, int[][] memo) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        } else if (memo[target][low - 1] != 0) {
            return memo[target][low - 1];
        }
        int count = 0;
        for (int i = low; i <= high; i++) {
            count += combine(target - i, i, high, memo);
        }
        memo[target][low - 1] = count;
        return count;
    }

    @Test
    public void test() {
        int ways = ways(9, 5);
        System.out.println(ways);
    }

}
