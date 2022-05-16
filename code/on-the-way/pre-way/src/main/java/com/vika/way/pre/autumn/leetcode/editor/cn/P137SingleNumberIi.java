//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,3,2]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [0,1,0,1,0,1,99]
//输出: 99 
// Related Topics 位运算 
// 👍 409 👎 0


//Java：只出现一次的数字 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P137SingleNumberIi {
    public static void main(String[] args) {
        Solution solution = new P137SingleNumberIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int x1 = 0, x2 = 0;
            int mask;
            for (int n : nums) {
                x2 ^= x1 & n;
                x1 ^= n;
                mask = ~(x1 & x2);
                x2 &= mask;
                x1 &= mask;
            }
            return x1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}