package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class S547FriendCircles {

    public int findCircleNum(int[][] M) {
        int N = M.length;
        int[] map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (M[i][j] == 0) {
                    continue;
                }
                int c = map[j];
                for (int k = 0; k < N; k++) {
                    if (map[k] == c) {
                        map[k] = map[i];
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int c : map) {
            set.add(c);
        }
        return set.size();
    }

    public int findCircleNum1(int[][] M) {
        int num = 0;
        int N = M.length;
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (M[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                num++;
                dfs1(M, i, j, visited);
            }
        }

        return num;
    }

    public void dfs1(int[][] M, int i, int j, boolean[][] visited) {
        if (visited[i][j] || M[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        visited[j][i] = true;
        for (int k = 0; k < M.length; k++) {
            dfs1(M, j, k, visited);
        }
    }

    public int findCircleNum2(int[][] M) {
        Queue<Integer> queue = new LinkedList<>();
        int N = M.length;
        boolean[] visited = new boolean[N];
        int num = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            num++;
            queue.add(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                int s = queue.poll();
                for (int j = 0; j < N; j++) {
                    if (!visited[j] && M[s][j] == 1) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }
        }
        return num;
    }

    public int findCircleNum3(int[][] M) {
        int N = M.length;
        boolean[] mapped = new boolean[N];
        int num = 0;
        for (int i = 0; i < N; i++) {
            if (!mapped[i]) {
                dfs3(M, i, mapped);
                num++;
            }
        }
        return num;
    }

    public void dfs3(int[][] M, int i, boolean[] mapped) {
        if (mapped[i]) {
            return;
        }
        mapped[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1) {
                dfs3(M, j, mapped);
            }
        }
    }

    public int findCircleNum4(int[][] M) {
        int N = M.length;
        int[] mapped = new int[N];
        int num = 0;
        for (int i = 0; i < N; i++) {
            if (mapped[i] == 0) {
                dfs4(M, i, mapped, ++num);
            }
        }
        return num;
    }

    public void dfs4(int[][] M, int i, int[] mapped, int num) {
        if (mapped[i] != 0) {
            return;
        }
        mapped[i] = num;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1) {
                dfs4(M, j, mapped, num);
            }
        }
    }


    public static void main(String[] args) {
        /*
        int[][] M = {
            {1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
            {1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1}};
         */
        //int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] M = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        S547FriendCircles solution = new S547FriendCircles();
        System.out.println(solution.findCircleNum3(M));
    }
}
