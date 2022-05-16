//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 314 👎 0


//Java：二叉树的所有路径

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new P257BinaryTreePaths().new Solution();
        // TO TEST
    }

    /**
     * Definition for a binary tree node
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> list = new ArrayList<>();
            binaryTreePath(list, root, "");
            return list;
        }

        public void binaryTreePath(List<String> list, TreeNode p, String path) {
            if (p == null) {
                return;
            }
            path += p.val;
            if (p.left == null && p.right == null) {
                list.add(path);
            } else {
                binaryTreePath(list, p.left, path + "->");
                binaryTreePath(list, p.right, path + "->");
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}