package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.*;

public class S310MinimumHeightTrees {

    public static void main(String[] args) {
        S310MinimumHeightTrees solution = new S310MinimumHeightTrees();
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        System.out.println(solution.findMinHeightTrees2(6, edges));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] adjacentList = new List[n];
        for (int i = 0; i < n; i++) {
            adjacentList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjacentList[u].add(v);
            adjacentList[v].add(u);
        }
        int minHeight = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int height = 0;
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                height++;
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int k = queue.poll();
                    for (int adj : adjacentList[k]) {
                        if (!visited[adj]) {
                            queue.add(adj);
                            visited[adj] = true;
                        }
                    }
                }
            }
            if (height <= minHeight) {
                minHeight = height;
                List<Integer> list = map.getOrDefault(height, new ArrayList<>());
                list.add(i);
                map.put(height, list);
            }

        }
        return map.get(minHeight);
    }

    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        List<Integer>[] adjacentList = new List[n];
        Set<Integer> nodes = new HashSet<>();
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            adjacentList[i] = new ArrayList<>();
            nodes.add(i);
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjacentList[u].add(v);
            adjacentList[v].add(u);
            degree[u]++;
            degree[v]++;
        }
        while (nodes.size() > 2) {
            List<Integer> removeList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1) {
                    removeList.add(i);
                }
            }
            for (Integer leaf : removeList) {
                degree[leaf]--;
                nodes.remove(leaf);
                for (int adj : adjacentList[leaf]) {
                    degree[adj]--;
                }
            }
        }
        return new ArrayList<>(nodes);
    }

    public List<Integer> findMinHeightTrees1_1(int n, int[][] edges) {
        List<Integer>[] adjacentList = new List[n];
        Set<Integer> nodes = new HashSet<>();
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            adjacentList[i] = new ArrayList<>();
            nodes.add(i);
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjacentList[u].add(v);
            adjacentList[v].add(u);
            degree[u]++;
            degree[v]++;
        }
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                leaves.add(i);
            }
        }
        while (nodes.size() > 2) {
            int size = leaves.size();
            for (int i = 0; i < size; i++) {
                Integer leaf = leaves.poll();
                nodes.remove(leaf);
                for (Integer adj : adjacentList[leaf]) {
                    if (--degree[adj] == 1) {
                        leaves.add(adj);
                    }
                }
            }
        }
        return new ArrayList<>(nodes);
    }

    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        Set<Integer> nodes = new HashSet<>();
        List<Integer>[] adjacentList = new List[n];
        for (int i = 0; i < n; i++) {
            adjacentList[i] = new ArrayList<>();
            nodes.add(i);
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjacentList[u].add(v);
            adjacentList[v].add(u);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adjacentList[i].size() == 1) {
                leaves.add(i);
            }
        }
        int size = n;
        while (size > 2) {
            size -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (Integer leaf : leaves) {
                nodes.remove(leaf);
                for (Integer adj : adjacentList[leaf]) {
                    adjacentList[adj].remove(leaf);
                    if (adjacentList[adj].size() == 1) {
                        newLeaves.add(adj);
                    }
                }
            }
            leaves = newLeaves;
        }
        return new ArrayList<>(nodes);
    }

    public List<Integer> findMinHeightTrees3(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        int[][] gra = new int[n][];
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (gra[a] == null) {
                gra[a] = edge;
            } else {
                gra[b] = edge;
            }
        }
        int root = getRoot(gra);
        int[] node = getNode(gra, root);
        root = reverse(gra, root, node[0]);
        node = getNode(gra, root);

        //System.out.println(root + "/" + node[0] + ":" + node[1]);

        int len = node[1] / 2;
        int p = node[0];
        while (len-- != 0) {
            p = getNext(gra, p);
        }
        res.add(p);
        if ((node[1] & 1) == 1) {
            res.add(getNext(gra, p));
        }

        return res;
    }

    private int reverse(int[][] gra, int root, int p) {
        int ret = p;
        int[] pre = null;
        while (p != root) {
            int next = getNext(gra, p);
            int[] temp = gra[p];
            gra[p] = pre;
            pre = temp;
            p = next;
        }
        gra[root] = pre;
        return ret;
    }

    private int[] getNode(int[][] gra, int root) {
        int n = gra.length;
        int max = 0, node = 0;
        int[] h = new int[n];
        int[] stack = new int[n];
        int size = 0;
        for (int i = 0; i < n; i++) {
            int p = i, count = 0;
            while (p != root && h[p] == 0) {
                stack[size++] = p;
                p = getNext(gra, p);
            }
            while (size != 0) {
                int temp = stack[--size];
                h[temp] = h[p] + 1;
                if (h[temp] > max) {
                    max = h[temp];
                    node = temp;
                }
                p = temp;
            }
        }
        return new int[]{node, h[node]};
    }

    private int getRoot(int[][] gra) {
        int p = 0;
        while (gra[p] != null) {
            p = getNext(gra, p);
        }
        return p;
    }

    private int getNext(int[][] gra, int p) {
        int[] ret = gra[p];
        return ret[0] == p ? ret[1] : ret[0];
    }


}
