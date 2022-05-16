package com.vika.way.pre.algorithm.leetcode.easy.S501_600;


import com.vika.way.pre.algorithm.leetcode.common.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class S590NaryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        postorder(root, list);
        return list;
    }

    public void postorder(Node p, List<Integer> list) {
        if (p == null) {
            return;
        }
        for (Node child : p.children) {
            postorder(child, list);
        }
        list.add(p.val);
    }

    public List<Integer> postorder1(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node p;
        while (!stack.isEmpty()) {
            p = stack.pop();
            list.add(0, p.val);
            for (Node child : p.children) {
                stack.push(child);
            }
        }
        return list;
    }
}
