package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

public class S079WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        int m = board.length, n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existStart(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existStart(char[][] board, boolean[][] visited, String word, int i, int j, int index) {
        if (index == word.length() - 1) {
            return board[i][j] == word.charAt(index);
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};
        int m = board.length, n = board[0].length;
        for (int d = 0; d < 4; d++) {
            int iTmp = i + di[d], jTmp = j + dj[d];
            if (iTmp >= 0 && iTmp < m && jTmp >= 0 && jTmp < n && !visited[iTmp][jTmp]) {
                if (existStart(board, visited, word, iTmp, jTmp, index + 1)) {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    public boolean exist0(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        int m = board.length, n = board[0].length;

        byte[][] visited = new byte[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existStart0(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existStart0(char[][] board, byte[][] visited, String word, int i, int j, int index) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == 1 || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = 1;
        boolean found = existStart0(board, visited, word, i + 1, j, index + 1)
            || existStart0(board, visited, word, i - 1, j, index + 1)
            || existStart0(board, visited, word, i, j + 1, index + 1)
            || existStart0(board, visited, word, i, j - 1, index + 1);
        visited[i][j] = 0;
        return found;
    }

    public boolean exist1(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existStart(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existStart(char[][] board, String word, int i, int j, int index) {
        if (index == word.length() - 1) {
            return board[i][j] == word.charAt(index);
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        board[i][j] ^= 128;
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};
        int m = board.length, n = board[0].length;
        for (int d = 0; d < 4; d++) {
            int iTmp = i + di[d], jTmp = j + dj[d];
            if (iTmp >= 0 && iTmp < m && jTmp >= 0 && jTmp < n && (board[iTmp][jTmp] >= 0 && board[iTmp][jTmp] < 128)) {
                if (existStart(board, word, iTmp, jTmp, index + 1)) {
                    return true;
                }
            }
        }
        board[i][j] ^= 128;
        return false;
    }
}
