package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class Fibonacci {
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int pre = 0, cur = 1;
        int temp;
        n -= 1;
        while (n-- > 0) {
            temp = cur;
            cur += pre;
            pre = temp;
        }
        return cur;
    }

    public int fibonacci1(int n) {
        return fib(n);
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
