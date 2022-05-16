package com.vika.way.pre.algorithm.leetcode.midium.S501_600;



import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S515FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                max = Math.max(p.val, max);
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            list.add(max);
        }
        return list;
    }

    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    public void dfs(TreeNode p, List<Integer> list, int depth) {
        if (p == null) {
            return;
        }
        if (depth == list.size()) {
            list.add(p.val);
        } else if (list.get(depth) < p.val) {
            list.set(depth, p.val);
        }
        dfs(p.left, list, depth + 1);
        dfs(p.right, list, depth + 1);
    }
}
