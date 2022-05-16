package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import org.junit.Test;

public class SumSpecial {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = n > 0 && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }

    @Test
    public void test() {
        int a = Sum_Solution(10);
        System.out.println(a);
    }
}
