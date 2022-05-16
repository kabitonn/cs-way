package com.vika.way.pre.algorithm.exam;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 4.2
 */
public class MeiTuan {

    public int minDelete(int[] num, int x) {
        Arrays.sort(num);
        int left = 0, right = num.length - 1;
        int count = 0;
        while (num[right] - num[left] > x) {
            int mid = num[(left + right) >>> 1];
            int i = num[left];
            int j = num[right];
            if (j - mid > x) {
                right--;
            } else if (mid - i > x) {
                left++;
            } else if (mid - i > j - mid) {
                left++;
            } else {
                right--;
            }
            count++;
        }
        return count;
    }


    public int getCount(int[] num, int m) {
        int n = num.length;
        int count = 0;
        int cur = 0;
        int invalid = 0;
        while (invalid != n) {
            if (m >= num[cur]) {
                m -= num[cur];
                count++;
                invalid = 0;
            } else {
                invalid++;
            }
            cur = (cur + 1) % n;
        }
        return count;
    }

    @Test
    public void test2() {
        int[] num = {2, 1, 4, 3};
        int x = 21;
        int count = getCount(num, x);
        System.out.println(count);
    }


    @Test
    public void test() {
        int[] num = {2, 1, 3, 2, 5};
        int x = 2;
        int count = minDelete(num, x);
        System.out.println(count);
    }

    @Test
    public void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        int count = minDelete(num, x);
        System.out.println(count);
    }

    public double getExpect(int n, double[] p, double[] a) {
        double[] expect = new double[n + 1];
        for (int i = 1; i < n + 1; i++) {
            double max = 0;
            for (int j = i; j >= 0; j--) {
                max = Math.max(max, p[j] * a[j] + p[j] * expect[i - j]);
            }
            expect[i] = max;
            System.out.println(max);
        }
        return expect[n];
    }


    public int getValue(String s, int k) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                count += f(s.substring(i, j + 1), k);
            }
        }
        return count;
    }

    public int f(String s, int k) {
        int n = s.length();
        String a, b;
        for (int l = k; l <= (n - 1) / 2; l++) {
            a = s.substring(0, l);
            int index = s.lastIndexOf(a);
            if (index <= l || index + l < n) {
                continue;
            } else if (l * 2 + 1 <= n) {
                //System.out.println(s+" "+a);
                return 1;
            }
        }
        return 0;
    }

    @Test
    public void test4_1() {
        int c = f("abcab", 2);
    }

    @Test
    public void test4() {
        String s = "abcabcabc";
        int count = getValue(s, 2);
        System.out.println(count);
    }

    public int getXor(int[] num) {
        int n = num.length;
        int max;
        int min;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            max = num[i];
            min = num[i];
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, num[j]);
                min = Math.min(min, num[j]);
                sum ^= (max ^ min);
            }
        }
        return sum;
    }

    @Test
    public void test5() {
        int[] num = {1, 1, 13, 5, 7};
        System.out.println(getXor(num));
    }
}
