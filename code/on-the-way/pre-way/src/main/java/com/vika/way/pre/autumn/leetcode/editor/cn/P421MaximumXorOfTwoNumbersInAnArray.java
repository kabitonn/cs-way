//给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。 
//
// 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i, j < n 。 
//
// 你能在O(n)的时间解决这个问题吗？ 
//
// 示例: 
//
// 
//输入: [3, 10, 5, 25, 2, 8]
//
//输出: 28
//
//解释: 最大的结果是 5 ^ 25 = 28.
// 
// Related Topics 位运算 字典树 
// 👍 159 👎 0


//Java：数组中两个数的最大异或值

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P421MaximumXorOfTwoNumbersInAnArray {
    public static void main(String[] args) {
        Solution solution = new P421MaximumXorOfTwoNumbersInAnArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaximumXOR(int[] nums) {
            TrieNode root = buildTrieTree(nums);
            int max = 0;
            for (int num : nums) {
                max = Math.max(max, findMaxXor(num, root));
            }
            return max;
        }

        public int findMaxXor(int num, TrieNode root) {
            TrieNode p = root;
            for (int i = 30; i >= 0; i--) {
                int path = (num >> i) & 1;
                if (p.children[1 ^ path] != null) {
                    path ^= 1;
                }
                p = p.children[path];
            }
            return num ^ p.val;
        }

        public TrieNode buildTrieTree(int[] nums) {
            TrieNode root = new TrieNode();
            for (int num : nums) {
                TrieNode p = root;
                for (int i = 30; i >= 0; i--) {
                    int v = (num >> i) & 1;
                    if (p.children[v] == null) {
                        p.children[v] = new TrieNode();
                    }
                    p = p.children[v];
                }
                p.val = num;
            }
            return root;
        }

    }


    class TrieNode {
        int val;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}