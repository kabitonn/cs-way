//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树 
// 👍 551 👎 0


//Java：路径总和 III

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class P437PathSumIii {
    public static void main(String[] args) {
        Solution solution = new P437PathSumIii().new Solution();
        // TO TEST
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /*
     * Definition for a binary tree node.
     */

    class Solution {
        public int pathSum1(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            return getPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        public int getPathSum(TreeNode p, int target) {
            if (p == null) {
                return 0;
            }
            target -= p.val;
            return (target == 0 ? 1 : 0) + getPathSum(p.left, target) + getPathSum(p.right, target);
        }

        public int pathSum(TreeNode root, int sum) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            return getPathSum(map, root, sum, 0);
        }

        public int getPathSum(Map<Integer, Integer> map, TreeNode p, int target, int sum) {
            if (p == null) {
                return 0;
            }
            sum += p.val;
            int paths = map.getOrDefault((sum - target), 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            paths += getPathSum(map, p.left, target, sum) + getPathSum(map, p.right, target, sum);
            map.put(sum, map.get(sum) - 1);
            return paths;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}