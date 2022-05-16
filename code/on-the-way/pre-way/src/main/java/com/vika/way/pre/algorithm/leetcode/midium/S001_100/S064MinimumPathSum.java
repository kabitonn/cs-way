package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

public class S064MinimumPathSum {
    public static void main(String[] args) {
        S064MinimumPathSum solution = new S064MinimumPathSum();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(solution.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] min = new int[]{Integer.MAX_VALUE};
        minPathSum(grid, grid.length, grid[0].length, 0, 0, grid[0][0], min);
        return min[0];
    }

    private void minPathSum(int[][] grid, int m, int n, int i, int j, int sum, int[] min) {
        if (i == m - 1 && j == n - 1) {
            min[0] = Math.min(min[0], sum);
            return;
        }
        if (i < m - 1) {
            minPathSum(grid, m, n, i + 1, j, sum + grid[i + 1][j], min);
        }
        if (j < n - 1) {
            minPathSum(grid, m, n, i, j + 1, sum + grid[i][j + 1], min);
        }
    }

    public int minPathSum0(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        return minPathSum(grid, 0, 0);
    }

    private int minPathSum(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        return grid[i][j] + Math.min(minPathSum(grid, i + 1, j), minPathSum(grid, i, j + 1));

    }

    public int minPathSum1(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] pathSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    pathSum[i][j] = grid[i][j];
                } else if (i == 0) {
                    pathSum[i][j] = pathSum[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    pathSum[i][j] = pathSum[i - 1][j] + grid[i][j];
                } else {
                    pathSum[i][j] = Math.min(pathSum[i - 1][j], pathSum[i][j - 1]) + grid[i][j];
                }
            }
        }
        return pathSum[m - 1][n - 1];
    }

    public int minPathSum2(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] pathSum = new int[n];
        pathSum[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            pathSum[i] = pathSum[i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    pathSum[j] = pathSum[j] + grid[i][j];
                } else {
                    pathSum[j] = Math.min(pathSum[j], pathSum[j - 1]) + grid[i][j];
                }
            }
        }
        return pathSum[n - 1];
    }

    public int minPathSum3(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];

        }
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];

    }
}
