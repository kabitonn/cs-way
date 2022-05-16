//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 745 👎 0


//Java：岛屿数量

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int m = grid.length, n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            int islands = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '0' || visited[i][j]) {
                        continue;
                    }
                    islands++;
                    dfs(grid, visited, i, j);
                }
            }
            return islands;
        }

        public void dfs(char[][] grid, boolean[][] visited, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                return;
            }
            if (grid[i][j] == '0' || visited[i][j]) {
                return;
            }
            visited[i][j] = true;
            dfs(grid, visited, i - 1, j);
            dfs(grid, visited, i + 1, j);
            dfs(grid, visited, i, j - 1);
            dfs(grid, visited, i, j + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}