package com.vika.way.pre.algorithm.exam;

import org.junit.Test;

import java.util.Stack;

public class Tencent {

    public double distance(int[] a, int[] b) {
        double d = Math.sqrt(Math.pow(a[1] - b[1], 2) + Math.pow(a[0] - b[0], 2));
        return d;
    }

    public double minDistance(int[][] A, int[][] B) {
        double min = Integer.MAX_VALUE;
        double d;
        for (int[] a : A) {
            for (int[] b : B) {
                d = distance(a, b);
                min = Math.min(min, d);
            }
        }
        return min;
    }

    public int getDepth(long x) {
        int d = 0;
        while (x > 0) {
            x /= 2;
            d++;
        }
        return d;
    }

    public long getAncestor(long x, int k) {
        int depth = getDepth(x);
        if (depth <= k) {
            return -1;
        }
        long ancestor = x;
        for (int i = depth; i > k; i--) {
            ancestor /= 2;
        }
        return ancestor;
    }

    public int trailingZeroes(int n) {
        int count = 0;
        while (n / 5 != 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public int getN(int q) {
        int n = 0;
        int count = 0;
        while (count < q) {
            n += 5;
            count = trailingZeroes(n);
        }
        if (count == q) {
            return n;
        }
        return -1;
    }

    @Test
    public void test4() {
        System.out.println(getN(9));
        System.out.println(getN(1));
        System.out.println(getN(2));
        System.out.println(getN(3));
        System.out.println(getN(4));
        System.out.println(getN(7));

    }

    @Test
    public void test5() {
        System.out.println(getAncestor(10, 1));
        System.out.println(getAncestor(12, 2));
        System.out.println(getAncestor(10, 3));
        System.out.println(getAncestor(17, 4));

    }
}

class Queue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void add(int x) {
        stack1.push(x);
    }

    public int poll() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
}