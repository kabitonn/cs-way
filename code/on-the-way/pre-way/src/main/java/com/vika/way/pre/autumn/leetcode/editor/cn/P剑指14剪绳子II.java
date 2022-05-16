//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]
// 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘
//积是18。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
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
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 1000 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 37 👎 0


//Java：剪绳子 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P剑指14剪绳子II {
    public static void main(String[] args) {
        Solution solution = new P剑指14剪绳子II().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mod = 1000000007;

        public int cuttingRope(int n) {
            if (n <= 3) {
                return n - 1;
            }
            int q = n / 3;
            int r = n % 3;
            long p = 1, x = 3;

            for (int b = q - 1; b > 0; b >>= 1) {
                if ((b & 1) == 1) {
                    p = (p * x) % mod;
                }
                x = (x * x) % mod;
            }
            if (r == 0) {
                return (int) (p * 3 % mod);
            } else if (r == 1) {
                return (int) (p * 4 % mod);
            } else {
                return (int) (p * 3 % mod * r % mod);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(127));
    }
}