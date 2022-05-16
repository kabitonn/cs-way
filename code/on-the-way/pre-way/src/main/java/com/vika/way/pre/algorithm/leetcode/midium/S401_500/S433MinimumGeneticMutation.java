package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.*;

public class S433MinimumGeneticMutation {

    char[] genes = {'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        int depth = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        queue.add(start);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                List<String> adjList = getAdjacentList(str, bankSet);
                for (String adj : adjList) {
                    if (!visited.contains(adj)) {
                        queue.add(adj);
                        if (end.equals(adj)) {
                            return depth;
                        }
                        visited.add(adj);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getAdjacentList(String str, Set<String> bankSet) {
        char[] s = str.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            char old = s[i];
            for (int k = 0; k < genes.length; k++) {
                if (s[i] == genes[k]) {
                    continue;
                }
                s[i] = genes[k];
                String adj = String.valueOf(s);
                if (bankSet.contains(adj)) {
                    list.add(adj);
                }
            }
            s[i] = old;
        }
        return list;
    }

    public int minMutation1(String start, String end, String[] bank) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) {
            return -1;
        }
        beginSet.add(start);
        endSet.add(end);
        int depth = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            depth++;
            Set<String> tmp = new HashSet<>();
            for (String str : beginSet) {
                char[] s = str.toCharArray();
                for (int i = 0; i < s.length; i++) {
                    char old = s[i];
                    for (int k = 0; k < genes.length; k++) {
                        if (s[i] == genes[k]) {
                            continue;
                        }
                        s[i] = genes[k];
                        String adj = String.valueOf(s);
                        if (!bankSet.contains(adj)) {
                            continue;
                        }
                        if (endSet.contains(adj)) {
                            return depth;
                        }
                        if (!visited.contains(adj)) {
                            visited.add(adj);
                            tmp.add(adj);
                        }
                    }
                    s[i] = old;
                }
            }
            beginSet = tmp;
        }
        return -1;
    }

    public int minMutation2(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) {
            return -1;
        }
        int min = backtrack(start, end, bankSet, new HashSet<>());
        return min != Integer.MAX_VALUE ? min : -1;
    }

    public int backtrack(String start, String end, Set<String> bank, Set<String> visited) {
        if (start.equals(end)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        visited.add(start);
        for (String s : bank) {
            if (isAdjacent(start, s) && !visited.contains(s)) {
                int depth = backtrack(s, end, bank, visited);
                if (depth != Integer.MAX_VALUE) {
                    min = Math.min(min, depth + 1);
                }
            }
        }
        visited.remove(start);
        return min;
    }

    public boolean isAdjacent(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (++diff > 1) {
                    break;
                }
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        S433MinimumGeneticMutation solution = new S433MinimumGeneticMutation();
        String[] bank = {"AAAAAAAA", "AAAAAAAC", "AAAAAACC", "AAAAACCC", "AAAACCCC", "AACACCCC", "ACCACCCC", "ACCCCCCC", "CCCCCCCA"};
        System.out.println(solution.minMutation1("AAAAAAAA", "CCCCCCCC", bank));
    }

}
