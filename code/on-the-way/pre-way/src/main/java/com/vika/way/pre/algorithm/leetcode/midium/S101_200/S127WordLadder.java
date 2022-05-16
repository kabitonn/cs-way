package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

import java.util.*;

public class S127WordLadder {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        boolean found = false;
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> adjacentList = getAdjacentList(word, wordSet);
                for (String adjacent : adjacentList) {
                    if (!visited.contains(adjacent)) {
                        visited.add(adjacent);
                        if (adjacent.equals(endWord)) {
                            found = true;
                        }
                        queue.add(adjacent);
                    }
                }
            }
            depth++;
            if (found) {
                return depth;
            }
        }
        return 0;
    }

    private List<String> getAdjacentList(String str, Set<String> wordSet) {
        List<String> list = new ArrayList<>();
        char[] s = str.toCharArray();
        for (int i = 0; i < s.length; i++) {
            char old = s[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (s[i] == c) {
                    continue;
                }
                s[i] = c;
                String t = String.valueOf(s);
                if (wordSet.contains(t)) {
                    list.add(t);
                }
            }
            s[i] = old;
        }
        return list;
    }

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, List<String>> adjacentMap = getAdjacentMap(beginWord, wordList);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> adjacentList = adjacentMap.get(word);
                for (String adjacent : adjacentList) {
                    if (!visited.contains(adjacent)) {
                        visited.add(adjacent);
                        if (adjacent.equals(endWord)) {
                            return depth;
                        }
                        queue.add(adjacent);
                    }
                }
            }
        }
        return 0;
    }

    private Map<String, List<String>> getAdjacentMap(String begin, List<String> wordList) {
        List<String> words = new ArrayList<>(wordList);
        words.add(begin);
        Map<String, List<String>> patternMap = new HashMap<>();
        words.forEach(word -> {
            char[] s = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char old = s[i];
                s[i] = '*';
                String p = String.valueOf(s);
                List<String> adjacentList = patternMap.getOrDefault(p, new ArrayList<>());
                adjacentList.add(word);
                patternMap.put(p, adjacentList);
                s[i] = old;
            }
        });
        Map<String, List<String>> adjacentMap = new HashMap<>();
        for (String word : words) {
            char[] s = word.toCharArray();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < s.length; i++) {
                char old = s[i];
                s[i] = '*';
                String p = String.valueOf(s);
                List<String> patternList = patternMap.getOrDefault(p, new ArrayList<>());
                for (String adj : patternList) {
                    if (adj.equals(word)) {
                        continue;
                    }
                    list.add(adj);
                }
                s[i] = old;
            }
            adjacentMap.put(word, list);
        }
        return adjacentMap;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        int depth = 1;
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            depth++;
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] s = word.toCharArray();
                for (int i = 0; i < s.length; i++) {
                    char old = s[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        s[i] = c;
                        String target = String.valueOf(s);
                        if (endSet.contains(target)) {
                            return depth;
                        }
                        if (!visited.contains(target) && wordSet.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                    }
                    s[i] = old;
                }
            }
            beginSet = temp;
        }
        return 0;
    }

    //因为把 beginWord 和 endWord 都加入了路径，所以初始化 2
    private int len = 2;

    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // 利用 BFS 得到所有的邻居节点
        Set<String> set1 = new HashSet<>();
        set1.add(beginWord);
        Set<String> set2 = new HashSet<>();
        set2.add(endWord);
        Set<String> wordSet = new HashSet<>(wordList);
        //最后没找到返回 0
        if (!twoEndBfs(set1, set2, wordSet)) {
            return 0;
        }
        return len;
    }

    private boolean twoEndBfs(Set<String> set1, Set<String> set2, Set<String> wordSet) {
        if (set1.isEmpty() || set2.isEmpty()) {
            return false;
        }
        // set1 的数量多，就反向扩展
        if (set1.size() > set2.size()) {
            return twoEndBfs(set2, set1, wordSet);
        }
        // 将已经访问过单词删除
        wordSet.removeAll(set1);
        wordSet.removeAll(set2);
        // 保存新扩展得到的节点
        Set<String> set = new HashSet<>();
        for (String word : set1) {
            // 遍历每一位
            for (int i = 0; i < word.length(); i++) {
                char[] s = word.toCharArray();

                // 尝试所有字母
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (s[i] == ch) {
                        continue;
                    }
                    s[i] = ch;
                    String adj = new String(s);
                    if (set2.contains(adj)) {
                        return true;
                    }
                    // 如果还没有相遇，并且新的单词在 word 中，那么就加到 set 中
                    if (wordSet.contains(adj)) {
                        set.add(adj);
                    }
                }
            }
        }
        len++;
        // 一般情况下新扩展的元素会多一些，所以我们下次反方向扩展 set2
        return twoEndBfs(set2, set, wordSet);
    }
}
