//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 617 👎 0


//Java：不同的二叉搜索树 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P95UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new P95UniqueBinarySearchTreesIi().new Solution();
        // TO TEST
    }

    /**
     * Definition for a binary tree node.
     */
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


    class Solution {
        public List<TreeNode> generateTrees1(int n) {
            if (n == 0) {
                return new ArrayList<>();
            }
            return generateTrees(1, n);
        }

        public List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> list = new ArrayList<>();
            if (start > end) {
                list.add(null);
                return list;
            } else if (start == end) {
                list.add(new TreeNode(start));
                return list;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftTrees = generateTrees(start, i - 1);
                List<TreeNode> rightTrees = generateTrees(i + 1, end);
                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        list.add(root);
                    }
                }
            }
            return list;
        }

        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new ArrayList<>();
            }
            List<TreeNode> prev = new ArrayList<>();
            prev.add(null);
            for (int i = 1; i <= n; i++) {
                List<TreeNode> cur = new ArrayList<>();
                for (TreeNode p : prev) {
                    TreeNode node = new TreeNode(i);
                    node.left = clone(p);
                    cur.add(node);
                    for (int j = 1; j < i; j++) {
                        TreeNode pRoot = clone(p);
                        TreeNode right = pRoot;
                        int k = 1;
                        while (right != null && k++ < j) {
                            right = right.right;
                        }
                        if (right == null) {
                            break;
                        }
                        node = new TreeNode(i);
                        node.left = right.right;
                        right.right = node;
                        cur.add(pRoot);
                    }
                }
                prev = cur;
            }
            return prev;
        }

        private TreeNode clone(TreeNode t) {
            if (t == null) {
                return null;
            }
            TreeNode root = new TreeNode(t.val);
            root.left = clone(t.left);
            root.right = clone(t.right);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}