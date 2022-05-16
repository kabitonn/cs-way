//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法 
// 👍 385 👎 0


//Java：全排列 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class P47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique1(int[] nums) {
            Set<List<Integer>> listSet = new HashSet<>();
            permute(listSet, nums, 0);
            return new ArrayList<>(listSet);
        }

        public void permute(Set<List<Integer>> listSet, int[] nums, int start) {
            if (start == nums.length) {
                listSet.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permute(listSet, nums, start + 1);
                swap(nums, start, i);
            }

        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public List<List<Integer>> permuteUnique2(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> listList = new ArrayList<>();
            permute(listList, new ArrayList<>(), nums, new boolean[nums.length]);
            return listList;
        }

        public void permute(List<List<Integer>> listList, List<Integer> list, int[] nums, boolean[] visited) {
            if (list.size() == nums.length) {
                listList.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                visited[i] = true;
                list.add(nums[i]);
                permute(listList, list, nums, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> listList = new ArrayList<>();
            permute(listList, nums, 0);
            return listList;
        }

        public void permute(List<List<Integer>> listList, int[] nums, int start) {
            if (start == nums.length) {
                listList.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                int j = i - 1;
                while (j >= start && nums[j] != nums[i]) {
                    j--;
                }
                if (j != start - 1) {
                    continue;
                }
                swap(nums, start, i);
                permute(listList, nums, start + 1);
                swap(nums, start, i);
            }

            /*
            Set<Integer> set = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    continue;
                }
                set.add(nums[i]);
                swap(nums, start, i);
                permute(listList, nums, start + 1);
                swap(nums, start, i);
            }*/
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}