package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.LinkedList;
import java.util.Queue;

public class S529Minesweeper {

    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0},
        {-1, 1}, {1, 1}, {1, -1}, {-1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        dfs(board, x, y);
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else if (board[x][y] == 'E') {
            int sum = 0;
            int[][] next = new int[dir.length][2];
            int k = 0;
            for (int[] d : dir) {
                int i = x + d[0];
                int j = y + d[1];
                if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
                    continue;
                }
                next[k][0] = i;
                next[k][1] = j;
                k++;
                if (board[i][j] == 'M') {
                    sum++;
                }
            }
            if (sum == 0) {
                board[x][y] = 'B';
                for (int i = 0; i < k; i++) {
                    dfs(board, next[i][0], next[i][1]);
                }
            } else {
                board[x][y] = (char) ('0' + sum);
            }
        }
    }

    public char[][] updateBoard1(char[][] board, int[] click) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int q = 0; q < size; q++) {
                int[] pos = queue.poll();
                int x = pos[0], y = pos[1];
                if (board[x][y] == 'M') {
                    board[x][y] = 'X';
                } else if (board[x][y] == 'E') {
                    int sum = 0;
                    int[][] next = new int[dir.length][2];
                    int k = 0;
                    for (int[] d : dir) {
                        int i = x + d[0];
                        int j = y + d[1];
                        if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
                            continue;
                        }
                        next[k][0] = i;
                        next[k][1] = j;
                        k++;
                        if (board[i][j] == 'M') {
                            sum++;
                        }
                    }
                    if (sum == 0) {
                        board[x][y] = 'B';
                        for (int i = 0; i < k; i++) {
                            queue.offer(next[i]);
                        }
                    } else {
                        board[x][y] = (char) ('0' + sum);
                    }
                }
            }

        }
        return board;
    }


}
