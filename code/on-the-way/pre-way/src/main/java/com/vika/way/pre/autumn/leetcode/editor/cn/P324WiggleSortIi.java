//给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。 
//
// 示例 1: 
//
// 输入: nums = [1, 5, 1, 1, 6, 4]
//输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6] 
//
// 示例 2: 
//
// 输入: nums = [1, 3, 2, 2, 3, 1]
//输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2] 
//
// 说明: 
//你可以假设所有输入都会得到有效的结果。 
//
// 进阶: 
//你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？ 
// Related Topics 排序 
// 👍 173 👎 0


//Java：摆动排序 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Arrays;

public class P324WiggleSortIi {
    public static void main(String[] args) {
        Solution solution = new P324WiggleSortIi().new Solution();
        int[] nums = {1, 1, 1, 1, 2, 2, 2};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wiggleSort1(int[] nums) {
            int n = nums.length;
            int[] copy = Arrays.copyOf(nums, n);
            Arrays.sort(copy);
            int high = n - 1;
            int mid = (n - 1) >> 1;
            for (int i = 0; i < n; ) {
                nums[i++] = copy[mid--];
                if (i < n) {
                    nums[i++] = copy[high--];
                }
            }
        }

        public void wiggleSort(int[] nums) {
            int n = nums.length;
            int[] copy = Arrays.copyOf(nums, n);
            Arrays.sort(copy);
            int high = n - 1;
            int mid = (n - 1) >> 1;
            for (int i = 0; i < n; i++) {
                nums[i] = (i & 1) == 0 ? copy[mid--] : copy[high--];
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}