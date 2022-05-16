package com.vika.way.pre.algorithm.alg.company;

import java.util.Arrays;
import java.util.Scanner;

public class GraduationTrip {

    private int min = Integer.MAX_VALUE;
    private int flag;

    public int minCost(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            flag |= (1 << i);
        }
        dfs(map, 0, 0, 0, 0);
        return min;
    }

    public void dfs(int[][] map, int src, int from, int cost, int visited) {
        if (src == from && visited == flag) {
            min = Math.min(min, cost);
            return;
        }
        int[] adj = map[from];
        for (int to = 0; to < adj.length; to++) {
            if (to != from && (visited & (1 << to)) == 0) {
                visited ^= (1 << to);
                dfs(map, src, to, cost + adj[to], visited);
                visited ^= (1 << to);
            }
        }
    }

    public int minCost1(int[][] map) {
        int n = map.length;
        flag = (1 << n) - 1;
        int min = Integer.MAX_VALUE;
        int visited = 0;
        int[][] memo = new int[n][1 << n];
        for (int i = 1; i < n; i++) {
            visited ^= (1 << i);
            min = Math.min(min, dfs(map, i, visited, memo) + map[0][i]);
            visited ^= (1 << i);
        }
        return min;
    }

    public int dfs(int[][] map, int from, int visited, int[][] memo) {
        if (memo[from][visited] != 0) {
            return memo[from][visited];
        }
        if (from == 0) {
            if (visited == flag) {
                return 0;
            }
            return -1;
        }
        int[] adj = map[from];
        int min = Integer.MAX_VALUE;
        int cost;
        for (int to = 0; to < adj.length; to++) {
            if (to != from && (visited & (1 << to)) == 0) {
                visited ^= (1 << to);
                if ((cost = dfs(map, to, visited, memo)) >= 0) {
                    min = Math.min(min, cost + adj[to]);
                }
                visited ^= (1 << to);
            }
        }
        memo[from][visited] = min != Integer.MAX_VALUE ? min : -1;
        return memo[from][visited];
    }

    public int minCost2(int[][] map) {
        int n = map.length;
        int stateNum = 1 << n;
        int[][] dp = new int[stateNum][n];
        for (int i = 1; i < stateNum; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[1][0] = 0;
        for (int v = 1; v < stateNum; v++) {
            for (int i = 0; i < n; i++) {
                if (dp[v][i] != Integer.MAX_VALUE) {
                    for (int j = 1; j < n; j++) {
                        if ((v & (1 << j)) == 0) {
                            int next = v | (1 << j);
                            dp[next][j] = Math.min(dp[next][j], dp[v][i] + map[i][j]);
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, dp[stateNum - 1][i] + map[i][0]);
        }
        return min;
    }


    public int minCost3(int[][] map) {
        int n = map.length;
        int stateNum = 1 << n - 1;
        int[][] dp = new int[stateNum][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = map[i][0];
        }
        for (int v = 1; v < stateNum; v++) {
            for (int i = 0; i < n; i++) {
                dp[v][i] = Integer.MAX_VALUE;
                if ((v >> i - 1 & 1) == 1) {
                    continue;
                }
                for (int k = 1; k < n; k++) {
                    if ((v >> k - 1 & 1) == 1) {
                        dp[v][i] = Math.min(dp[v][i], dp[v ^ (1 << k - 1)][k] + map[i][k]);
                    }
                }
            }
        }
        return dp[stateNum - 1][0];
    }


    public static void main(String[] args) {
        int[][] array = {
            {0, 2, 6, 5},
            {2, 0, 4, 4},
            {6, 4, 0, 2},
            {5, 4, 2, 0}};
        GraduationTrip graduationTrip = new GraduationTrip();
        System.out.println(graduationTrip.minCost3(array));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println(graduationTrip.minCost(matrix));
    }
}
