package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class MatrixWordPath {

    int rows, cols;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int size = rows * cols;
        if (matrix == null || matrix.length != size) {
            return false;
        }
        this.rows = rows;
        this.cols = cols;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < size; i++) {
            if (matrix[i] == str[0]) {
                if (dfs(matrix, visited, i / cols, i % cols, 0, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[] matrix, boolean[][] visited, int i, int j, int index, char[] str) {
        if (index == str.length) {
            return true;
        }
        if (i < 0 || j < 0 || i == rows || j == cols || visited[i][j]) {
            return false;
        }
        if (matrix[i * cols + j] != str[index]) {
            return false;
        }
        visited[i][j] = true;
        boolean has = false;
        has = has || dfs(matrix, visited, i + 1, j, index + 1, str);
        has = has || dfs(matrix, visited, i - 1, j, index + 1, str);
        has = has || dfs(matrix, visited, i, j + 1, index + 1, str);
        has = has || dfs(matrix, visited, i, j - 1, index + 1, str);
        visited[i][j] = false;
        return has;
    }

}
