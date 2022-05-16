//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 862 👎 0


//Java：全排列

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute1(int[] nums) {
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
                visited[i] = true;
                list.add(nums[i]);
                permute(listList, list, nums, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }

        public List<List<Integer>> permute2(int[] nums) {
            List<List<Integer>> listList = new ArrayList<>();
            permute(listList, nums, 0);
            return listList;
        }

        public void permute(List<List<Integer>> listList, int[] nums, int start) {
            if (start == nums.length) {
                listList.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            }
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permute(listList, nums, start + 1);
                swap(nums, start, i);
            }
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public List<List<Integer>> permute3(int[] nums) {
            if (nums.length == 0) {
                return new ArrayList<>();
            }
            return permute(nums, nums.length);
        }

        public List<List<Integer>> permute(int[] nums, int len) {
            if (len == 1) {
                List<List<Integer>> listList = new ArrayList<>();
                listList.add(Arrays.asList(nums[0]));
                return listList;
            }
            List<List<Integer>> listList = new ArrayList<>();
            for (List<Integer> list : permute(nums, len - 1)) {
                for (int i = 0; i <= list.size(); i++) {
                    List<Integer> p = new ArrayList<>(list);
                    p.add(i, nums[len - 1]);
                    listList.add(p);
                }
            }
            return listList;
        }

        public List<List<Integer>> permute(int[] nums) {
            Queue<List<Integer>> listQueue = new LinkedList<>();
            listQueue.offer(new ArrayList<>());
            for (int num : nums) {
                int size = listQueue.size();
                for (int i = 0; i < size; i++) {
                    List<Integer> list = listQueue.poll();
                    for (int j = 0; j <= list.size(); j++) {
                        List<Integer> p = new ArrayList<>(list);
                        p.add(j, num);
                        listQueue.offer(p);
                    }
                }
            }
            return new ArrayList<>(listQueue);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}