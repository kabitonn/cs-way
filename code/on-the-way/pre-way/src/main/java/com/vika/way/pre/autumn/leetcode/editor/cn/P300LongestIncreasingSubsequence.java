//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划 
// 👍 941 👎 0


//Java：最长上升子序列

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new P300LongestIncreasingSubsequence().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS1(int[] nums) {

            int n = nums.length;
            int[] dp = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }

        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] tail = new int[n];
            int len = 0;
            for (int i = 0; i < n; i++) {
                int left = 0;
                int right = len;
                while (left < right) {
                    int mid = (left + right) >>> 1;
                    if (tail[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = nums[i];
                if (left == len) {
                    len++;
                }
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}