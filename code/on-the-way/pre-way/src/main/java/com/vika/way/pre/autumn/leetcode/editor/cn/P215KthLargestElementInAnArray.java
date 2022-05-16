//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 628 👎 0


//Java：数组中的第K个最大元素

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(solution.findKthLargest(nums, 2));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest1(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }

        public int findKthLargest2(int[] nums, int k) {
            int n = nums.length;
            k = n - k;
            int left = 0, right = n - 1;
            while (true) {
                int pivot = quickPass(nums, left, right);
                if (pivot < k) {
                    left = pivot + 1;
                } else if (pivot > k) {
                    right = pivot - 1;
                } else {
                    break;
                }
            }
            return nums[k];
        }

        int quickPass(int[] nums, int low, int high) {
            int pivot = nums[low];
            while (low < high) {
                while (low < high && nums[high] >= pivot) {
                    high--;
                }
                nums[low] = nums[high];
                while (low < high && nums[low] < pivot) {
                    low++;
                }
                nums[high] = nums[low];
            }
            nums[low] = pivot;
            return low;
        }

        public int findKthLargest3(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1, (o1, o2) -> o1 - o2);
            for (int i = 0; i < k; i++) {
                minHeap.add(nums[i]);
            }
            for (int i = k; i < nums.length; i++) {
                minHeap.add(nums[i]);
                minHeap.poll();
            }
            return minHeap.poll();
        }

        public int findKthLargest(int[] nums, int k) {
            buildMinHeap(nums);
            int sort = nums.length;
            for (int i = k; i < nums.length; i++) {
                swap(nums, 0, --sort);
                adjustMinHeap(nums, 0, sort);
            }
            return nums[0];
        }

        void buildMinHeap(int[] arr) {
            int len = arr.length;
            for (int i = len / 2; i >= 0; i--) {
                adjustMinHeap(arr, i, len);
            }
        }

        void adjustMinHeap(int[] arr, int node, int size) {
            int left = node * 2 + 1;
            int right = left + 1;
            while (left < size) {
                int min = right < size && arr[left] > arr[right] ? right : left;
                if (arr[node] <= arr[min]) {
                    break;
                }
                swap(arr, min, node);
                node = min;
                left = node * 2 + 1;
                right = left + 1;
            }
        }

        void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}