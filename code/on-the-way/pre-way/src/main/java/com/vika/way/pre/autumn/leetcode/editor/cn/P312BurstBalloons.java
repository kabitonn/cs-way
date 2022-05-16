//有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 lef
//t 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 说明: 
//
// 
// 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。 
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 
// 
//
// 示例: 
//
// 输入: [3,1,5,8]
//输出: 167 
//解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
// 
// Related Topics 分治算法 动态规划 
// 👍 508 👎 0


//Java：戳气球

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P312BurstBalloons {
    public static void main(String[] args) {
        Solution solution = new P312BurstBalloons().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCoins(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            int[] val = new int[n + 2];
            val[0] = 1;
            val[n + 1] = 1;
            for (int i = 0; i < n; i++) {
                val[i + 1] = nums[i];
            }
            return backtrack(val, new Integer[n + 2][n + 2], 0, n + 1);
        }

        public int backtrack(int[] val, Integer[][] memo, int left, int right) {
            if (left >= right - 1) {
                return 0;
            }
            if (memo[left][right] != null) {
                return memo[left][right];
            }
            int max = 0;
            for (int mid = left + 1; mid < right; mid++) {
                int leftSum = backtrack(val, memo, left, mid);
                int rightSum = backtrack(val, memo, mid, right);
                int sum = leftSum + rightSum + val[left] * val[right] * val[mid];
                max = Math.max(max, sum);
            }
            memo[left][right] = max;
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}