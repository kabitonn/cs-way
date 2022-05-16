//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 295 👎 0


//Java：子集 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new P90SubsetsIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> listList = new ArrayList<>();
            subset(listList, new ArrayList<>(), nums, 0);
            return listList;
        }

        public void subset(List<List<Integer>> listList, List<Integer> list, int[] nums, int index) {
            listList.add(new ArrayList<>(list));

            for (int i = index; i < nums.length; i++) {
                if (i > index && nums[i] == nums[i - 1]) {
                    continue;
                }
                list.add(nums[i]);
                subset(listList, list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}