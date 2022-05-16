package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

public class S289GameOfLife {

    public static void main(String[] args) {
        S289GameOfLife solution = new S289GameOfLife();
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        solution.gameOfLife1(board);
        System.out.println(board);
    }

    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    if (!isAlive(board, dx, dy, m, n, i, j)) {
                        board[i][j] = -1;
                    }
                } else {
                    if (isAlive(board, dx, dy, m, n, i, j)) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 1) {
                    board[i][j] = 1;
                } else if (board[i][j] < 0) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public boolean isAlive(int[][] board, int[] dx, int[] dy, int m, int n, int i, int j) {
        int count = 0;
        for (int k = 0; k < dx.length; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;
            if (x < m && x >= 0 && y < n && y >= 0 && (board[x][y] == 1 || board[x][y] == -1)) {
                count++;
            }
        }
        if (board[i][j] == 1) {
            return count == 2 || count == 3;
        } else {
            return count == 3;
        }
    }

    public void gameOfLife1(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        int[][] newBoard = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i][j] = isAlive(board, m, n, i, j) ? 1 : 0;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    public boolean isAlive(int[][] board, int m, int n, int i, int j) {
        int count = 0;
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if ((x == i && y == j) || (x < 0 || x >= m || y < 0 || y >= n)) {
                    continue;
                }
                if ((board[x][y] == 1 || board[x][y] == -1)) {
                    count++;
                }
            }
        }
        if (board[i][j] == 1) {
            return count == 2 || count == 3;
        } else {
            return count == 3;
        }
    }

    public void gameOfLife2(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < dx.length; k++) {
                    int x = dx[k] + i;
                    int y = dy[k] + j;
                    if (x < m && x >= 0 && y < n && y >= 0) {
                        board[i][j] += (board[x][y] & 1) << 1;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int next = board[i][j] >> 1;
                if (next < 2 || next > 3) {
                    board[i][j] = 0;
                } else if (next == 3) {
                    board[i][j] = 1;
                } else {
                    board[i][j] &= 1;
                }
            }
        }
    }

}
