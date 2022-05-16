//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 461 👎 0


//Java：平衡二叉树

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P110BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P110BalancedBinaryTree().new Solution();
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
        public boolean isBalanced1(TreeNode root) {
            return isBalancedTree(root);
        }

        public boolean isBalancedTree(TreeNode p) {
            if (p == null) {
                return true;
            }
            if (Math.abs(maxDepth(p.left) - maxDepth(p.right)) > 1) {
                return false;
            }
            return isBalancedTree(p.left) && isBalancedTree(p.right);
        }

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }

        public boolean isBalanced(TreeNode root) {
            return depth(root) != -1;
        }

        public int depth(TreeNode p) {
            if (p == null) {
                return 0;
            }
            int left = depth(p.left);
            int right = depth(p.right);
            if (left == -1 || right == -1) {
                return -1;
            }
            if (Math.abs(left - right) <= 1) {
                return Math.max(left, right) + 1;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}