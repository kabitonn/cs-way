//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 743 👎 0


//Java：验证二叉搜索树

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Stack;

public class P98ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P98ValidateBinarySearchTree().new Solution();
        // TO TEST
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public boolean isValidBST1(TreeNode root) {
            return isValid(root);
        }

        public boolean isValid(TreeNode p) {
            if (p == null) {
                return true;
            }
            if (p.left != null) {
                TreeNode left = p.left;
                while (left.right != null) {
                    left = left.right;
                }
                if (left.val >= p.val) {
                    return false;
                }
            }
            if (p.right != null) {
                TreeNode right = p.right;
                while (right.left != null) {
                    right = right.left;
                }
                if (right.val <= p.val) {
                    return false;
                }
            }
            return isValid(p.left) && isValid(p.right);
        }

        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p = root;
            TreeNode prev = null;
            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
                p = stack.pop();
                if (prev != null && prev.val >= p.val) {
                    return false;
                }
                prev = p;
                p = p.right;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}