//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划 
// 👍 343 👎 0


//Java：丑数 II

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.PriorityQueue;

public class P264UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new P264UglyNumberIi().new Solution();
        System.out.println(solution.nthUglyNumber(0));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] primes = {2, 3, 5};

        public int nthUglyNumber1(int n) {
            assert n > 0;
            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            minHeap.add(1L);
            while (n-- > 1) {
                long ugly = minHeap.poll();
                while (!minHeap.isEmpty() && ugly == minHeap.peek()) {
                    minHeap.poll();
                }
                for (int v : primes) {
                    minHeap.add(ugly * v);
                }
            }
            assert minHeap.peek() != null;
            return minHeap.peek().intValue();
        }

        public int nthUglyNumber2(int n) {
            assert n > 0;
            int p2 = 0, p3 = 0, p5 = 0;
            int v2, v3, v5;
            int min;
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                v2 = dp[p2] * 2;
                v3 = dp[p3] * 3;
                v5 = dp[p5] * 5;
                min = Math.min(Math.min(v2, v3), v5);
                dp[i] = min;
                if (min >= v2) {
                    p2++;
                }
                if (min >= v3) {
                    p3++;
                }
                if (min >= v5) {
                    p5++;
                }
            }

            return dp[n - 1];
        }

        public int nthUglyNumber(int n) {
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