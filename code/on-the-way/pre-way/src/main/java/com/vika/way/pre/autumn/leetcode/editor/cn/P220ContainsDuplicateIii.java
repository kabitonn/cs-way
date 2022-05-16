//在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的
//绝对值也小于等于 ķ 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3, t = 0
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1, t = 2
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
//输出: false 
// Related Topics 排序 Ordered Map 
// 👍 213 👎 0


//Java：存在重复元素 III

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P220ContainsDuplicateIii {
    public static void main(String[] args) {
        Solution solution = new P220ContainsDuplicateIii().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

            int n = nums.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j <= i + k && j < n; j++) {
                    long diff = Math.abs((long) nums[i] - (long) nums[j]);
                    if (diff <= t) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}