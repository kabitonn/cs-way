//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
//问题。 
//
// 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 68 👎 0


//Java：数值的整数次方

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P剑指16数值的整数次方 {
    public static void main(String[] args) {
        Solution solution = new P剑指16数值的整数次方().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow1(double x, int N) {
            long n = N;
            if (n < 0) {
                x = 1 / x;
                n = -n;
            }
            double p = 1;
            for (; n != 0; n >>= 1) {
                if ((n & 1) == 1) {
                    p *= x;
                }
                x *= x;
            }
            return p;
        }

        public double myPow2(double x, int n) {
            return pow(x, n);
        }

        public double pow(double x, int n) {
            if (n == 0) {
                return 1;
            } else if (n == 1) {
                return x;
            } else if (n == -1) {
                return 1 / x;
            }
            double p = pow(x, n / 2);
            double r = pow(x, n % 2);
            return p * p * r;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}