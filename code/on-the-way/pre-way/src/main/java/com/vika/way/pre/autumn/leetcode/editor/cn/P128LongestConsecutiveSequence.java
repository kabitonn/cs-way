//给定一个未排序的整数数组，找出最长连续序列的长度。 
//
// 要求算法的时间复杂度为 O(n)。 
//
// 示例: 
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。 
// Related Topics 并查集 数组 
// 👍 524 👎 0


//Java：最长连续序列

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class P128LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new P128LongestConsecutiveSequence().new Solution();
        // TO TEST
    }


    @Test
    public void test() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int max = 0;
            for (int num : nums) {
                set.add(num);
            }
            for (int num : nums) {
                if (!set.contains(num - 1)) {
                    int cur = num;
                    int len = 1;
                    while (set.contains(++cur)) {
                        len++;
                    }
                    max = Math.max(max, len);
                }
            }
            return max;
        }

        public int longestConsecutive1(int[] nums) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            int n = max - min + 1;
            int offset = min;
            boolean[] bucket = new boolean[n + 2];
            for (int num : nums) {
                bucket[num - offset + 1] = true;
            }
            int maxLen = 0;
            for (int num : nums) {
                if (!bucket[num - offset + 1 - 1]) {
                    int cur = num;
                    int len = 1;
                    while (bucket[++cur - offset + 1]) {
                        len++;
                    }
                    maxLen = Math.max(maxLen, len);
                }
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}