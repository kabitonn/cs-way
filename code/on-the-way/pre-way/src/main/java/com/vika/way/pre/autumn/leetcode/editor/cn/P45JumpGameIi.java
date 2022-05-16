//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 641 👎 0


//Java：跳跃游戏 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P45JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new P45JumpGameIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump1(int[] nums) {
            int n = nums.length;
            int step = 0;
            int start = 0;
            int next = 1;
            while (next < n) {
                int max = 0;
                for (int i = start; i < next; i++) {
                    max = Math.max(max, i + nums[i]);
                }
                start = next;
                next = max + 1;
                step++;
            }
            return step;
        }

        public int jump2(int[] nums) {
            int n = nums.length;
            int max = 0;
            int end = 0;
            int step = 0;
            for (int i = 0; i < n - 1; i++) {
                max = Math.max(max, i + nums[i]);
                if (i == end) {
                    step++;
                    end = max;
                }
            }
            return step;
        }

        public int jump(int[] nums) {
            int n = nums.length;
            int step = 0;
            int last = n - 1;
            while (last > 0) {
                for (int i = 0; i < last; i++) {
                    if (i + nums[i] >= last) {
                        last = i;
                        step++;
                    }
                }
            }
            return step;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}