//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 ×4 = 36
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 105 👎 0


//Java：剪绳子

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P剑指14剪绳子 {
    public static void main(String[] args) {
        Solution solution = new P剑指14剪绳子().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cuttingRope1(int n) {
            if (n <= 3) {
                return n - 1;
            }
            int q = n / 3;
            int r = n % 3;
            if (r == 0) {
                return (int) Math.pow(3, q);
            } else if (r == 1) {
                return (int) Math.pow(3, q - 1) * 4;
            } else {
                return (int) Math.pow(3, q) * r;
            }
        }

        public int cuttingRope(int n) {
            if (n <= 2) {
                return 1;
            }
            int[] dp = new int[n + 1];
            dp[1] = dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[i - j] * j));
                }
            }
            return dp[n];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(58));
    }
}