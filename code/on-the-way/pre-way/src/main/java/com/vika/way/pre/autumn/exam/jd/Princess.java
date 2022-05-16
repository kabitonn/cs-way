package com.vika.way.pre.autumn.exam.jd;

import java.util.Scanner;

/**
 * @author ：tangjiawei
 * @date ：2020/9/17 19:39
 */
public class Princess {

    public String canEntry(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'S' && dfs(matrix, i, j, visited)) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public boolean dfs(char[][] matrix, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (matrix[i][j] == 'E') {
            return true;
        } else if (matrix[i][j] == '#') {
            return false;
        }
        boolean can = false;
        can = can || dfs(matrix, i + 1, j, visited);
        can = can || dfs(matrix, i - 1, j, visited);
        can = can || dfs(matrix, i, j + 1, visited);
        can = can || dfs(matrix, i, j - 1, visited);
        return can;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Princess main = new Princess();
        for (int k = 0; k < num; k++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                matrix[i] = s.toCharArray();
            }

            System.out.println(main.canEntry(matrix));
        }

    }
}
