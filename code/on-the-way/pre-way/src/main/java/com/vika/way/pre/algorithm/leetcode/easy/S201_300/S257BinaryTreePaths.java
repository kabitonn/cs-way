package com.vika.way.pre.algorithm.leetcode.easy.S201_300;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        String string = "" + root.val;
        binaryTreePath(root, result, string);

        return result;
    }

    public void binaryTreePath(TreeNode p, List<String> list, String str) {
        if (p.left == null && p.right == null) {
            list.add(str);
        }
        if (p.left != null) {
            binaryTreePath(p.left, list, str + "->" + p.left.val);
        }
        if (p.right != null) {
            binaryTreePath(p.right, list, str + "->" + p.right.val);
        }
    }

    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        binaryTreePath1(root, result, "");

        return result;
    }

    public void binaryTreePath1(TreeNode p, List<String> list, String str) {
        if (p.left == null && p.right == null) {
            list.add(str + p.val);
            return;
        }
        str += p.val;
        if (p.left != null) {
            binaryTreePath1(p.left, list, str + "->");
        }
        if (p.right != null) {
            binaryTreePath1(p.right, list, str + "->");
        }
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        binaryTreePath2(root, result, "");

        return result;
    }

    public void binaryTreePath2(TreeNode p, List<String> list, String str) {
        if (p == null) {
            return;
        }
        str += p.val;
        if (p.left == null && p.right == null) {
            list.add(str);
        } else {
            binaryTreePath2(p.left, list, str + "->");
            binaryTreePath2(p.right, list, str + "->");
        }
    }

    public List<String> binaryTreePaths3(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        if (root == null) {
            return paths;
        }
        LinkedList<TreeNode> node_stack = new LinkedList<>();
        LinkedList<String> path_stack = new LinkedList<>();
        node_stack.add(root);
        path_stack.add("" + root.val);
        TreeNode node;
        String path;
        while (!node_stack.isEmpty()) {
            node = node_stack.pollLast();
            path = path_stack.pollLast();
            if ((node.left == null) && (node.right == null)) {
                paths.add(path);
            }
            if (node.left != null) {
                node_stack.add(node.left);
                path_stack.add(path + "->" + node.left.val);
            }
            if (node.right != null) {
                node_stack.add(node.right);
                path_stack.add(path + "->" + node.right.val);
            }
        }
        return paths;
    }
    public List<String> binaryTreePaths4(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        if (root == null) {
            return paths;
        }
        LinkedList<TreeNode> node_stack = new LinkedList<>();
        LinkedList<String> path_stack = new LinkedList<>();
        node_stack.add(root);
        path_stack.add("");
        TreeNode node;
        String path = null;
        while (!node_stack.isEmpty()) {
            node = node_stack.pollLast();
            path = path_stack.pollLast();
            path += node.val;
            if ((node.left == null) && (node.right == null)) {
                paths.add(path);
            }
            if (node.left != null) {
                node_stack.add(node.left);
                path_stack.add(path + "->");
            }
            if (node.right != null) {
                node_stack.add(node.right);
                path_stack.add(path + "->");
            }
        }
        return paths;
    }
}