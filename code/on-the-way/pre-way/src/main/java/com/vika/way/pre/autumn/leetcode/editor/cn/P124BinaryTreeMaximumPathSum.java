//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
// 
//
// 示例 2： 
//
// 输入：[-10,9,20,null,null,15,7]
//
//      -10
//      / \
//     9  20
//      /   \
//     15    7
//
//输出：42 
// Related Topics 树 深度优先搜索 
// 👍 691 👎 0


//Java：二叉树中的最大路径和

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P124BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new P124BinaryTreeMaximumPathSum().new Solution();
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
        public int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxSinglePathSum(root);
            return max;
        }

        public int maxSinglePathSum(TreeNode p) {
            if (p == null) {
                return 0;
            }
            int leftSum = Math.max(maxSinglePathSum(p.left), 0);
            int rightSum = Math.max(maxSinglePathSum(p.right), 0);
            max = Math.max(max, leftSum + rightSum + p.val);
            return Math.max(leftSum, rightSum) + p.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}