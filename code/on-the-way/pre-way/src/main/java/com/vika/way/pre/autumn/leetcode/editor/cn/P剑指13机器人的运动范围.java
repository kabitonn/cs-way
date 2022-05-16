//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 151 👎 0


//Java：机器人的运动范围

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class P剑指13机器人的运动范围 {
    public static void main(String[] args) {
        Solution solution = new P剑指13机器人的运动范围().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movingCount1(int m, int n, int k) {
            boolean[][] visited = new boolean[m][n];
            return dfs(0, 0, m, n, k, visited);
        }

        public int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
            if (i < 0 || i == m || j < 0 || j == n || visited[i][j]) {
                return 0;
            } else if (!canEntry(i, j, k)) {
                return 0;
            }
            visited[i][j] = true;
            int count = 1;
            count += dfs(i + 1, j, m, n, k, visited);
            count += dfs(i - 1, j, m, n, k, visited);
            count += dfs(i, j + 1, m, n, k, visited);
            count += dfs(i, j - 1, m, n, k, visited);
            return count;
        }

        public int movingCount(int m, int n, int k) {
            return bfs(m, n, k);
        }

        public int bfs(int m, int n, int k) {
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[m][n];
            int count = 1;
            queue.offer(new int[]{0, 0});
            visited[0][0] = true;
            int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            while (!queue.isEmpty()) {
                int[] pos = queue.poll();

                for (int i = 0; i < d.length; i++) {
                    int x = pos[0] + d[i][0], y = pos[1] + d[i][1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && canEntry(x, y, k)) {
                        visited[x][y] = true;
                        count++;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            return count;
        }


        public boolean canEntry(int i, int j, int k) {
            int sum = 0;
            while (i != 0 || j != 0) {
                sum += i % 10 + j % 10;
                i /= 10;
                j /= 10;
            }
            return sum <= k;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}