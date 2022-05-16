//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 
// 👍 162 👎 0


//Java：数组中重复的数字

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P剑指03数组中重复数字 {
    public static void main(String[] args) {
        Solution solution = new P剑指03数组中重复数字().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatNumber1(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    return nums[i];
                }
            }
            return -1;
        }

        public int findRepeatNumber2(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int n : nums) {
                if (set.contains(n)) {
                    return n;
                }
                set.add(n);
            }
            return -1;
        }

        public int findRepeatNumber(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                while (nums[i] != nums[nums[i]]) {
                    swap(nums, i, nums[i]);
                }
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] != i) {
                    return nums[i];
                }
            }
            return -1;
        }

        public void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}