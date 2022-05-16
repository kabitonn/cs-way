//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
//
// 
//
// 
// 
//
// 示例 1: 
//
// 输入: amount = 5, coins = [1, 2, 5]
//输出: 4
//解释: 有四种方式可以凑成总金额:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2: 
//
// 输入: amount = 3, coins = [2]
//输出: 0
//解释: 只用面额2的硬币不能凑成总金额3。
// 
//
// 示例 3: 
//
// 输入: amount = 10, coins = [10] 
//输出: 1
// 
//
// 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= amount (总金额) <= 5000 
// 1 <= coin (硬币面额) <= 5000 
// 硬币种类不超过 500 种 
// 结果符合 32 位符号整数 
// 
// 👍 230 👎 0


//Java：零钱兑换 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

public class P518CoinChange2 {
    public static void main(String[] args) {
        Solution solution = new P518CoinChange2().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int change1(int amount, int[] coins) {
            Arrays.sort(coins);
            return countChange(amount, coins, 0, new Integer[coins.length + 1][amount + 1]);
        }

        public int countChange(int amount, int[] coins, int index, Integer[][] memo) {
            if (amount == 0) {
                return 1;
            } else if (amount < 0) {
                return 0;
            }
            if (memo[index][amount] != null) {
                return memo[index][amount];
            }
            int sum = 0;
            for (int i = index; i < coins.length && amount >= coins[i]; i++) {
                sum += countChange(amount - coins[i], coins, i, memo);
            }
            memo[index][amount] = sum;
            return sum;
        }

        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= amount; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= coins[i - 1]) {
                        dp[i][j] += dp[i][j - coins[i - 1]];
                    }
                }
            }
            return dp[n][amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}