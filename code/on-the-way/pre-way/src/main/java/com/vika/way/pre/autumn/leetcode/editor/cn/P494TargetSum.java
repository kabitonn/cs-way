//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 
//
// 示例： 
//
// 输入：nums: [1, 1, 1, 1, 1], S: 3
//输出：5
//解释：
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 
//
// 提示： 
//
// 
// 数组非空，且长度不会超过 20 。 
// 初始的数组的和不会超过 1000 。 
// 保证返回的最终结果能被 32 位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 376 👎 0


//Java：目标和

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P494TargetSum {
    public static void main(String[] args) {
        Solution solution = new P494TargetSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays1(int[] nums, int S) {
            return dfs(nums, S, 0, 0);
        }

        public int dfs(int[] nums, int target, int sum, int i) {
            if (i == nums.length) {
                return sum == target ? 1 : 0;
            }
            int path = 0;
            path += dfs(nums, target, sum + nums[i], i + 1);
            path += dfs(nums, target, sum - nums[i], i + 1);
            return path;
        }

        public int findTargetSumWays2(int[] nums, int S) {
            Map<Integer, Integer>[] memo = new Map[nums.length];
            for (int i = 0; i < nums.length; i++) {
                memo[i] = new HashMap<>();
            }
            return dfs(nums, S, 0, memo);
        }

        public int dfs(int[] nums, int target, int i, Map<Integer, Integer>[] memo) {
            if (i == nums.length) {
                return target == 0 ? 1 : 0;
            }
            if (memo[i].containsKey(target)) {
                return memo[i].get(target);
            }
            int path = 0;
            path += dfs(nums, target - nums[i], i + 1, memo);
            path += dfs(nums, target + nums[i], i + 1, memo);
            memo[i].put(target, path);
            return path;
        }

        public int findTargetSumWays(int[] nums, int S) {
            int base = Arrays.stream(nums).sum();
            if (S > base) {
                return 0;
            }
            int n = nums.length;
            int[][] dp = new int[n + 1][base * 2 + 1];
            dp[0][base] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = -base; j <= base; j++) {
                    if (j + base - nums[i - 1] >= 0) {
                        dp[i][j + base] += dp[i - 1][j + base - nums[i - 1]];
                    }
                    if (j + base + nums[i - 1] <= base * 2) {
                        dp[i][j + base] += dp[i - 1][j + base + nums[i - 1]];
                    }
                }
            }
            return dp[n][S + base];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}