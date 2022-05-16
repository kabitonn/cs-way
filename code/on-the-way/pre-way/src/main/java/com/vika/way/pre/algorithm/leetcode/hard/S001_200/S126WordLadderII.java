package com.vika.way.pre.algorithm.leetcode.hard.S001_200;

import java.util.*;

public class S126WordLadderII {

    public static void main(String[] args) {
        S126WordLadderII solution = new S126WordLadderII();
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit";
        String end = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        System.out.println(solution.findLadders6(begin, end, wordList));
    }

    int minPath = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> listList = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return listList;
        }
        boolean[] visited = new boolean[wordList.size()];
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        findLadders(listList, path, beginWord, endWord, wordList, visited);
        return listList;
    }

    public void findLadders(List<List<String>> listList, List<String> path, String beginWord, String endWord, List<String> wordList, boolean[] visited) {
        if (beginWord.equals(endWord)) {
            if (minPath > path.size()) {
                listList.clear();
                listList.add(new ArrayList<>(path));
                minPath = path.size();
            } else if (minPath == path.size()) {
                listList.add(new ArrayList<>(path));
            }
            return;
        }
        //当前的长度到达了 minPath,但没有到达结束单词就提前结束
        if (minPath <= path.size()) {
            return;
        }
        for (int i = 0; i < wordList.size(); i++) {
            if (visited[i]) {
                continue;
            }
            String word = wordList.get(i);
            if (isAdjacent(beginWord, word)) {
                visited[i] = true;
                path.add(word);
                findLadders(listList, path, word, endWord, wordList, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }

    private boolean isAdjacent(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                count++;
            }
            if (count == 2) {
                return false;
            }
        }
        return count == 1;
    }

    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> listList = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return listList;
        }
        Set<String> visited = new HashSet<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        visited.add(beginWord);
        findLadders1(listList, path, beginWord, endWord, wordList, visited);
        return listList;
    }

    public void findLadders1(List<List<String>> listList, List<String> path, String beginWord, String endWord, List<String> wordList, Set<String> visited) {
        if (beginWord.equals(endWord)) {
            if (minPath > path.size()) {
                listList.clear();
                listList.add(new ArrayList<>(path));
                minPath = path.size();
            } else if (minPath == path.size()) {
                listList.add(new ArrayList<>(path));
            }
            return;
        }
        //当前的长度到达了 minPath,但没有到达结束单词就提前结束
        if (minPath <= path.size()) {
            return;
        }
        List<String> adjacentList = getAdjacentList(beginWord, new HashSet<>(wordList));
        for (String word : adjacentList) {
            if (visited.contains(word)) {
                continue;
            }
            visited.add(word);
            path.add(word);
            findLadders1(listList, path, word, endWord, wordList, visited);
            path.remove(path.size() - 1);
            visited.remove(word);
        }
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

    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> listList = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return listList;
        }
        Set<String> visited = new HashSet<>();
        List<String> path = new ArrayList<>();
        Map<String, List<String>> adjacentMap = new HashMap<>();
        wordList.forEach(word -> {
            char[] s = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char old = s[i];
                s[i] = '*';
                String p = String.valueOf(s);
                List<String> adjacentList = adjacentMap.getOrDefault(p, new ArrayList<>());
                adjacentList.add(word);
                adjacentMap.put(p, adjacentList);
                s[i] = old;
            }
        });
        path.add(beginWord);
        visited.add(beginWord);
        findLadders2(listList, path, beginWord, endWord, wordList, adjacentMap, visited);
        return listList;
    }

    public void findLadders2(List<List<String>> listList, List<String> path, String beginWord, String endWord, List<String> wordList, Map<String, List<String>> map, Set<String> visited) {
        if (beginWord.equals(endWord)) {
            if (minPath > path.size()) {
                listList.clear();
                listList.add(new ArrayList<>(path));
                minPath = path.size();
            } else if (minPath == path.size()) {
                listList.add(new ArrayList<>(path));
            }
            return;
        }
        //当前的长度到达了 minPath,但没有到达结束单词就提前结束
        if (minPath <= path.size()) {
            return;
        }
        int len = beginWord.length();
        char[] s = beginWord.toCharArray();
        for (int i = 0; i < len; i++) {
            char old = s[i];
            s[i] = '*';
            String p = String.valueOf(s);
            for (String word : map.getOrDefault(p, new ArrayList<>())) {
                if (visited.contains(word)) {
                    continue;
                }
                visited.add(word);
                path.add(word);
                findLadders2(listList, path, word, endWord, wordList, map, visited);
                path.remove(path.size() - 1);
                visited.remove(word);
            }
            s[i] = old;
        }
    }

    public List<List<String>> findLadders3(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> listList = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return listList;
        }
        Map<String, Integer> levelMap = new HashMap<>();
        Map<String, List<String>> adjacentMap = new HashMap<>();
        findLevelAdjacent3(beginWord, endWord, wordList, adjacentMap, levelMap);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        findLadders3(listList, path, beginWord, endWord, wordList, adjacentMap, levelMap);
        return listList;
    }

    public void findLadders3(List<List<String>> listList, List<String> path, String beginWord, String endWord, List<String> wordList, Map<String, List<String>> adjacentMap, Map<String, Integer> levelMap) {
        if (beginWord.equals(endWord)) {
            listList.add(new ArrayList<>(path));
            return;
        }
        List<String> adjacentList = adjacentMap.getOrDefault(beginWord, new ArrayList<>());
        for (String word : adjacentList) {
            if (levelMap.get(beginWord) + 1 == levelMap.get(word)) {
                path.add(word);
                findLadders3(listList, path, word, endWord, wordList, adjacentMap, levelMap);
                path.remove(path.size() - 1);
            }
        }
    }

    public void findLevelAdjacent3(String beginWord, String endWord, List<String> wordList, Map<String, List<String>> adjacentMap, Map<String, Integer> levelMap) {

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        levelMap.put(beginWord, 0);
        Set<String> wordSet = new HashSet<>(wordList);
        boolean found = false;
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> adjacentList = getAdjacentList(word, wordSet);
                adjacentMap.put(word, adjacentList);
                for (String adjacent : adjacentList) {
                    if (!levelMap.containsKey(adjacent)) {
                        levelMap.put(adjacent, depth);
                        if (adjacent.equals(endWord)) {
                            found = true;
                        }
                        queue.add(adjacent);
                    }
                }
            }
            if (found) {
                break;
            }
        }
    }

    public List<List<String>> findLadders4(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> listList = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return listList;
        }
        Map<String, List<String>> adjacentMap = new HashMap<>();
        findLevelAdjacent4(beginWord, endWord, wordList, adjacentMap);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        findLadders4(listList, path, beginWord, endWord, wordList, adjacentMap);
        return listList;
    }

    public void findLadders4(List<List<String>> listList, List<String> path, String beginWord, String endWord, List<String> wordList, Map<String, List<String>> adjacentMap) {
        if (beginWord.equals(endWord)) {
            listList.add(new ArrayList<>(path));
            return;
        }
        List<String> adjacentList = adjacentMap.getOrDefault(beginWord, new ArrayList<>());
        for (String word : adjacentList) {
            path.add(word);
            findLadders4(listList, path, word, endWord, wordList, adjacentMap);
            path.remove(path.size() - 1);
        }
    }

    public void findLevelAdjacent4(String beginWord, String endWord, List<String> wordList, Map<String, List<String>> adjacentMap) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);
        boolean found = false;
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> adjacentList = getAdjacentList(word, wordSet);
                Iterator<String> iterator = adjacentList.iterator();
                while (iterator.hasNext()) {
                    String adjacent = iterator.next();
                    if (visited.contains(adjacent)) {
                        iterator.remove();
                    } else {
                        subVisited.add(adjacent);
                        queue.add(adjacent);
                        if (adjacent.equals(endWord)) {
                            found = true;
                        }
                    }
                }
                adjacentMap.put(word, adjacentList);
            }
            visited.addAll(subVisited);
            if (found) {
                break;
            }
        }
    }

    //BFS
    public List<List<String>> findLadders5(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> listList = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return listList;
        }

        List<String> path = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        path.add(beginWord);
        queue.add(path);
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                path = queue.poll();
                String word = path.get(path.size() - 1);
                List<String> adjacentList = getAdjacentList(word, wordSet);
                for (String adjacent : adjacentList) {
                    if (!visited.contains(adjacent)) {
                        subVisited.add(adjacent);
                        path.add(adjacent);
                        if (adjacent.equals(endWord)) {
                            found = true;
                            listList.add(new ArrayList<>(path));
                        }
                        queue.add(new ArrayList<>(path));
                        path.remove(path.size() - 1);
                    }
                }
            }
            visited.addAll(subVisited);
            if (found) {
                break;
            }
        }
        return listList;
    }

    //DFS+BFS双向搜索
    public List<List<String>> findLadders6(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> listList = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return listList;
        }
        Map<String, List<String>> adjacentMap = new HashMap<>();

        Set<String> set1 = new HashSet<>();
        set1.add(beginWord);
        Set<String> set2 = new HashSet<>();
        set2.add(endWord);
        Set<String> wordSet = new HashSet<>(wordList);
        twoEndBfs(set1, set2, wordSet, true, adjacentMap);

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        findLadders6(listList, path, beginWord, endWord, adjacentMap);
        return listList;
    }
    //DFS
    private void findLadders6(List<List<String>> listList, List<String> path, String beginWord, String endWord, Map<String, List<String>> adjacentMap) {
        if (beginWord.equals(endWord)) {
            listList.add(new ArrayList<>(path));
            return;
        }
        // 得到所有的下一个的节点
        List<String> adjacentList = adjacentMap.getOrDefault(beginWord, new ArrayList<>());
        for (String adjacent : adjacentList) {
            path.add(adjacent);
            findLadders6(listList, path, adjacent, endWord, adjacentMap);
            path.remove(path.size() - 1);
        }
    }

    //利用递归实现了双向搜索
    //direction 为 true 代表向下扩展，false 代表向上扩展
    private boolean twoEndBfs(Set<String> set1, Set<String> set2, Set<String> wordSet, boolean direction,
                              Map<String, List<String>> adjacentMap) {

        if (set1.isEmpty()) {
            return false;
        }
        // set1 的数量多，就反向扩展
        if (set1.size() > set2.size()) {
            return twoEndBfs(set2, set1, wordSet, !direction, adjacentMap);
        }
        // 将已经访问过单词删除
        wordSet.removeAll(set1);
        wordSet.removeAll(set2);

        boolean done = false;

        // 保存新扩展得到的节点
        Set<String> set = new HashSet<>();

        for (String word : set1) {
            //遍历每一位
            for (int i = 0; i < word.length(); i++) {
                char[] s = word.toCharArray();

                // 尝试所有字母
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (s[i] == ch) {
                        continue;
                    }
                    s[i] = ch;

                    String adj = new String(s);

                    // 根据方向得到 map 的 key 和 val
                    String key = direction ? word : adj;
                    String val = direction ? adj : word;

                    List<String> list = adjacentMap.getOrDefault(key, new ArrayList<>());

                    //如果相遇了就保存结果
                    if (set2.contains(adj)) {
                        done = true;
                        list.add(val);
                        adjacentMap.put(key, list);
                    }

                    //如果还没有相遇，并且新的单词在 wordSet 中，那么就加到 set 中
                    if (!done && wordSet.contains(adj)) {
                        set.add(adj);
                        list.add(val);
                        adjacentMap.put(key, list);
                    }
                }
            }
        }
        //一般情况下新扩展的元素会多一些，所以我们下次反方向扩展  set2
        return done || twoEndBfs(set2, set, wordSet, !direction, adjacentMap);
    }
}
