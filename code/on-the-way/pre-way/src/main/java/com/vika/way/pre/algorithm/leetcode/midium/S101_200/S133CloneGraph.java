package com.vika.way.pre.algorithm.leetcode.midium.S101_200;


import java.util.*;


public class S133CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node, newNode);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (Node neighbor : curNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    queue.add(neighbor);
                    Node n = new Node(neighbor.val, new ArrayList<>());
                    map.put(neighbor, n);
                }
                map.get(curNode).neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }

    public Node cloneGraph1(Node node) {
        if (node == null) {
            return node;
        }
        Map<Node, Node> map = new HashMap<>();
        return cloneGraph1(node, map);
    }

    public Node cloneGraph1(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node n = new Node(node.val, new ArrayList<>());
        map.put(node, n);
        for (Node neighbor : node.neighbors) {
            n.neighbors.add(cloneGraph1(neighbor, map));
        }
        return n;
    }
}
