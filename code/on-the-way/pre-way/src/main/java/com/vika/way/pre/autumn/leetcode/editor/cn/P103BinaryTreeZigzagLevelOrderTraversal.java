//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 227 👎 0


//Java：二叉树的锯齿形层次遍历

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.*;

public class P103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (null == root) {
                return new ArrayList<>();
            }
            List<List<Integer>> listList = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int level = 0;
            while (!queue.isEmpty()) {
                level++;
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode p = queue.poll();
                    list.add(p.val);
                    if (null != p.left) {
                        queue.offer(p.left);
                    }
                    if (null != p.right) {
                        queue.offer(p.right);
                    }
                }
                if ((level & 1) == 0) {
                    Collections.reverse(list);
                }
                listList.add(list);
            }
            return listList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}