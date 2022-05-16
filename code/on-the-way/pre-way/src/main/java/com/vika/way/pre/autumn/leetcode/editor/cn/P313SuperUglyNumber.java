//编写一段程序来查找第 n 个超级丑数。 
//
// 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。 
//
// 示例: 
//
// 输入: n = 12, primes = [2,7,13,19]
//输出: 32 
//解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26
//,28,32] 。 
//
// 说明: 
//
// 
// 1 是任何给定 primes 的超级丑数。 
// 给定 primes 中的数字以升序排列。 
// 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。 
// 第 n 个超级丑数确保在 32 位有符整数范围内。 
// 
// Related Topics 堆 数学 
// 👍 97 👎 0


//Java：超级丑数

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.PriorityQueue;

public class P313SuperUglyNumber {
    public static void main(String[] args) {
        Solution solution = new P313SuperUglyNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthSuperUglyNumber1(int n, int[] primes) {
            assert n > 0;
            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            minHeap.add(1L);
            for (int i = 1; i < n; i++) {
                long ugly = minHeap.poll();
                while (!minHeap.isEmpty() && minHeap.peek() == ugly) {
                    minHeap.poll();
                }
                for (int prime : primes) {
                    minHeap.add(ugly * prime);
                }
            }
            return minHeap.peek().intValue();
        }

        public int nthSuperUglyNumber(int n, int[] primes) {
            assert n > 0;
            int[] dp = new int[n];
            dp[0] = 1;
            int m = primes.length;
            int[] values = new int[m];
            int[] p = new int[m];

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    values[j] = dp[p[j]] * primes[j];
                }
                int min = Integer.MAX_VALUE;
                for (int v : values) {
                    min = Math.min(min, v);
                }
                dp[i] = min;
                for (int j = 0; j < m; j++) {
                    if (min >= values[j]) {
                        p[j]++;
                    }
                }
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}