package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

import java.util.LinkedList;
import java.util.Queue;

public class S463IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int perimeter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                perimeter += dfs(grid, i, j, m, n, visited);
            }
        }
        return perimeter;
    }

    public int dfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        visited[i][j] = true;
        int perimeter = 0;
        if (i - 1 < 0 || grid[i - 1][j] == 0) {
            perimeter++;
        } else if (!visited[i - 1][j]) {
            perimeter += dfs(grid, i - 1, j, m, n, visited);
        }
        if (i + 1 >= m || grid[i + 1][j] == 0) {
            perimeter++;
        } else if (!visited[i + 1][j]) {
            perimeter += dfs(grid, i + 1, j, m, n, visited);
        }
        if (j - 1 < 0 || grid[i][j - 1] == 0) {
            perimeter++;
        } else if (!visited[i][j - 1]) {
            perimeter += dfs(grid, i, j - 1, m, n, visited);
        }
        if (j + 1 >= n || grid[i][j + 1] == 0) {
            perimeter++;
        } else if (!visited[i][j + 1]) {
            perimeter += dfs(grid, i, j + 1, m, n, visited);
        }
        return perimeter;
    }

    public int islandPerimeter1(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int perimeter = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                while (!queue.isEmpty()) {
                    int[] point = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int x = point[0] + dx[k];
                        int y = point[1] + dy[k];
                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
                            perimeter++;
                        } else if (!visited[x][y]) {
                            queue.add(new int[]{x, y});
                            visited[x][y] = true;
                        }
                    }
                }
            }
        }
        return perimeter;
    }

    public int islandPerimeter2(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }
        return perimeter;
    }

    public int islandPerimeter3(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) {
                        perimeter += 2;
                    }
                    if (j == 0 || grid[i][j - 1] == 0) {
                        perimeter += 2;
                    }
                }
            }
        }

        return perimeter;
    }
}
