package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.*;

public class S332ReconstructItinerary {
    public static void main(String[] args) {
        S332ReconstructItinerary solution = new S332ReconstructItinerary();
        List<List<String>> listList = new ArrayList<>();
        listList.add(Arrays.asList("JFK", "KUL"));
        listList.add(Arrays.asList("JFK", "NRT"));
        listList.add(Arrays.asList("NRT", "JFK"));
        System.out.println(solution.findItinerary1(listList));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        List<String> list = new LinkedList<>();
        Map<String, PriorityQueue<String>> adjMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (adjMap.containsKey(from)) {
                adjMap.get(from).add(to);
            } else {
                PriorityQueue<String> queue = new PriorityQueue<>();
                queue.add(to);
                adjMap.put(from, queue);
            }
        }
        dfs(list, "JFK", adjMap);
        return list;
    }

    public void dfs(List<String> list, String from, Map<String, PriorityQueue<String>> adjMap) {
        Queue<String> adjQueue = adjMap.get(from);
        while (adjQueue != null && adjQueue.size() > 0) {
            String to = adjQueue.poll();
            dfs(list, to, adjMap);
        }
        list.add(0, from);
    }

    public List<String> findItinerary1(List<List<String>> tickets) {
        List<String> list = new LinkedList<>();
        Map<String, PriorityQueue<String>> adjMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            PriorityQueue<String> queue = adjMap.computeIfAbsent(from, key -> new PriorityQueue<>());
            queue.add(to);
        }
        dfs1(list, "JFK", adjMap);
        return list;
    }

    public void dfs1(List<String> list, String from, Map<String, PriorityQueue<String>> adjMap) {
        Stack<String> stack = new Stack<>();
        stack.push(from);
        while (!stack.isEmpty()) {
            Queue<String> adjQueue = null;
            while ((adjQueue = adjMap.get(stack.peek())) != null && adjQueue.size() > 0) {
                String to = adjQueue.poll();
                stack.push(to);
            }
            list.add(0, stack.pop());
        }
    }
}
