package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.*;

public class S049GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listList = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            boolean isAnagram = false;
            for (List<String> list : listList) {
                if (isAnagram(list.get(0), strs[i])) {
                    list.add(strs[i]);
                    isAnagram = true;
                }
            }
            if (!isAnagram) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                listList.add(list);
            }

        }

        return listList;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> listList = new ArrayList<>();
        boolean[] used = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (!used[i]) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                for (int j = i + 1; j < strs.length; j++) {
                    if (isAnagram(strs[i], strs[j])) {
                        list.add(strs[j]);
                        used[j] = true;
                    }
                }
                listList.add(list);
            }
        }
        return listList;
    }

    //素数乘积key,key可能会溢出
    public List<List<String>> groupAnagrams2(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    //计数法map存储字符串key
    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] counter = new int[26];
            for (char c : s.toCharArray()) {
                counter[c - 'a']++;
            }
            String key = "";
            for (int i = 0; i < counter.length; i++) {
                key = key + counter[i] + "#";
            }
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    //map存储有序字符串
    public List<List<String>> groupAnagrams4(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String key = String.valueOf(sArray);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
