package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

import java.util.HashSet;
import java.util.Set;

public class S130SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        Set<String> connection = new HashSet<>();
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'X') {
                    continue;
                }
                if (connection.contains(i + "@" + j)) {
                    continue;
                }
                Set<String> visited = new HashSet<>();
                if (!connect(board, i, j, visited, connection)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private boolean connect(char[][] board, int i, int j, Set<String> visited, Set<String> connection) {
        if (visited.contains(i + "@" + j)) {
            return false;
        }
        visited.add(i + "@" + j);
        if (board[i][j] == 'X') {
            return false;
        }
        if (connection.contains(i + "@" + j)) {
            return true;
        }
        if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
            connection.add(i + "@" + j);
            return true;
        }
        if (connect(board, i + 1, j, visited, connection) ||
            connect(board, i, j + 1, visited, connection) ||
            connect(board, i - 1, j, visited, connection) ||
            connect(board, i, j - 1, visited, connection)) {
            connection.add(i + "@" + j);
            return true;
        } else {
            return false;
        }
    }

    public void solve1(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                connect1(board, 0, j, visited);
            }
            if (board[m - 1][j] == 'O') {
                connect1(board, m - 1, j, visited);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                connect1(board, i, 0, visited);
            }
            if (board[i][n - 1] == 'O') {
                connect1(board, i, n - 1, visited);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void connect1(char[][] board, int i, int j, boolean[][] visited) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (board[i][j] == 'O') {
            visited[i][j] = true;
            connect1(board, i + 1, j, visited);
            connect1(board, i, j + 1, visited);
            connect1(board, i - 1, j, visited);
            connect1(board, i, j - 1, visited);
        }
    }

    public void solve2(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从边缘o开始搜索
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    connect2(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void connect2(char[][] board, int i, int j) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
            return;
        }
        if (board[i][j] == '*') {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '*';
            connect2(board, i + 1, j);
            connect2(board, i, j + 1);
            connect2(board, i - 1, j);
            connect2(board, i, j - 1);
        }
    }

}
