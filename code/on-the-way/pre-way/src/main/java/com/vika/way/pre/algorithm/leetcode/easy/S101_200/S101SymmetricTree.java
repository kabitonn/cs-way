package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.*;

public class S101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

    public boolean isSymmetric0(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stackLeft = new Stack<>();
        Stack<TreeNode> stackRight = new Stack<>();
        TreeNode curLeft = root.left;
        TreeNode curRight = root.right;
        while (curLeft != null || !stackLeft.isEmpty() || curRight != null || !stackRight.isEmpty()) {
            // 节点不为空一直压栈
            while (curLeft != null) {
                stackLeft.push(curLeft);
                curLeft = curLeft.left;
            }
            while (curRight != null) {
                stackRight.push(curRight);
                curRight = curRight.right;
            }
            //长度不同就返回 false
            if (stackLeft.size() != stackRight.size()) {
                return false;
            }
            // 节点为空，就出栈
            curLeft = stackLeft.pop();
            curRight = stackRight.pop();

            // 当前值判断
            if (curLeft.val != curRight.val) {
                return false;
            }
            curLeft = curLeft.right;
            curRight = curRight.left;
        }
        return true;
    }


    public boolean isSymmetric1(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> line = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pNode = queue.poll();
                if (pNode != null) {
                    line.add(pNode.val);
                    queue.add(pNode.left);
                    queue.add(pNode.right);
                } else {
                    line.add(null);
                }
            }
            for (int i = 0, j = line.size() - 1; i < j; i++, j--) {
                //if(line.get(i)==null&&line.get(j)==null) {continue;}
                if (line.get(i).equals(line.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root.left);
        queue.push(root.right);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p == null && q == null) {
                continue;
            } else if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            queue.push(p.left);
            queue.push(q.right);
            queue.push(p.right);
            queue.push(q.left);
        }
        return true;
    }
}
