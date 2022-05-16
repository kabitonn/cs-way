package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

public class S096UniqueBinarySearchTrees {
    public static void main(String[] args) {
        S096UniqueBinarySearchTrees solution = new S096UniqueBinarySearchTrees();
        System.out.println(solution.numTrees(1));

    }

    public int numTrees(int n) {
        int[] numTrees = new int[n + 1];
        numTrees[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                numTrees[i] += numTrees[j - 1] * numTrees[i - j];
            }
        }
        return numTrees[n];
    }

    public int numTrees3(int n) {
        int[] numTrees = new int[n + 1];
        numTrees[0] = 1;
        numTrees[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                numTrees[i] += numTrees[j - 1] * numTrees[i - j];
            }
            numTrees[i] *= 2;
            if ((i & 1) == 1) {
                int j = (i >> 1) + 1;
                numTrees[i] += numTrees[j - 1] * numTrees[i - j];
            }
        }
        return numTrees[n];
    }

    public int numTrees1(int n) {
        // Note: we should use long here instead of int, otherwise overflow
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

    public int numTrees2(int n) {
        return recursive(n);
    }

    private int recursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int leftNum = recursive(i - 1);
            int rightNum = recursive(n - i);
            sum += leftNum * rightNum;
        }
        return sum;
    }

    public int numTrees4(int n) {
        return recursive(n, new int[n + 1]);
    }

    private int recursive(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int leftNum = recursive(i - 1, memo);
            int rightNum = recursive(n - i, memo);
            sum += leftNum * rightNum;
        }
        memo[n] = sum;
        return sum;
    }
}
