package com.vika.way.pre.algorithm.leetcode.midium.S201_300;


import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class S222CountCompleteTreeNodes {
    public int countNodes0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0, count = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            TreeNode p;
            for (int i = 0; i < size; i++) {
                count++;
                p = queue.poll();
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }
        }
        return count;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        //left == right。这说明，左子树一定是满二叉树，因为节点已经填充到右子树了，左子树必定已经填满了。所以左子树的节点总数我们可以直接得到，是2^left - 1，加上当前这个root节点，则正好是2^left。再对右子树进行递归统计。
        //left != right。说明此时最后一层不满，但倒数第二层已经满了，可以直接得到右子树的节点个数。同理，右子树节点+root节点，总数为2^right。再对左子树进行递归查找。

        if (left == right) {
            return countNodes1(root.right) + (1 << left);
        } else {
            return countNodes1(root.left) + (1 << right);
        }
    }

    public int getDepth(TreeNode p) {
        int depth = 0;
        while (p != null) {
            depth++;
            p = p.left;
        }
        return depth;
    }
}
