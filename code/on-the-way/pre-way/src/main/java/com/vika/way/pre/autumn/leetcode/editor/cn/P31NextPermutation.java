//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 640 👎 0


//Java：下一个排列

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P31NextPermutation {
    public static void main(String[] args) {
        Solution solution = new P31NextPermutation().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int j = n - 1;
            while (j > 0 && nums[j - 1] >= nums[j]) {
                j--;
            }
            if (j == 0) {
                reverse(nums, 0, n - 1);
                return;
            }
            int left = j - 1;
            while (j < n && nums[j] > nums[left]) {
                j++;
            }
            int right = j - 1;
            swap(nums, left, right);
            reverse(nums, left + 1, n - 1);

        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        public void reverse(int[] nums, int i, int j) {
            for (; i < j; i++, j--) {
                swap(nums, i, j);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}