package com.vika.way.pre.algorithm.leetcode.midium.S001_100;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S095UniqueBinarySearchTreesII {

    public static void main(String[] args) {
        S095UniqueBinarySearchTreesII solution = new S095UniqueBinarySearchTreesII();
        System.out.println(solution.generateTrees2(2));
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }

        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            TreeNode t = new TreeNode(start);
            list.add(t);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = generateTrees(start, i - 1);
            List<TreeNode> rightList = generateTrees(i + 1, end);
            for (TreeNode leftTree : leftList) {
                for (TreeNode rightTree : rightList) {
                    TreeNode r = new TreeNode(i);
                    r.left = leftTree;
                    r.right = rightTree;
                    list.add(r);
                }
            }

        }
        return list;
    }

    public List<TreeNode> generateTrees1(int n) {
        List<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>();
        if (n == 0) {
            return dp[0];
        }
        dp[0].add(null);
        for (int len = 1; len <= n; len++) {
            dp[len] = new ArrayList<>();
            for (int root = 1; root <= len; root++) {
                int leftLen = root - 1;
                int rightLen = len - root;
                for (TreeNode l : dp[leftLen]) {
                    for (TreeNode r : dp[rightLen]) {
                        TreeNode treeNode = new TreeNode(root);
                        treeNode.left = l;
                        treeNode.right = clone(r, root);
                        dp[len].add(treeNode);
                    }
                }

            }
        }
        return dp[n];
    }

    public List<TreeNode> generateTrees2(int n) {
        List<TreeNode> pre = new ArrayList<>();
        if (n == 0) {
            return pre;
        }
        pre.add(null);
        for (int i = 1; i <= n; i++) {
            List<TreeNode> cur = new ArrayList<>();
            //遍历之前的所有解
            for (TreeNode preNode : pre) {
                TreeNode maxNode = new TreeNode(i);
                //插入到根节点
                maxNode.left = preNode;
                cur.add(maxNode);
                for (int j = 0; j < pre.size(); j++) {
                    TreeNode preRoot = clone(preNode, 0);
                    TreeNode right = preRoot;
                    int k = 0;
                    //遍历 j 次找右孩子
                    while (right != null && k++ < j) {
                        right = right.right;
                    }
                    if (right == null) {
                        break;
                    }
                    //保存当前右孩子的位置的子树作为插入节点的左孩子
                    TreeNode rightNode = right.right;
                    maxNode = new TreeNode(i);
                    //右孩子是插入的节点
                    right.right = maxNode;
                    //插入节点的左孩子更新为插入位置之前的子树
                    maxNode.left = rightNode;
                    cur.add(preRoot);
                }
            }
            pre = cur;
        }
        return pre;
    }

    private TreeNode clone(TreeNode t, int offset) {
        if (t == null) {
            return null;
        }
        TreeNode root = new TreeNode(t.val + offset);
        root.left = clone(t.left, offset);
        root.right = clone(t.right, offset);
        return root;
    }
}
