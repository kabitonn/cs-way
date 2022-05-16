package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

import java.util.Arrays;

public class S455AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        boolean[] visited = new boolean[g.length];
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int c : s) {
            for (int i = 0; i < g.length; i++) {
                if (c >= g[i] && !visited[i]) {
                    visited[i] = true;
                    count++;
                    break;
                }
            }

        }
        return count;
    }

    public int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int m = g.length, n = s.length;
        int count = 0;
        while (i < m && j < n) {
            if (g[i] <= s[j]) {
                i++;
                count++;
            }
            j++;
        }
        return count;
    }

    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length - 1;
        int j = s.length - 1;
        int count = 0;
        while (i >= 0 && j >= 0) {
            if (g[i] <= s[j]) {
                j--;
                count++;
            }
            i--;
        }
        return count;
    }

}
