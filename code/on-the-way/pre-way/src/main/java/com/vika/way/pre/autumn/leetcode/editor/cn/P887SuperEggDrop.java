//你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N 共有 N 层楼的建筑。 
//
// 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。 
//
// 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。 
//
// 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。 
//
// 你的目标是确切地知道 F 的值是多少。 
//
// 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？ 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：K = 1, N = 2
//输出：2
//解释：
//鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
//否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
//如果它没碎，那么我们肯定知道 F = 2 。
//因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
// 
//
// 示例 2： 
//
// 输入：K = 2, N = 6
//输出：3
// 
//
// 示例 3： 
//
// 输入：K = 3, N = 14
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= 100 
// 1 <= N <= 10000 
// 
// Related Topics 数学 二分查找 动态规划 
// 👍 475 👎 0


//Java：鸡蛋掉落

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

public class P887SuperEggDrop {
    public static void main(String[] args) {
        Solution solution = new P887SuperEggDrop().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 超时
         *
         * @param K
         * @param N
         * @return
         */
        public int superEggDrop1(int K, int N) {
            int[][] memo = new int[N + 1][K + 1];
            for (int[] m : memo) {
                Arrays.fill(m, -1);
            }
            return conquer(N, K, memo);
        }

        public int conquer(int n, int k, int[][] memo) {
            if (n == 0 || n == 1 || k == 1) {
                return n;
            }
            if (memo[n][k] != -1) {
                return memo[n][k];
            }
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                min = Math.min(min, Math.max(conquer(i - 1, k - 1, memo), conquer(n - i, k, memo)) + 1);
            }
            memo[n][k] = min;
            return min;
        }

        public int superEggDrop(int K, int N) {
            int[][] memo = new int[N + 1][K + 1];
            for (int[] m : memo) {
                Arrays.fill(m, -1);
            }
            int t = 1;
            while (cover(t, K, memo) <= N) {
                t++;
            }
            return t;
        }

        public int cover(int t, int k, int[][] memo) {
            if (t == 1 || k == 1) {
                return t + 1;
            }
            if (memo[t][k] != -1) {
                return memo[t][k];
            }
            return cover(t - 1, k - 1, memo) + cover(t - 1, k, memo);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.superEggDrop(6, 5000));
    }
}