package com.vika.way.pre.autumn.interview.tencent;

/**
 * @author ：tangjiawei
 * @date ：2020/9/7 19:49
 */
public class ThrowEgg {

    public int throwEgg(int n, int k) {
        if (k == 1 || n == 0) {
            return n;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, Math.max(throwEgg(i - 1, k - 1), throwEgg(n - i, k)) + 1);
        }
        return min;
    }
}
