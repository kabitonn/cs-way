//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 730 👎 0


//Java：子集

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P78Subsets {
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets1(int[] nums) {
            List<List<Integer>> listList = new ArrayList<>();
            combine(listList, new ArrayList<>(), nums, 0);
            return listList;
        }

        public void combine(List<List<Integer>> listList, List<Integer> list, int[] nums, int index) {
            listList.add(new ArrayList<>(list));
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                combine(listList, list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }

        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            int total = 1 << n;
            List<List<Integer>> listList = new ArrayList<>();
            for (int i = 0; i < total; i++) {
                int bit = i;
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if ((bit & 1) == 1) {
                        list.add(nums[j]);
                    }
                    bit >>= 1;
                }
                listList.add(list);
            }
            return listList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}