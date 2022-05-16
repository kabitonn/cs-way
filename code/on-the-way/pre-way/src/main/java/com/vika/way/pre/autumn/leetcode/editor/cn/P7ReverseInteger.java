//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2161 👎 0


//Java：整数反转

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P7ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {

            int reverse = 0;
            while (x != 0) {
                if (reverse > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                if (reverse < Integer.MIN_VALUE / 10) {
                    return 0;
                }
                reverse = reverse * 10 + x % 10;
                x /= 10;
            }

            return reverse;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-2147483648));
    }
}