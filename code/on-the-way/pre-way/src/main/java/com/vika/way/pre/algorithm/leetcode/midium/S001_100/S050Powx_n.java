package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

public class S050Powx_n {
    public static void main(String[] args) {
        S050Powx_n solution = new S050Powx_n();
        System.out.println(solution.myPow1(2, 1));
    }


    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n / 2);
        double remain = myPow(x, n % 2);
        return remain * half * half;
    }

    public double myPow0(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double r = 1;
        for (long i = 0; i < N; i++) {
            r = r * x;
        }
        return r;
    }

    public double myPow1(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double r = 1, temp = x;
        long num = 0, times = 1;
        while (num < N) {
            r *= temp;
            num += times;
            times <<= 1;
            temp *= temp;
            if (num + times >= N) {
                temp = x;
                times = 1;
            }

        }
        return r;
    }

    public double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double r = 1, temp = x;
        while (N != 0) {
            if ((N & 1) == 1) {
                r *= temp;
            }
            temp *= temp;
            N >>= 1;
        }
        return r;
    }
}
