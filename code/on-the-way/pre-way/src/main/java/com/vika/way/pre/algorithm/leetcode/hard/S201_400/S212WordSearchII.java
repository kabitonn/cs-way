package com.vika.way.pre.algorithm.leetcode.hard.S201_400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S212WordSearchII {
    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        S212WordSearchII solution = new S212WordSearchII();
        System.out.println(solution.findWords1(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0) {
            return list;
        }
        int m = board.length, n = board[0].length;
        byte[][] visited = new byte[m][n];
        for (String s : words) {
            byte exist = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (existStart(board, visited, s, i, j, 0)) {
                        list.add(s);
                        exist = 1;
                        break;
                    }
                }
                if (exist == 1) {
                    break;
                }
            }
        }
        return list;
    }

    private boolean existStart(char[][] board, byte[][] visited, String word, int i, int j, int index) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == 1 || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = 1;
        boolean found = existStart(board, visited, word, i + 1, j, index + 1)
            || existStart(board, visited, word, i - 1, j, index + 1)
            || existStart(board, visited, word, i, j + 1, index + 1)
            || existStart(board, visited, word, i, j - 1, index + 1);
        visited[i][j] = 0;
        return found;
    }

    public List<String> findWords1(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        int m = board.length, n = board[0].length;
        byte[][] visted = new byte[m][n];

        TrieNode root = buildTrieTree(words);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findWord(board, visted, i, j, root, set);
            }
        }
        return new ArrayList<>(set);
    }

    public void findWord(char[][] board, byte[][] visited, int i, int j, TrieNode p, Set<String> set) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == 1) {
            return;
        }
        char c = board[i][j];
        if (!p.containsKey(c)) {
            return;
        }
        p = p.get(c);
        if (p.isLeaf) {
            set.add(p.word);
        }
        visited[i][j] = 1;
        findWord(board, visited, i + 1, j, p, set);
        findWord(board, visited, i - 1, j, p, set);
        findWord(board, visited, i, j + 1, p, set);
        findWord(board, visited, i, j - 1, p, set);
        visited[i][j] = 0;
    }

    public TrieNode buildTrieTree(String[] words) {
        TrieNode root = new TrieNode();
        for (String s : words) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.containsKey(c)) {
                    cur = cur.get(c);
                } else {
                    cur = cur.put(c);
                }
            }
            cur.isLeaf = true;
            cur.word = s;
        }
        return root;
    }


    class TrieNode {
        public TrieNode[] children;
        public String word;
        public boolean isLeaf;
        private static final int CHILDRENNUM = 26;

        TrieNode() {
            children = new TrieNode[CHILDRENNUM];
            word = null;
            isLeaf = false;
        }

        public boolean containsKey(char c) {
            return children[c - 'a'] != null;
        }

        public TrieNode put(char c) {
            TrieNode node = new TrieNode();
            children[c - 'a'] = node;
            return node;
        }

        public TrieNode get(char c) {
            return children[c - 'a'];
        }

        public boolean isLeaf() {
            return isLeaf;
        }
    }
}
