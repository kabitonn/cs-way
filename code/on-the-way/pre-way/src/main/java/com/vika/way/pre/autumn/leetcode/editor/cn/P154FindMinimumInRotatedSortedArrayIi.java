//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 注意数组中可能存在重复的元素。 
//
// 示例 1： 
//
// 输入: [1,3,5]
//输出: 1 
//
// 示例 2： 
//
// 输入: [2,2,2,0,1]
//输出: 0 
//
// 说明： 
//
// 
// 这道题是 寻找旋转排序数组中的最小值 的延伸题目。 
// 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 171 👎 0


//Java：寻找旋转排序数组中的最小值 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P154FindMinimumInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new P154FindMinimumInRotatedSortedArrayIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) {
                    right = mid;
                } else {
                    right--;
                }
            }
            return nums[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}