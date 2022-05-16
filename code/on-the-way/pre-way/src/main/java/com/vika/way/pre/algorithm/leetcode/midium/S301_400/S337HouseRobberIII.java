package com.vika.way.pre.algorithm.leetcode.midium.S301_400;



import com.vika.way.pre.algorithm.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class S337HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sumRoot = root.val;
        if (root.left != null) {
            sumRoot += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            sumRoot += rob(root.right.left) + rob(root.right.right);
        }
        int sumChild = rob(root.left) + rob(root.right);
        return Math.max(sumRoot, sumChild);
    }

    public int rob1(TreeNode root) {
        return rob1(root, new HashMap<>());
    }

    public int rob1(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int sumRoot = root.val;
        if (root.left != null) {
            sumRoot += rob1(root.left.left, memo) + rob1(root.left.right, memo);
        }
        if (root.right != null) {
            sumRoot += rob1(root.right.left, memo) + rob1(root.right.right, memo);
        }
        int sumChild = rob1(root.left, memo) + rob1(root.right, memo);
        int max = Math.max(sumRoot, sumChild);
        memo.put(root, max);
        return max;
    }

    //dp[root] = Max(dp[l]+dp[r], root.val+dp[ll]+dp[lr]+dp[rr]+dp[rl]);
    //dp[0]表示不选根节点的的max，dp[1]表示选了根节点的max
    public int rob2(TreeNode root) {
        int[] dp = rob2Helper(root);
        return Math.max(dp[0], dp[1]);
    }

    public int[] rob2Helper(TreeNode root) {
        int[] dp = new int[2];
        if (root == null) {
            return dp;
        }
        int[] left = rob2Helper(root.left);
        int[] right = rob2Helper(root.right);
        //dp[0]=max{左子树选与不选根节点的最大值+右子树选与不选根节点的最大值}
        //不包含根节点，最大值为两个子树的最大值之和
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //dp[1]=左子树不选根节点的左孩子节点（因为选了根节点root,root.left不能再选了）+
        //右子树不选根节点的右孩子节点（因为选了根节点root,root.right不能再选了）+root.val
        //包含根节点，最大值为两个子树不包含根节点的最大值加上根节点的值
        dp[1] = left[0] + right[0] + root.val;
        return dp;
    }
}
