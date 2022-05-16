//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 574 👎 0


//Java：在排序数组中查找元素的第一个和最后一个位置

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {

            int left = minIndex(nums, target);
            int right = maxIndex(nums, target);
            return new int[]{left, right};
        }

        public int minIndex(int[] nums, int target) {

            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left < nums.length && nums[left] == target) {
                return left;
            }
            return -1;
        }

        public int maxIndex(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right + 1) >>> 1;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            if (left < nums.length && nums[left] == target) {
                return left;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}