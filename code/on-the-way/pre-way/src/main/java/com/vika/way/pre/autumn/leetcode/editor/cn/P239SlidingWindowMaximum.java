//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
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
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 536 👎 0


//Java：滑动窗口最大值

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class P239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 滑动窗口最大值pop出窗口时重新计算
         *
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow1(int[] nums, int k) {
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

        /**
         * 最大堆维护窗口内值 超时
         *
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow2(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[]{};
            }
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
            int n = nums.length;
            int[] slide = new int[n - k + 1];
            for (int r = 0; r < n; r++) {
                maxHeap.offer(nums[r]);
                if (maxHeap.size() == k) {
                    slide[r - k + 1] = maxHeap.peek();
                    maxHeap.remove(nums[r - k + 1]);
                }
            }
            return slide;
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[]{};
            }
            int n = nums.length;
            int[] slide = new int[n - k + 1];
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < k - 1; i++) {
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }
                queue.offer(i);
            }
            for (int l = 0, r = k - 1; r < n; l++, r++) {
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[r]) {
                    queue.pollLast();
                }
                queue.offer(r);
                slide[l] = nums[queue.peek()];
                if (r - queue.peek() >= k - 1) {
                    queue.poll();
                }
            }
            return slide;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = {1, 3, 1, 2, 0, 5};
        int[] slide = solution.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(slide));
    }
}