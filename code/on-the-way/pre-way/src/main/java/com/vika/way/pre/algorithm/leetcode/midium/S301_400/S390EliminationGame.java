package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.ArrayList;
import java.util.List;

public class S390EliminationGame {

    public int lastRemaining0(int n) {
        if (n <= 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        boolean flag = true;
        while (list.size() > 1) {
            if (list.size() % 2 == 1 || flag) {
                for (int i = 0; i < list.size(); i++) {
                    list.remove(i);
                }
            } else {
                for (int i = 1; i < list.size(); i++) {
                    list.remove(i);
                }
            }
            flag = !flag;
        }
        return list.get(0);
    }
    //f(n) = 2*(n/2+1-f(n/2));  n为偶数
    //f(n) = f(n-1);            n为奇数
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 - lastRemaining(n / 2) + 1);
    }

    public int lastRemaining1(int n) {
        if (n <= 0) {
            return 0;
        }
        int first = 1;
        int delta = 1;
        boolean flag = true;
        while (n != 1) {
            if ((n & 1) == 1 || flag) {
                first += delta;
            }
            n >>= 1;
            delta <<= 1;
            flag = !flag;
        }
        return first;
    }

}
