package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import com.vika.way.pre.algorithm.nowcoder.datastructure.TreeNode;

import java.util.*;

public class SymmetricalTree {

    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    boolean isSymmetrical(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSymmetrical(p.left, q.right) && isSymmetrical(p.right, q.left);
    }

    boolean isSymmetrical1(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        Stack<TreeNode> stackLeft = new Stack<>();
        Stack<TreeNode> stackRight = new Stack<>();
        TreeNode curLeft = pRoot;
        TreeNode curRight = pRoot;
        while (curLeft != null || !stackLeft.isEmpty() || curRight != null || !stackRight.isEmpty()) {
            while (curLeft != null) {
                stackLeft.push(curLeft);
                curLeft = curLeft.left;
            }
            while (curRight != null) {
                stackRight.push(curRight);
                curRight = curRight.right;
            }
            if (stackLeft.size() != stackRight.size()) {
                return false;
            }
            curLeft = stackLeft.pop();
            curRight = stackRight.pop();
            if (curLeft.val != curRight.val) {
                return false;
            }
            curLeft = curLeft.right;
            curRight = curRight.left;
        }
        return true;
    }

    public boolean isSymmetrical2(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(pRoot.left);
        queue.push(pRoot.right);
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

    boolean isSymmetrical3(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                if (p != null) {
                    queue.add(p.left);
                    queue.add(p.right);
                    list.add(p.val);
                } else {
                    list.add(null);
                }
            }
            for (int i = 0, j = size - 1; i < j; i++, j--) {
                if (list.get(i) == null && list.get(j) == null) {
                    continue;
                } else if (list.get(i) == null || list.get(j) == null) {
                    return false;
                } else if (!list.get(i).equals(list.get(j))) {
                    return false;
                }
                /*
                if(list.get(i) != list.get(j)) {
                    return false;
                }
                 */
            }
        }
        return true;
    }
}
