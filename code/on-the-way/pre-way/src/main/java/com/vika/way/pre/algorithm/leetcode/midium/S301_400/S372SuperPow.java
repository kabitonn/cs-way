package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S372SuperPow {
    public static void main(String[] args) {
        S372SuperPow solution = new S372SuperPow();
        System.out.println(solution.superPow2(2, new int[]{1, 1, 0}));
    }

    //超时
    public int superPow(int a, int[] b) {
        int n = b.length;
        int[] r = new int[n];
        int mod = 1337;
        a %= mod;
        for (int i = 0; i < n; i++) {
            r[i] = 1;
            for (int j = 0; j < b[n - 1 - i]; j++) {
                r[i] *= a;
                r[i] %= mod;
            }
            int tmp = r[i];
            for (int j = 1; j < (int) Math.pow(10, i); j++) {
                r[i] *= tmp;
                r[i] %= mod;
            }
        }
        int pow = 1;
        for (int i = 0; i < n; i++) {
            pow *= r[i];
            pow %= mod;
        }
        return pow;
    }

    public int superPow1(int a, int[] b) {
        int n = b.length;
        int[] r = new int[n];
        int mod = 1337;
        a %= mod;
        for (int i = 0; i < n; i++) {
            r[i] = 1;
            for (int j = 0; j < b[n - 1 - i]; j++) {
                r[i] = r[i] * a % mod;
            }
            int tmp = a;
            for (int j = 1; j < 10; j++) {
                a = a * tmp % mod;
            }
        }
        int pow = 1;
        for (int i = 0; i < n; i++) {
            pow *= r[i];
            pow %= mod;
        }
        return pow;
    }

    public int superPow2(int a, int[] b) {
        int n = b.length;
        int r = 1;
        int mod = 1337;
        a %= mod;
        for (int i = 0; i < n; i++) {
            r = r * fastPow(a, b[n - 1 - i], mod) % mod;
            a = fastPow(a, 10, mod);
        }
        return r;
    }

    public int fastPow(int x, int y, int m) {
        int r = 1;
        while (y != 0) {
            if ((y & 1) == 1) {
                r = r * x % m;
            }
            x = x * x % m;
            y >>= 1;
        }
        return r;
    }

    // 欧拉函数+降幂函数+快速幂
    public int superPow3(int a, int[] b) {
        int mod = 1337;
        int c = phi(mod);
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            sum = (sum * 10 + b[i]) % c;
        }
        sum += c;
        a = a % mod;
        return fastPow(a, sum, mod);
    }


    private int phi(int x) {
        int phi = x;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                phi = phi - phi / i;
                while (x % i == 0) {
                    x /= i;
                }
            }
        }
        if (x > 1) {
            phi = phi - phi / x;
        }
        return phi;
    }

}
