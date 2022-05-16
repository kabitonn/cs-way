//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例： 
//
// matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
// 
//
// 
//
// 提示： 
//你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。 
// Related Topics 堆 二分查找 
// 👍 388 👎 0


//Java：有序矩阵中第K小的元素

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.PriorityQueue;

public class P378KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new P378KthSmallestElementInASortedMatrix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest1(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k + 1, (o1, o2) -> o2 - o1);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    maxHeap.add(matrix[i][j]);
                    if (maxHeap.size() > k) {
                        maxHeap.poll();
                    }
                }
            }
            return maxHeap.peek();
        }

        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            int left = matrix[0][0];
            int right = matrix[m - 1][n - 1];
            while (left < right) {
                int mid = (left + right) >>> 1;
                int leqCount = countLeqNumber(matrix, mid);
                if (leqCount < k) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        //左下角开始遍历
        int countLeqNumber(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int i = m - 1, j = 0;
            int count = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] <= target) {
                    j++;
                    count += i + 1;
                } else {
                    i--;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}