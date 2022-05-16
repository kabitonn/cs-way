//给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。 
//
// 示例 1: 
//
// 输入: [5,7]
//输出: 4 
//
// 示例 2: 
//
// 输入: [0,1]
//输出: 0 
// Related Topics 位运算 
// 👍 217 👎 0


//Java：数字范围按位与

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P201BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
        Solution solution = new P201BitwiseAndOfNumbersRange().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rangeBitwiseAnd1(int m, int n) {
            int result = 0;
            for (int i = 31; i >= 0; i--) {
                int mask = 1 << i;
                if ((mask & n) == (mask & m)) {
                    result |= (mask & n);
                } else {
                    break;
                }
            }
            return result;
        }

        public int rangeBitwiseAnd2(int m, int n) {
            while (n > m) {
                n = n & (n - 1);
            }
            return n;
        }

        public int rangeBitwiseAnd(int m, int n) {
            int count = 0;
            while (n != m) {
                n >>= 1;
                m >>= 1;
                count++;
            }
            return n <<= count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}