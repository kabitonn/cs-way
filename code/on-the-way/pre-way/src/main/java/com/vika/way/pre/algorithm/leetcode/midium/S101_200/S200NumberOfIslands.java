package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

import java.util.LinkedList;
import java.util.Queue;

public class S200NumberOfIslands {
    public static void main(String[] args) {
        S200NumberOfIslands solution = new S200NumberOfIslands();
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(solution.numIslands2(grid));
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    num++;
                    connect(grid, i, j, visited);
                }
            }
        }
        return num;
    }

    public void connect(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (grid[i][j] == '1') {
            visited[i][j] = true;
            connect(grid, i + 1, j, visited);
            connect(grid, i, j + 1, visited);
            connect(grid, i - 1, j, visited);
            connect(grid, i, j - 1, visited);
        }
    }

    public int numIslands1(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    connect1(grid, i, j);
                }
            }
        }
        return num;
    }

    public void connect1(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
            return;
        }

        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        connect1(grid, i + 1, j);
        connect1(grid, i, j + 1);
        connect1(grid, i - 1, j);
        connect1(grid, i, j - 1);
    }

    public int numIslands2(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    num++;
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] point = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = point[0] + dx[k];
                            int y = point[1] + dy[k];
                            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == '1') {
                                queue.add(new int[]{x, y});
                                //入队时就标记为已访问，若出队时标记造成节点重复入队导致会超时
                                visited[x][y] = true;
                            }
                        }
                    }
                }
            }
        }
        return num;
    }
}
