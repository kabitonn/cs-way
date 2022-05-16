//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 732 👎 0


//Java：乘积最大子数组

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P152MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new P152MaximumProductSubarray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int maxProduct = nums[0];
            int max = 1, min = 1;
            for (int n : nums) {
                if (n < 0) {
                    int tmp = max;
                    max = min;
                    min = tmp;
                }
                max = Math.max(max * n, n);
                min = Math.min(min * n, n);
                maxProduct = Math.max(max, maxProduct);
            }
            return maxProduct;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}