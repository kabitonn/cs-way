package com.vika.way.pre.algorithm.leetcode.midium.S201_300;



import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.*;

public class S236LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }

    TreeNode ancestor = null;

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        hasChild(root, p, q);
        return ancestor;
    }

    public boolean hasChild(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int parent = (root == p || root == q) ? 1 : 0;
        int left = hasChild(root.left, p, q) ? 1 : 0;
        int right = hasChild(root.right, p, q) ? 1 : 0;
        int sum = parent + left + right;
        if (sum == 2) {
            ancestor = root;
        }
        return sum > 0;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (hasChild(p, q)) {
            return p;
        }
        if (hasChild(q, p)) {
            return q;
        }
        TreeNode ancestor = null;
        TreeNode node = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0, maxDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (maxDepth == depth) {
                    //同层内不会再有别的祖先
                    continue;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (hasChild(node, p) && hasChild(node, q)) {
                    maxDepth = depth;
                    ancestor = node;
                }
            }
            if (maxDepth < depth) {
                //遍历完该层后未发现新的祖先，说明最近祖先已经找到
                break;
            }
        }
        return ancestor;
    }

    public boolean hasChild(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return hasChild(root.left, p) || hasChild(root.right, p);
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        dfs(root, parent);
        TreeNode l1 = p, l2 = q;
        while (l1 != l2) {
            l1 = parent.getOrDefault(l1, q);
            l2 = parent.getOrDefault(l2, p);
        }
        return l1;
    }

    public void dfs(TreeNode root, Map<TreeNode, TreeNode> parent) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parent.put(root.left, root);
        }
        if (root.right != null) {
            parent.put(root.right, root);
        }
        dfs(root.left, parent);
        dfs(root.right, parent);
    }

    public TreeNode lowestCommonAncestor4(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent.put(root, null);
        queue.add(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    parent.put(node.left, node);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    parent.put(node.right, node);
                }
            }
        }
        Set<TreeNode> pAncestors = new HashSet<>();
        while (p != null) {
            pAncestors.add(p);
            p = parent.get(p);
        }
        while (!pAncestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}
