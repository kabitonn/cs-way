//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。 
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 
//
// 示例 2： 
//
// 输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 
//
// 示例 3： 
//
// 输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的数组长度范围为 [1, 10000] 
// 
//
// 
// Related Topics 堆 贪心算法 
// 👍 99 👎 0


//Java：分割数组为连续子序列

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P659SplitArrayIntoConsecutiveSubsequences {
    public static void main(String[] args) {
        Solution solution = new P659SplitArrayIntoConsecutiveSubsequences().new Solution();
        int[] nums = {1, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(solution.isPossible(nums));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Counter {
        Map<Integer, Integer> map = new HashMap<>();

        public int get(int k) {
            return map.getOrDefault(k, 0);
        }

        public void add(int k, int v) {
            map.put(k, get(k) + v);
        }

    }

    class Solution {

        public boolean isPossible1(int[] nums) {
            Counter count = new Counter();
            Counter tail = new Counter();
            for (int n : nums) {
                count.add(n, 1);
            }
            for (int n : nums) {
                if (count.get(n) == 0) {
                    continue;
                }
                if (tail.get(n) > 0) {
                    tail.add(n, -1);
                    tail.add(n + 1, 1);
                } else if (count.get(n + 1) > 0 && count.get(n + 2) > 0) {
                    count.add(n + 1, -1);
                    count.add(n + 2, -1);
                    tail.add(n + 3, 1);
                } else {
                    return false;
                }
                count.add(n, -1);
            }
            return true;
        }

        public boolean isPossible2(int[] nums) {
            Map<Integer, Integer> frequency = new HashMap<>();
            Map<Integer, Integer> append = new HashMap<>();
            for (int n : nums) {
                frequency.put(n, frequency.getOrDefault(n, 0) + 1);
            }
            for (int n : nums) {
                if (frequency.get(n) == 0) {
                    continue;
                } else if (append.getOrDefault(n, 0) > 0) {
                    append.put(n, append.get(n) - 1);
                    append.put(n + 1, append.getOrDefault(n + 1, 0) + 1);
                } else if (frequency.getOrDefault(n + 1, 0) > 0 && frequency.getOrDefault(n + 2, 0) > 0) {
                    frequency.put(n + 1, frequency.get(n + 1) - 1);
                    frequency.put(n + 2, frequency.get(n + 2) - 1);
                    append.put(n + 3, append.getOrDefault(n + 3, 0) + 1);
                } else {
                    return false;
                }
                frequency.put(n, frequency.get(n) - 1);
            }
            return true;
        }

        public boolean isPossible(int[] nums) {
            Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

            for (int num : nums) {
                PriorityQueue<Integer> queue = map.get(num - 1);
                int value;
                if (queue == null || queue.isEmpty()) {
                    value = 1;
                } else {
                    value = queue.poll() + 1;
                }
                if (!map.containsKey(num)) {
                    map.put(num, new PriorityQueue<>());
                }
                map.get(num).add(value);
            }

            return !map.values().stream().flatMap(Collection::stream).anyMatch(i -> i < 3);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}