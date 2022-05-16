package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.HashMap;
import java.util.Map;

public class S397IntegerReplacement {

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if ((n & 1) == 0) {
            return 1 + integerReplacement(n >>> 1);
        }
        return 1 + Math.min(integerReplacement(n + 1), integerReplacement(n - 1));
    }

    public int integerReplacement1(int n) {
        return integerReplacement1(n, new HashMap<>());
    }

    public int integerReplacement1(int n, Map<Integer, Integer> memo) {
        if (n == 1) {
            return 0;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);

        }
        if ((n & 1) == 0) {
            memo.put(n, 1 + integerReplacement1(n >>> 1, memo));
        } else {
            memo.put(n, 1 + Math.min(integerReplacement1(n + 1, memo), integerReplacement1(n - 1, memo)));
        }
        return memo.get(n);
    }

    public int integerReplacement2(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
                count++;
            } else if ((n & 2) == 0) {
                n--;
                count++;
            } else if (n > 3) {
                n++;
                count++;
            } else {
                n--;
                count++;
            }
        }
        return count;
    }
}
