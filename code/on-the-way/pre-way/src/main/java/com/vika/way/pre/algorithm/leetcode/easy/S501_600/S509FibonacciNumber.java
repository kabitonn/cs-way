package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

public class S509FibonacciNumber {

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }

    public int fib_1(int N) {
        return fib(N, new Integer[N + 1]);
    }

    public int fib(int N, Integer[] memo) {
        if (N <= 1) {
            return N;
        }
        if (memo[N] != null) {
            return memo[N];
        }
        memo[N] = fib(N - 1, memo) + fib(N - 2, memo);
        return memo[N];
    }

    public int fib1(int N) {
        if (N <= 1) {
            return N;
        }
        int[] F = new int[N + 1];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= N; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        return F[N];
    }

    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        int fn = 1;
        int prev = 0;
        int tmp;
        while (N-- > 1) {
            tmp = fn;
            fn = fn + prev;
            prev = tmp;
        }
        return fn;
    }

    public int fib3(int N) {
        double sqrt5 = Math.sqrt(5);
        return (int) ((Math.pow((1 + sqrt5) / 2, N) - Math.pow((1 - sqrt5) / 2, N)) / sqrt5);
    }

    public int fib4(int N) {
        if (N <= 1) {
            return N;
        }
        int[][] matrix = {{1, 0}, {0, 0}};
        int[][] func = {{1, 1}, {1, 0}};
        for (int n = 2; n <= N; n++) {
            matrix = multiplyMatrix(matrix, func);
        }
        return matrix[0][0];
    }

    public int[][] multiplyMatrix(int[][] a, int[][] b) {
        int[][] matrix = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    matrix[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return matrix;
    }

    public int fib5(int N) {
        if (N <= 1) {
            return N;
        }
        int[][] matrix = {{1, 1}, {1, 0}};
        int[][] powMatrix = powMatrix(matrix, N - 1);
        return powMatrix[0][0];
    }

    public int[][] powMatrix(int[][] matrix, int n) {
        int[][] powMatrix = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) != 0) {
                powMatrix = multiplyMatrix(matrix, powMatrix);
            }
            n >>>= 1;
            matrix = multiplyMatrix(matrix, matrix);
        }
        return powMatrix;
    }

    public int fib0(int N) {
        int[] F = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,
            144, 233, 377, 610, 987, 1597, 2584, 4181, 6765,
            10946, 17711, 28657, 46368, 75025, 121393, 196418,
            317811, 514229, 832040};
        return F[N];
    }
}
