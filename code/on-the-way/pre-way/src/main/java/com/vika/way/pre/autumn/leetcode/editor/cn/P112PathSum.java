//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索 
// 👍 416 👎 0


//Java：路径总和

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Stack;

public class P112PathSum {
    public static void main(String[] args) {
        Solution solution = new P112PathSum().new Solution();
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
        public boolean hasPathSum1(TreeNode root, int sum) {
            return pathSum(root, sum);
        }

        public boolean pathSum(TreeNode p, int sum) {
            if (p == null) {
                return false;
            }
            sum -= p.val;
            if (p.left == null && p.right == null && 0 == sum) {
                return true;
            }
            return pathSum(p.left, sum) || pathSum(p.right, sum);
        }

        public boolean hasPathSum(TreeNode root, int sum) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> leftSumStack = new Stack<>();
            TreeNode p = root;
            int leftSum = sum;
            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    leftSum -= p.val;
                    leftSumStack.push(leftSum);
                    p = p.left;
                }
                p = stack.pop();
                leftSum = leftSumStack.pop();
                if (p.left == null && p.right == null && leftSum == 0) {
                    return true;
                }
                p = p.right;
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}