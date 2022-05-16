package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class Power {


    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        } else if (exponent == -1) {
            return 1 / base;
        }
        double half = Power(base, exponent / 2);
        double remain = Power(base, exponent % 2);
        return half * half * remain;
    }

    public double Power0(double base, int exponent) {
        int exp = exponent;
        if (exp < 0) {
            exp = -exp;
            base = 1 / base;
        }
        double result = 1;
        int times = 1, num = 0;
        double factor = base;
        while (num < exp) {
            result *= factor;
            num += times;
            factor *= factor;
            times <<= 1;
            if (num + times > exp) {
                times = 1;
                factor = base;
            }
        }
        return result;
    }

    public double Power1(double base, int exponent) {
        int exp = exponent;
        if (exp < 0) {
            exp = -exp;
            base = 1 / base;
        }
        double factor = base;
        double result = 1;
        while (exp != 0) {
            if ((exp & 1) == 1) {
                result *= factor;
            }
            factor *= factor;
            exp >>= 1;
        }
        return result;
    }
}
