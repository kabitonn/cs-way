package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class S279PerfectSquares {

    public static void main(String[] args) {
        S279PerfectSquares solution = new S279PerfectSquares();
        System.out.println(solution.numSquares0(12));
    }

    public int numSquares(int n) {
        numSquares(n, 0);
        return count != null ? count : 0;
    }

    Integer count = null;

    public void numSquares(int n, int num) {
        if (count != null && count <= num) {
            return;
        }
        if (n == 0) {
            count = num;
            return;
        }
        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            numSquares(n - i * i, num + 1);
        }
    }

    public int numSquares0(int n) {
        return numSquares(n, new Integer[n + 1]);
    }

    public int numSquares(int n, Integer[] memo) {
        if (memo[n] != null) {
            return memo[n];
        }
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            return memo[n] = 1;

        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= sqrt; i++) {
            min = Math.min(min, numSquares(n - i * i, memo) + 1);
        }
        return memo[n] = min;
    }

    public int numSquares1(int n) {
        int count = n;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{n, 0});
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            if (count <= cur[1]) {
                continue;
            }
            if (cur[0] == 0) {
                count = cur[1];
                continue;
            }
            for (int i = (int) Math.sqrt(cur[0]); i >= 1; i--) {
                stack.push(new int[]{cur[0] - i * i, cur[1] + 1});
            }
        }
        return count;
    }

    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public int numSquares3(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        boolean[] visited = new boolean[n + 1];
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int k = 0; k < size; k++) {
                int num = queue.poll();
                for (int i = 1; i * i <= num; i++) {
                    int next = num - i * i;
                    if (next == 0) {
                        return depth;
                    }
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
        return 0;
    }

    public boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public int numSquares4(int n) {
        if (isSquare(n)) {
            return 1;
        }
        while ((n & 3) == 0) {
            n >>= 2;
        }
        if ((n & 7) == 7) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }
        return 3;
    }

    public int numSquares5(int n) {
        while (n % 4 == 0) {
            n >>= 2;
        }
        if (n % 8 == 7) {
            return 4;
        }
        for (int i = 0; i * i <= n; i++) {
            int j = (int) Math.sqrt(n - i * i);
            if (i * i + j * j == n) {
                return (i != 0 ? 1 : 0) + (j != 0 ? 1 : 0);
            }
        }
        return 3;
    }
}
