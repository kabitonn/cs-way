//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。 
//
// 示例 : 
//
// 输入: [1,2,1,3,2,5]
//输出: [3,5] 
//
// 注意： 
//
// 
// 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。 
// 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？ 
// 
// Related Topics 位运算 
// 👍 278 👎 0


//Java：只出现一次的数字 III

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P260SingleNumberIii {
    public static void main(String[] args) {
        Solution solution = new P260SingleNumberIii().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumber(int[] nums) {
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }
            int mask = xor;
            mask &= (~mask + 1);
            int n1 = 0, n2 = 0;
            for (int num : nums) {
                if ((num & mask) == 0) {
                    n1 ^= num;
                } else {
                    n2 ^= num;
                }
            }
            return new int[]{n1, n2};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}