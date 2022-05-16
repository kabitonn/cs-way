//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 109 👎 0


//Java：滑动窗口的最大值

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P剑指59滑动窗口的最大值 {
    public static void main(String[] args) {
        Solution solution = new P剑指59滑动窗口的最大值().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[]{};
            }
            int n = nums.length;
            int[] slide = new int[n - k + 1];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < k - 1; i++) {
                max = Math.max(max, nums[i]);
            }
            for (int left = 0, right = k - 1; right < n; left++, right++) {
                max = Math.max(max, nums[right]);
                slide[left] = max;
                if (nums[left] == max) {
                    max = Integer.MIN_VALUE;
                    for (int i = left + 1; i <= right; i++) {
                        max = Math.max(max, nums[i]);
                    }
                }
            }
            return slide;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}