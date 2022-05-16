package com.vika.way.pre.algorithm.leetcode.hard.S001_200;

import java.util.*;

public class S140WordBreakII {

    public static void main(String[] args) {
        S140WordBreakII solution =new S140WordBreakII();
        List<String> wordList = new ArrayList<>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        System.out.println(solution.wordBreak3("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", wordList));
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, new HashSet<>(wordDict));
    }

    public List<String> wordBreak(String s, int start, Set<String> wordSet) {
        List<String> list = new ArrayList<>();
        if (start == s.length()) {
            list.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (wordSet.contains(prefix)) {
                List<String> strs = wordBreak(s, end, wordSet);
                for (String str : strs) {
                    list.add(prefix + (str.equals("") ? "" : " ") + str);
                }
            }
        }
        return list;
    }

    public List<String> wordBreak1(String s, List<String> wordDict) {
        return wordBreak1(s, 0, new HashSet<>(wordDict), new HashMap<Integer, List<String>>());
    }

    public List<String> wordBreak1(String s, int start, Set<String> wordSet, Map<Integer, List<String>> map) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> list = new ArrayList<>();
        if (start == s.length()) {
            list.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (wordSet.contains(prefix)) {
                List<String> strs = wordBreak1(s, end, wordSet, map);
                for (String str : strs) {
                    list.add(prefix + (str.equals("") ? "" : " ") + str);
                }
            }
        }
        map.put(start, list);
        return list;
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        return wordBreak2(s, s.length(), new HashSet<>(wordDict), new HashMap<Integer, List<String>>());
    }

    public List<String> wordBreak2(String s, int end, Set<String> wordSet, Map<Integer, List<String>> map) {
        if (map.containsKey(end)) {
            return map.get(end);
        }
        List<String> list = new ArrayList<>();
        if (end == 0) {
            return list;
        }
        for (int start = 0; start <= end; start++) {
            String posterfix = s.substring(start, end);
            if (wordSet.contains(posterfix)) {
                if (start == 0) {
                    list.add(posterfix);
                } else {
                    List<String> strs = wordBreak2(s, start, wordSet, map);
                    for (String str : strs) {
                        list.add(str + " " + posterfix);
                    }
                }
            }
        }
        map.put(end, list);
        return list;
    }

    public List<String> wordBreak3(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String>[] dp = new ArrayList[len + 1];
        dp[0] = new ArrayList<>();
        dp[0].add("");
        for (int i = 1; i <= len; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                String posterfix = s.substring(j, i);
                if (dp[j].size() > 0 && wordSet.contains(posterfix)) {
                    for (String str : dp[j]) {
                        list.add(str + (str.equals("") ? "" : " ") + posterfix);
                    }
                }
            }
            dp[i] = list;
        }
        return dp[len];
    }

    public List<String> wordBreak3_2(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();
        List<String>[] dp = new ArrayList[len + 1];
        dp[len] = new ArrayList<>();
        dp[len].add("");
        for (int i = len - 1; i >= 0; i--) {
            List<String> list = new ArrayList<>();
            for (int j = len; j > i; j--) {
                String prefix = s.substring(i, j);
                if (dp[j].size() > 0 && wordSet.contains(prefix)) {
                    if(j==len){
                        list.add(prefix);
                        continue;
                    }
                    for (String str : dp[j]) {
                        list.add(prefix + " " + str);
                    }
                }
            }
            dp[i] = list;
        }
        return dp[0];
    }


    public List<String> wordBreak4(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        List<String> list = new ArrayList<>();
        if (dp[len]) {
            Deque<String> queue = new LinkedList<>();
            dfs(list, s, len, wordSet, queue, dp);
        }
        return list;
    }

    private void dfs(List<String> list, String s, int end, Set<String> wordSet, Deque<String> queue, boolean[] dp) {
        if (end == 0) {
            StringBuilder sb = new StringBuilder();
            for (String word : queue) {
                sb.append(word);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < end; i++) {
            if (dp[i]) {
                String suffix = s.substring(i, end);
                if (wordSet.contains(suffix)) {
                    queue.addFirst(suffix);
                    dfs(list, s, i, wordSet, queue, dp);
                    queue.removeFirst();
                }
            }
        }
    }
}
