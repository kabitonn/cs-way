//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组 
// 👍 754 👎 0


//Java：跳跃游戏

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P55JumpGame {
    public static void main(String[] args) {
        Solution solution = new P55JumpGame().new Solution();
        int[] nums = {0};
        System.out.println(solution.canJump(nums));

        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canJump(int[] nums) {
            int n = nums.length;
            int max = 0;
            int cur = 0;
            while (max >= cur && max < n) {
                int curMax = max;
                for (; cur <= curMax; cur++) {
                    max = Math.max(cur + nums[cur], max);
                }
                if (max == curMax) {
                    break;
                }
            }
            return max >= n - 1;
        }

        public boolean canJump2(int[] nums) {
            if (nums == null || nums.length == 0) {
                return true;
            }
            int n = nums.length;
            int[] step = new int[n];
            step[0] = nums[0];
            for (int i = 1; i < n; i++) {
                if (step[i - 1] >= i) {
                    step[i] = Math.max(step[i - 1], i + nums[i]);
                }
            }
            return step[n - 1] >= n - 1;
        }

        public boolean canJump3(int[] nums) {
            int n = nums.length;
            int step = 0;
            for (int i = 0; i < n; i++) {
                if (step < i) {
                    return false;
                }
                step = Math.max(step, i + nums[i]);
            }
            return true;
        }

        public boolean canJump4(int[] nums) {
            int n = nums.length;
            int last = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (i + nums[i] >= last) {
                    last = i;
                }
            }
            return last == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}