package com.vika.way.pre.algorithm.leetcode.easy.S501_600;


import com.vika.way.pre.algorithm.leetcode.common.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class S589NaryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(Node p, List<Integer> list) {
        if (p == null) {
            return;
        }
        list.add(p.val);
        for (Node child : p.children) {
            preorder(child, list);
        }
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node p;
        while (!stack.isEmpty()) {
            p = stack.pop();
            list.add(p.val);
            List<Node> nodes = p.children;
            for (int i = nodes.size() - 1; i >= 0; i--) {
                stack.push(nodes.get(i));
            }
        }
        return list;
    }
}
