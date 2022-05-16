//给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。 
//
// 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。 
//
// 示例 1: 
//
// 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
// Related Topics 堆 
// 👍 105 👎 0


//Java：查找和最小的K对数字

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.*;

public class P373FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        Solution solution = new P373FindKPairsWithSmallestSums().new Solution();
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};

        System.out.println(solution.kSmallestPairs(nums1, nums2, 2));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
            PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(k + 1, (o1, o2) -> sumValue(o2) - sumValue(o1));
            int m = Math.min(nums1.length, k);
            int n = Math.min(nums2.length, k);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    List<Integer> list = Arrays.asList(nums1[i], nums2[j]);
                    maxHeap.add(list);
                    if (maxHeap.size() > k) {
                        maxHeap.poll();
                    }
                }
            }
            return new ArrayList<>(maxHeap);
        }

        int sumValue(List<Integer> arr) {
            int sum = 0;
            for (int n : arr) {
                sum += n;
            }
            return sum;
            //return arr.stream().reduce(Integer::sum).orElse(0);
        }

        public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
            int m = Math.min(nums1.length, k);
            int n = Math.min(nums2.length, k);
            if (m * n == 0) {
                return new ArrayList<>();
            }
            PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(m * n, Comparator.comparingInt(this::sumValue));
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    minHeap.add(Arrays.asList(nums1[i], nums2[j]));
                }
            }
            List<List<Integer>> listList = new ArrayList<>();
            k = Math.min(k, minHeap.size());
            for (int i = 0; i < k; i++) {
                listList.add(minHeap.poll());
            }
            return listList;
        }

        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            int m = Math.min(nums1.length, k);
            int n = Math.min(nums2.length, k);
            if (m * n == 0) {
                return new ArrayList<>();
            }
            PriorityQueue<int[]> minIndexHeap = new PriorityQueue<>(m * n, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]);
                }
            });
            for (int i = 0; i < m; i++) {
                minIndexHeap.add(new int[]{i, 0});
            }

            List<List<Integer>> listList = new ArrayList<>();
            k = Math.min(k, m * n);
            for (int i = 0; i < k; i++) {
                int[] index = minIndexHeap.poll();
                listList.add(Arrays.asList(nums1[index[0]], nums2[index[1]]));
                index[1]++;
                if (index[1] < n) {
                    minIndexHeap.add(index);
                }
            }
            return listList;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}