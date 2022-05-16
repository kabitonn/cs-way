package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringPermutation {

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        permute(chars, 0, list);
        Collections.sort(list);
        return list;
    }

    public void permute(char[] chars, int start, List<String> list) {
        if (start == chars.length) {
            list.add(String.valueOf(chars));
            return;
        }
        for (int i = start; i < chars.length; i++) {
            int j = i - 1;
            while (j >= start && chars[j] != chars[i]) {
                j--;
            }
            if (j != start - 1) {
                continue;
            }
            swap(chars, i, start);
            permute(chars, start + 1, list);
            swap(chars, i, start);
        }
    }

    public void swap(char[] chars, int i, int j) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }

    public ArrayList<String> Permutation1(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<String> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        permute(chars, 0, list, new StringBuilder(), new boolean[str.length()]);
        return list;
    }

    public void permute(char[] s, int index, List<String> list, StringBuilder sb, boolean[] visited) {
        if (index == s.length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && s[i] == s[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            sb.append(s[i]);
            permute(s, index + 1, list, sb, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}
