package com.vika.way.pre.algorithm.nowcoder;

import org.junit.Test;

import java.util.Scanner;

public class RandomRobot {

    double sum = 0;

    public void walk(int n, int pos, int left, int right) {
        if (n == 0) {
            sum += right - left + 1;
            return;
        }
        if (pos == left) {
            walk(n - 1, pos - 1, left - 1, right);
        } else {
            walk(n - 1, pos - 1, left, right);
        }
        if (pos == right) {
            walk(n - 1, pos + 1, left, right + 1);
        } else {
            walk(n - 1, pos + 1, left, right);
        }
    }

    public double expect(int n) {
        walk(n, 0, 0, 0);
        return sum /= Math.pow(2, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        RandomRobot robot = new RandomRobot();
        double count = robot.expect(n);
        System.out.printf("%.1f", count);
    }

    @Test
    public void test() {
        System.out.println(expect(4));
        System.out.println(sum * 16);
    }
}
