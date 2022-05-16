//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划 
// 👍 795 👎 0


//Java：零钱兑换

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

public class P322CoinChange {
    public static void main(String[] args) {
        Solution solution = new P322CoinChange().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int min = Integer.MAX_VALUE;

        public int coinChange1(int[] coins, int amount) {
            Arrays.sort(coins);
            coinChange(coins, 0, coins.length - 1, amount);
            return min == Integer.MAX_VALUE ? -1 : min;
        }

        public void coinChange(int[] coins, int count, int index, int amount) {
            if (amount == 0) {
                min = Math.min(min, count);
                return;
            } else if (amount < 0 || index < 0) {
                return;
            }
            for (int k = amount / coins[index]; k >= 0 && k + count < min; k--) {
                coinChange(coins, count + k, index - 1, amount - coins[index] * k);
            }
        }

        public int coinChange2(int[] coins, int amount) {
            Arrays.sort(coins);
            Integer[][] memo = new Integer[coins.length][amount + 1];
            int count = coinChange(coins, amount, coins.length - 1, memo);
            return count == Integer.MAX_VALUE ? -1 : count;
        }

        public int coinChange(int[] coins, int amount, int index, Integer[][] memo) {
            if (amount == 0) {
                return 0;
            } else if (amount < 0 || index < 0) {
                return Integer.MAX_VALUE;
            }
            if (memo[index][amount] != null) {
                return memo[index][amount];
            }
            int min = Integer.MAX_VALUE;
            for (int k = amount / coins[index]; k >= 0; k--) {
                int count = coinChange(coins, amount - k * coins[index], index - 1, memo);
                if (count != Integer.MAX_VALUE) {
                    min = Math.min(min, k + count);
                }
            }
            memo[index][amount] = min;
            return min;
        }

        public int coinChange3(int[] coins, int amount) {
            int count = minCoins(coins, amount, new Integer[amount + 1]);
            return count == Integer.MAX_VALUE ? -1 : count;
        }

        public int minCoins(int[] coins, int amount, Integer[] memo) {
            if (amount == 0) {
                return 0;
            } else if (amount < 0) {
                return Integer.MAX_VALUE;
            }
            if (memo[amount] != null) {
                return memo[amount];
            }
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int count = minCoins(coins, amount - coin, memo);
                if (count != Integer.MAX_VALUE) {
                    min = Math.min(min, count + 1);
                }
            }
            memo[amount] = min;
            return min;
        }

        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            int[] dp = new int[amount + 1];
            for (int total = 1; total <= amount; total++) {
                dp[total] = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (total >= coin && dp[total - coin] != Integer.MAX_VALUE) {
                        dp[total] = Math.min(dp[total], 1 + dp[total - coin]);
                    }
                }
            }
            int count = dp[amount];
            return count == Integer.MAX_VALUE ? -1 : count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();
        int[] coins = {1};
        System.out.println(solution.coinChange(coins, 0));
    }
}