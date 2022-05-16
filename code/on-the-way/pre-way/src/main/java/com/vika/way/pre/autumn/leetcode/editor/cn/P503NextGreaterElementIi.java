//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈 
// 👍 163 👎 0


//Java：下一个更大元素 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

public class P503NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new P503NextGreaterElementIi().new Solution();
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(solution.nextGreaterElements(nums)));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] nextGreaterElements1(int[] nums) {
            int n = nums.length;
            int[] next = new int[n];
            for (int i = 0; i < n; i++) {
                next[i] = -1;
                for (int j = (i + 1) % n; j != i; j = (j + 1) % n) {
                    if (nums[j] > nums[i]) {
                        next[i] = nums[j];
                        break;
                    }
                }
            }
            return next;
        }

        public int[] nextGreaterElements2(int[] nums) {
            int n = nums.length;
            int maxIndex = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }
            int[] next = new int[nums.length];
            Stack<Integer> indexStack = new Stack<>();
            for (int i = maxIndex + 1; i <= maxIndex + n; i++) {
                int k = i % n;
                while (!indexStack.isEmpty() && nums[k] > nums[indexStack.peek()]) {
                    next[indexStack.pop()] = nums[k];
                }
                indexStack.push(k);
            }
            while (!indexStack.isEmpty()) {
                next[indexStack.pop()] = -1;
            }
            return next;
        }

        public int[] nextGreaterElements3(int[] nums) {
            int n = nums.length;
            int[] next = new int[nums.length];
            Stack<Integer> indexStack = new Stack<>();
            for (int i = 0; i < n * 2; i++) {
                int k = i % n;
                while (!indexStack.isEmpty() && nums[k] > nums[indexStack.peek()]) {
                    next[indexStack.pop()] = nums[k];
                }
                if (i < n) {
                    indexStack.push(k);
                }
            }
            while (!indexStack.isEmpty()) {
                next[indexStack.pop()] = -1;
            }
            return next;
        }

        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] next = new int[nums.length];
            Stack<Integer> indexStack = new Stack<>();
            for (int i = 2 * n - 1; i >= 0; i--) {
                int k = i % n;
                while (!indexStack.isEmpty() && nums[k] >= nums[indexStack.peek()]) {
                    indexStack.pop();
                }
                if (!indexStack.isEmpty()) {
                    next[k] = nums[indexStack.peek()];
                } else {
                    next[k] = -1;
                }
                indexStack.push(k);
            }
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}