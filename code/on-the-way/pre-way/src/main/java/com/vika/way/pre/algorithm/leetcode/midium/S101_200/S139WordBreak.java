package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

import java.util.*;

public class S139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        return wordBreak(s, wordDict, "", map);
    }

    public boolean wordBreak(String s, List<String> wordList, String temp, Map<String, Boolean> map) {
        if (temp.length() > s.length()) {
            return false;
        }
        if (map.containsKey(temp)) {
            return map.get(temp);
        }
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) != s.charAt(i)) {
                return false;
            }
        }
        if (temp.length() == s.length()) {
            return true;
        }
        for (String word : wordList) {
            if (wordBreak(s, wordList, temp + word, map)) {
                map.put(temp, true);
                return true;
            }
        }
        map.put(temp, false);
        return false;
    }

    public boolean wordBreak2_2_0(String s, List<String> wordDict) {
        return wordBreak2_2_0(s, new HashSet(wordDict), 0);
    }

    public boolean wordBreak2_2_0(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreak2_2_0(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak2_1(String s, List<String> wordDict) {
        return wordBreak2_1(s, new HashSet(wordDict), s.length(), new Boolean[s.length() + 1]);
    }

    public boolean wordBreak2_1(String s, Set<String> wordDict, int end, Boolean[] memo) {
        if (end == 0) {
            return true;
        }
        if (memo[end] != null) {
            return memo[end];
        }
        for (int start = 0; start <= end; start++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreak2_1(s, wordDict, start, memo)) {
                return memo[end] = true;
            }
        }
        return memo[end] = false;
    }

    public boolean wordBreak2_2(String s, List<String> wordDict) {
        return wordBreak2_2(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }

    public boolean wordBreak2_2(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreak2_2(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }


    public boolean wordBreak1_1(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return wordBreak1_1(s, wordSet, new HashMap<String, Boolean>());
    }

    public boolean wordBreak1_1(String s, Set<String> wordSet, Map<String, Boolean> map) {
        if (s.length() == 0) {
            return true;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i < s.length(); i++) {
            if (wordSet.contains(s.substring(i)) && wordBreak1_1(s.substring(0, i), wordSet, map)) {
                map.put(s, true);
                return true;
            }
        }

        map.put(s, false);
        return false;
    }

    public boolean wordBreak1_2(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return wordBreak1_2(s, wordSet, new HashMap<String, Boolean>());
    }

    public boolean wordBreak1_2(String s, Set<String> wordSet, Map<String, Boolean> map) {
        if (s.length() == 0) {
            return true;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = s.length(); i > 0; i--) {
            if (wordSet.contains(s.substring(0, i)) && wordBreak1_2(s.substring(i), wordSet, map)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

    public boolean wordBreak3_1(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && wordSet.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak3_2(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[len] = true;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len; j > i; j--) {
                dp[i] = dp[j] && wordSet.contains(s.substring(i, j));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }


    public boolean wordBreak5(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }


}
