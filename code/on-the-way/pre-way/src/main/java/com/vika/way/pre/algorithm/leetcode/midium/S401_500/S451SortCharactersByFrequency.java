package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.*;

public class S451SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!count.containsKey(c)) {
                count.put(c, 0);
            }
            count.put(c, count.get(c) + 1);
        }
        int n = count.size();
        Character[] chars = new Character[n];
        count.keySet().toArray(chars);
        Arrays.sort(chars, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return count.get(o1) - count.get(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < count.get(chars[i]); j++) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public String frequencySort1(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return count[o2] - count[o1];
            }
        });
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            priorityQueue.add((char) i);
        }
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            char c = priorityQueue.poll();
            for (int i = 0; i < count[c]; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String frequencySort3(String s) {
        int[] count = new int[128];
        int max = 0;
        for (char c : s.toCharArray()) {
            count[c]++;
            max = Math.max(max, count[c]);
        }
        List<Character>[] buckets = new List[max + 1];
        for (int c = 0; c < count.length; c++) {
            if (buckets[count[c]] == null) {
                buckets[count[c]] = new ArrayList<>();
            }
            buckets[count[c]].add((char) c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = max; i > 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int k = 0; k < i; k++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }

    public String frequencySort2(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int[] copy = count.clone();
        Arrays.sort(count);
        int n = count.length;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (count[i] == 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (count[i] != copy[j]) {
                    continue;
                }
                while (copy[j]-- > 0) {
                    sb.append((char) j);
                }
            }
        }
        return sb.toString();
    }
}
