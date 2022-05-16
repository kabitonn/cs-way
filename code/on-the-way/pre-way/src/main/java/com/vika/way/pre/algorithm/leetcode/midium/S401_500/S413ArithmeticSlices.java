package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

public class S413ArithmeticSlices {

    public int numberOfArithmeticSlices0(int[] A) {
        int n = A.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 2; j < n; j++) {
                int d = A[i + 1] - A[i];
                if (A[j] - A[j - 1] == d) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = true;
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (dp[i][j - 1] && A[j] - A[j - 1] == A[j - 1] - A[j - 2]) {
                    count++;
                    dp[i][j] = true;
                }
            }
        }
        return count;
    }

    public int numberOfArithmeticSlices1(int[] A) {
        int n = A.length;
        if (n < 3) {
            return 0;
        }
        int count = 0;
        int i = 0, j = 2;
        while (j < n) {
            if (A[j] - A[j - 1] == A[j - 1] - A[j - 2]) {
                count += j - i - 1;
            } else {
                i = j - 1;
            }
            j++;
        }
        return count;
    }

    public int numberOfArithmeticSlices2(int[] A) {
        int n = A.length;
        if (n < 3) {
            return 0;
        }
        int[] dp = new int[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                count += dp[i];
            }
        }
        return count;
    }

    public int numberOfArithmeticSlices3(int[] A) {
        int n = A.length;
        if (n < 3) {
            return 0;
        }
        int dp = 0;
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp = dp + 1;
                count += dp;
            } else {
                dp = 0;
            }
        }
        return count;
    }

    public int numberOfArithmeticSlices4(int[] A) {
        int count = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                count++;
            } else {
                sum += (count + 1) * (count) / 2;
                count = 0;
            }
        }
        sum += count * (count + 1) / 2;
        return sum;
    }


    public static void main(String[] args) {
        S413ArithmeticSlices solution = new S413ArithmeticSlices();
        int[] A = {1, 3, 5, 8, 11};
        System.out.println(solution.numberOfArithmeticSlices1(A));
    }
}
