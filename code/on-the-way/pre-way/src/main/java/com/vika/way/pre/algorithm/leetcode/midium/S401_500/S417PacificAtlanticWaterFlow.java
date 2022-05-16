package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.*;

public class S417PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        S417PacificAtlanticWaterFlow solution = new S417PacificAtlanticWaterFlow();
        int[][] matrix = {{12, 7, 7, 14, 6, 17, 12, 17, 8, 18, 9, 5}, {6, 8, 12, 5, 3, 6, 2, 14, 19, 6, 18, 13}, {
            0, 6, 3, 8, 8, 10, 8, 17, 13, 13, 13, 12}, {5, 6, 8, 8, 15, 16, 19, 14, 7, 11, 2, 3}, {
            7, 18, 2, 7, 10, 10, 3, 14, 13, 15, 15, 7}, {18, 6, 19, 4, 12, 3, 3, 2, 6, 6, 19, 6}, {
            3, 18, 5, 16, 19, 6, 3, 12, 6, 0, 14, 11}, {9, 10, 17, 12, 10, 11, 11, 9, 0, 0, 12, 0}, {
            4, 13, 3, 0, 4, 12, 9, 5, 6, 17, 10, 11}, {18, 3, 5, 0, 8, 19, 18, 4, 8, 19, 1, 3}, {
            16, 2, 14, 6, 4, 14, 7, 2, 9, 7, 13, 18}, {0, 16, 19, 16, 16, 4, 15, 19, 7, 0, 3, 16}, {
            13, 8, 12, 8, 2, 3, 5, 18, 6, 15, 18, 6}, {4, 10, 8, 1, 16, 0, 6, 0, 14, 10, 11, 8}, {
            7, 1, 3, 4, 11, 12, 9, 0, 6, 2, 17, 5}, {1, 16, 6, 1, 0, 19, 11, 1, 5, 7, 8, 2}, {
            4, 1, 14, 13, 14, 7, 3, 7, 1, 9, 15, 18}, {14, 11, 6, 14, 14, 14, 4, 0, 11, 17, 1, 9}, {
            3, 14, 2, 10, 3, 1, 9, 16, 1, 13, 0, 15}, {8, 9, 13, 5, 5, 7, 10, 1, 4, 5, 0, 9}, {
            13, 16, 15, 5, 17, 6, 16, 13, 5, 7, 3, 15}, {5, 1, 12, 19, 3, 13, 0, 0, 3, 10, 6, 13}, {
            12, 17, 9, 16, 16, 6, 2, 6, 12, 15, 14, 16}, {7, 7, 0, 6, 4, 15, 1, 7, 17, 5, 2, 12}, {
            3, 17, 0, 2, 4, 5, 11, 7, 16, 16, 16, 13}, {3, 7, 16, 11, 2, 16, 14, 9, 16, 17, 10, 3}, {
            12, 18, 17, 17, 5, 15, 1, 2, 12, 12, 5, 7}, {11, 10, 10, 0, 11, 7, 17, 14, 5, 15, 2, 16}, {
            7, 19, 14, 7, 6, 2, 4, 16, 11, 19, 14, 14}, {6, 17, 6, 6, 6, 15, 9, 12, 8, 13, 1, 7}, {
            16, 3, 15, 0, 18, 17, 0, 11, 3, 16, 11, 12}, {15, 12, 4, 6, 19, 15, 17, 7, 3, 9, 2, 11}};
        System.out.println(solution.pacificAtlantic1(matrix));
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int m = matrix.length, n = matrix[0].length;
        List<List<Integer>> listList = new ArrayList<>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            dfs(matrix, m, n, 0, j, pacific);
            dfs(matrix, m, n, m - 1, j, atlantic);

        }
        for (int i = 0; i < m; i++) {
            dfs(matrix, m, n, i, 0, pacific);
            dfs(matrix, m, n, i, n - 1, atlantic);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    listList.add(Arrays.asList(i, j));
                }
            }
        }
        return listList;
    }

    public void dfs(int[][] matrix, int m, int n, int i, int j, boolean[][] visited) {
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (i + 1 < m && matrix[i + 1][j] >= matrix[i][j]) {
            dfs(matrix, m, n, i + 1, j, visited);
        }
        if (i - 1 >= 0 && matrix[i - 1][j] >= matrix[i][j]) {
            dfs(matrix, m, n, i - 1, j, visited);
        }
        if (j + 1 < n && matrix[i][j + 1] >= matrix[i][j]) {
            dfs(matrix, m, n, i, j + 1, visited);
        }
        if (j - 1 >= 0 && matrix[i][j - 1] >= matrix[i][j]) {
            dfs(matrix, m, n, i, j - 1, visited);
        }
    }

    public List<List<Integer>> pacificAtlantic1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int m = matrix.length, n = matrix[0].length;
        List<List<Integer>> listList = new ArrayList<>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> queuePacific = new LinkedList<>();
        Queue<int[]> queueAtlantic = new LinkedList<>();

        for (int j = 0; j < n; j++) {
            queuePacific.add(new int[]{0, j});
            pacific[0][j] = true;
            queueAtlantic.add(new int[]{m - 1, j});
            atlantic[m - 1][j] = true;
        }
        for (int i = 1; i < m; i++) {
            queuePacific.add(new int[]{i, 0});
            pacific[i][0] = true;
            queueAtlantic.add(new int[]{i - 1, n - 1});
            atlantic[i - 1][n - 1] = true;
        }
        bfs(matrix, m, n, queuePacific, pacific);
        bfs(matrix, m, n, queueAtlantic, atlantic);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    listList.add(Arrays.asList(i, j));
                }
            }
        }
        return listList;
    }

    public void bfs(int[][] matrix, int m, int n, Queue<int[]> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] pos = queue.poll();
                int i = pos[0], j = pos[1];
                if (i + 1 < m && !visited[i + 1][j] && matrix[i + 1][j] >= matrix[i][j]) {
                    queue.add(new int[]{i + 1, j});
                    visited[i + 1][j] = true;
                }
                if (i - 1 >= 0 && !visited[i - 1][j] && matrix[i - 1][j] >= matrix[i][j]) {
                    queue.add(new int[]{i - 1, j});
                    visited[i - 1][j] = true;
                }
                if (j + 1 < n && !visited[i][j + 1] && matrix[i][j + 1] >= matrix[i][j]) {
                    queue.add(new int[]{i, j + 1});
                    visited[i][j + 1] = true;
                }
                if (j - 1 >= 0 && !visited[i][j - 1] && matrix[i][j - 1] >= matrix[i][j]) {
                    queue.add(new int[]{i, j - 1});
                    visited[i][j - 1] = true;
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int m = matrix.length, n = matrix[0].length;
        List<List<Integer>> listList = new ArrayList<>();
        int[][] connection = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int j = 0; j < n; j++) {
            queue.add(new int[]{0, j});
            connection[0][j] |= 1;
            queue.add(new int[]{m - 1, j});
            connection[m - 1][j] |= 2;
        }
        for (int i = 1; i < m; i++) {
            queue.add(new int[]{i, 0});
            connection[i][0] |= 1;
            queue.add(new int[]{i - 1, n - 1});
            connection[i - 1][n - 1] |= 2;
        }
        bfs2(matrix, m, n, queue, connection);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (connection[i][j] == 3) {
                    listList.add(Arrays.asList(i, j));
                }
            }
        }

        return listList;
    }

    public void bfs2(int[][] matrix, int m, int n, Queue<int[]> queue, int[][] connection) {
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int i = p[0], j = p[1];
            if (i + 1 < m && connection[i + 1][j] != connection[i][j] && matrix[i + 1][j] >= matrix[i][j]) {
                queue.add(new int[]{i + 1, j});
                connection[i + 1][j] |= connection[i][j];
            }
            if (i - 1 >= 0 && connection[i - 1][j] != connection[i][j] && matrix[i - 1][j] >= matrix[i][j]) {
                queue.add(new int[]{i - 1, j});
                connection[i - 1][j] |= connection[i][j];
            }
            if (j + 1 < n && connection[i][j + 1] != connection[i][j] && matrix[i][j + 1] >= matrix[i][j]) {
                queue.add(new int[]{i, j + 1});
                connection[i][j + 1] |= connection[i][j];
            }
            if (j - 1 >= 0 && connection[i][j - 1] != connection[i][j] && matrix[i][j - 1] >= matrix[i][j]) {
                queue.add(new int[]{i, j - 1});
                connection[i][j - 1] |= connection[i][j];
            }

        }
    }
}
