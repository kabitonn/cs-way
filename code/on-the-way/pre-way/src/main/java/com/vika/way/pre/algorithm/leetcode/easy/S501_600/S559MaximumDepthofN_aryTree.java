package com.vika.way.pre.algorithm.leetcode.easy.S501_600;



import com.vika.way.pre.algorithm.leetcode.common.Node;

import java.util.LinkedList;
import java.util.Queue;

public class S559MaximumDepthofN_aryTree {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node p : root.children) {
            max = Math.max(max, maxDepth(p));
        }
        return max + 1;
    }

    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            Node p;
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                for (Node child : p.children) {
                    queue.offer(child);
                }
            }
        }
        return depth;
    }
}
