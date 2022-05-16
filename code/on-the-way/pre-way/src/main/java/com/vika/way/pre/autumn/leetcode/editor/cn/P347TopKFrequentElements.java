//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 410 👎 0


//Java：前 K 个高频元素

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.*;

public class P347TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new P347TopKFrequentElements().new Solution();
        int[] nums = {1, 2};
        System.out.println(Arrays.toString(solution.topKFrequent(nums, 2)));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent1(int[] nums, int k) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int n : nums) {
                countMap.put(n, countMap.getOrDefault(n, 0) + 1);
            }
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1,
                    Comparator.comparingInt(countMap::get));
            for (int key : countMap.keySet()) {
                minHeap.add(key);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
            return minHeap.stream().mapToInt(Integer::valueOf).toArray();
        }

        public int[] topKFrequent2(int[] nums, int k) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int n : nums) {
                countMap.put(n, countMap.getOrDefault(n, 0) + 1);
            }
            List<Integer> frequence = new ArrayList<>(countMap.values());
            frequence.sort((o1, o2) -> o2 - o1);
            int limit = frequence.get(k - 1);
            int[] top = new int[k];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() >= limit) {
                    top[i++] = entry.getKey();
                }
            }
            return top;
        }

        public int[] topKFrequent3(int[] nums, int k) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int n : nums) {
                countMap.put(n, countMap.getOrDefault(n, 0) + 1);
            }
            int n = nums.length;
            List<Integer>[] countBucket = new List[n + 1];
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if (countBucket[value] == null) {
                    countBucket[value] = new ArrayList<>();
                }
                countBucket[value].add(key);
            }
            int[] top = new int[k];
            for (int i = n, j = 0; i > 0 && j < k; i--) {
                if (countBucket[i] != null) {
                    for (int key : countBucket[i]) {
                        top[j++] = key;
                    }
                }
            }
            return top;
        }

        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int n : nums) {
                countMap.put(n, countMap.getOrDefault(n, 0) + 1);
            }
            TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) ->
                    countMap.get(o2) - countMap.get(o1) > 0 ? 1 : -1);
            treeMap.putAll(countMap);
            int[] top = new int[k];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                top[i++] = entry.getKey();
                if (i == k) {
                    break;
                }
            }
            return top;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}