//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 377 👎 0


//Java：分割等和子集

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Arrays;

public class P416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new P416PartitionEqualSubsetSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition1(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if ((sum & 1) != 0) {
                return false;
            }
            sum >>= 1;
            Arrays.sort(nums);
            int n = nums.length;
            if (nums[n - 1] > sum) {
                return false;
            }
            return backtrack(nums, sum, n - 1);
            // return combine(nums, sum, n - 1);
        }

        public boolean backtrack(int[] nums, int target, int i) {
            if (target < 0 || i < 0) {
                return false;
            } else if (target == 0) {
                return true;
            }
            return backtrack(nums, target - nums[i], i - 1) || backtrack(nums, target, i - 1);
        }

        public boolean combine(int[] nums, int target, int i) {
            if (target < 0) {
                return false;
            } else if (target == 0) {
                return true;
            }
            for (int j = i; j >= 0; j--) {
                if (combine(nums, target - nums[j], j - 1)) {
                    return true;
                }
            }
            return false;
        }

        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if ((sum & 1) != 0) {
                return false;
            }
            sum >>= 1;
            Arrays.sort(nums);
            int n = nums.length;
            if (nums[n - 1] > sum) {
                return false;
            }
            boolean[][] dp = new boolean[n + 1][sum + 1];
            dp[0][0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= sum; j++) {
                    if (j >= nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n][sum];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}