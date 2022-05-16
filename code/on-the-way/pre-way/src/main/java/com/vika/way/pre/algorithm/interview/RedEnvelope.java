package com.vika.way.pre.algorithm.interview;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class RedEnvelope {

    Random random = new Random();

    double total;
    int num;
    int remain, unpack;

    public double robMoney() {
        double r;
        synchronized (this) {
            int m = random.nextInt(remain - unpack) + 1;
            remain -= m;
            r = (double) m / 100;
        }
        return r;
    }

    double[] distribute;

    public double[] randomMoney(double total, int n) {
        distribute = new double[n];
        int remain = (int) (total * 100);
        double p;
        int m;
        int unpacked = n - 1;
        for (int i = 0; i < n - 1; i++) {
            m = random.nextInt(remain - unpacked) + 1;
            remain -= m;
            unpacked--;
            p = (double) m / 100;
            distribute[i] = p;
        }
        p = (double) remain / 100;
        return distribute;
    }

    AtomicInteger count = new AtomicInteger(0);

    public double getMoney() {
        return distribute[count.getAndIncrement()];
    }

    Integer i;

    public double getMoney1() {
        synchronized (i) {
            return distribute[i++];
        }
    }

    @Test
    public void test() {
        double[] list = randomMoney(1, 100);
        System.out.println(Arrays.toString(list));
    }
}
