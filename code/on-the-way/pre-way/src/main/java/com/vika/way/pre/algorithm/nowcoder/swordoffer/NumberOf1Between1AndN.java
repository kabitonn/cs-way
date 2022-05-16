package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import org.junit.Test;

public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int i = 1;
        int count = 0;
        while (n / i != 0) {
            int current = n / i % 10;
            int high = n / (i * 10);
            int low = n - n / i * i;
            if (current == 0) {
                count += i * high;
            } else if (current == 1) {
                count += i * high + low + 1;
            } else {
                count += i * high + i;
            }
            i *= 10;
        }
        return count;
    }

    public int numOf1BetweenN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numOf1(i);
        }
        return sum;
    }

    public int numOf1(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 10 == 1) {
                count++;
            }
            n /= 10;
        }
        return count;
    }

    @Test
    public void test() {
        int count = numOf1BetweenN(13);
        System.out.println(count);
    }
}
