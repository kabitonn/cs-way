package com.vika.way.pre.algorithm.exam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kuaishou {

    public int[] pair(String s) {
        int n = s.length();
        char[] stack = new char[n];
        int top = 0;
        int[] pair = new int[3];
        for (char c : s.toCharArray()) {
            if (c != '(' && c != ')') {
                continue;
            }
            if (c == '(') {
                stack[top++] = '(';
            } else if (top > 0 && stack[top - 1] == '(') {
                pair[0]++;
                top--;
            } else {
                stack[top++] = ')';
            }
        }
        while (top > 0) {
            char c = stack[--top];
            if (c == '(') {
                pair[1]++;
            } else {
                pair[2]++;
            }
        }
        return pair;
    }

    public int[] GetPowerFactor(int R, int N) {
        List<Integer> list = new ArrayList<>();
        int r = R, n = N;
        int p = 0;
        int l;
        while (r > 0) {
            l = r % n;
            r = r / n;
            if (l > 1) {
                return new int[0];
            } else if (l == 1) {
                list.add(p);
            }
            p++;
        }
        int[] pow = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            pow[i] = list.get(i);
        }
        return pow;
    }

    public int[] WaitInLine(int[] a, int[] b) {
        int n = a.length;
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = i + 1;
        }
        List<List<Integer>> listList = new ArrayList<>();
        permute(seq, listList, 0);
        List<Integer> minList = null;
        int min = Integer.MAX_VALUE;
        for (List<Integer> list : listList) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (i) * a[list.get(i) - 1] + (n - i - 1) * b[list.get(i) - 1];
            }
            if (sum < min) {
                minList = list;
                min = sum;
            }
        }
        int i = 0;
        for (int s : minList) {
            seq[i++] = s;
        }
        System.out.println(min);
        return seq;
    }

    public void permute(int[] arr, List<List<Integer>> listList, int start) {
        if (start == arr.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : arr) {
                list.add(n);
            }
            listList.add(list);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            permute(arr, listList, start + 1);
            swap(arr, start, i);
        }
    }


    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    int[] a;
    int[] b;
    int[] s;
    int min;

    public int[] waitInLine(int[] a, int[] b) {
        int n = a.length;
        this.a = a;
        this.b = b;
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = i + 1;
        }
        s = new int[n];
        List<List<Integer>> listList = new ArrayList<>();
        min = Integer.MAX_VALUE;
        permute(seq, 0);
        return s;
    }

    public void permute(int[] arr, int start) {
        if (start == arr.length) {
            int sum = 0;
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                sum += (i) * a[arr[i] - 1] + (n - i - 1) * b[arr[i] - 1];
            }
            if (sum < min) {
                min = sum;
                for (int i = 0; i < n; i++) {
                    s[i] = arr[i];
                }
            }
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            permute(arr, start + 1);
            swap(arr, start, i);
        }
    }


    @Test
    public void test3() {
        int[] a = {8, 9, 7};
        int[] b = {5, 8, 3};
        int[] s = waitInLine(a, b);
        System.out.println(Arrays.toString(s));
    }


    public int GetMaxStaffs(char[][] pos) {
        int m = pos.length, n = pos[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pos[i][j] == '*' || visited[i][j]) {
                    continue;
                }
                int num = start(pos, i, j, visited);
                count += num;
            }
        }
        return count;
    }

    public int start(char[][] pos, int i, int j, boolean[][] visited) {
        dfs(pos, i, j, visited);
        int max = 1;
        pos[i][j] = '+';

        pos[i][j] = '.';
        return max;
    }


    public void dfs(char[][] pos, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= pos.length || j >= pos[0].length) {
            return;
        }
        if (pos[i][j] == '*' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(pos, i + 1, j, visited);
        dfs(pos, i - 1, j, visited);
        dfs(pos, i, j + 1, visited);
        dfs(pos, i, j - 1, visited);
    }


}
