//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 224 👎 0


//Java：两个数组的交集

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class P349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            for (int n : nums1) {
                set.add(n);
            }
            Set<Integer> intersection = new HashSet<>();
            for (int n : nums2) {
                if (set.contains(n)) {
                    intersection.add(n);
                }
            }
            int[] result = intersection.stream().mapToInt(Integer::intValue).toArray();
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}