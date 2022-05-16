package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import org.junit.Test;

public class RobotRange {

    public int movingCount(int threshold, int rows, int cols) {
        byte[][] visited = new byte[rows][cols];
        dfs(visited, threshold, 0, 0, rows, cols);
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                count += visited[i][j] == 1 ? 1 : 0;
            }
        }
        return count;
    }

    public void dfs(byte[][] visited, int thresh, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i == m || j == n || visited[i][j] != 0) {
            return;
        }
        if (!canEntry(thresh, i, j)) {
            visited[i][j] = -1;
            return;
        }
        visited[i][j] = 1;
        dfs(visited, thresh, i + 1, j, m, n);
        dfs(visited, thresh, i - 1, j, m, n);
        dfs(visited, thresh, i, j + 1, m, n);
        dfs(visited, thresh, i, j - 1, m, n);
    }

    public boolean canEntry(int thresh, int i, int j) {
        int sum = 0;
        int n;
        while (i != 0) {
            n = i % 10;
            sum += n;
            i /= 10;
        }
        while (j != 0) {
            n = j % 10;
            sum += n;
            j /= 10;
        }
        return sum <= thresh;
    }

    @Test
    public void test() {
        int count = movingCount(10, 1, 100);
        System.out.println(count);
    }
}
