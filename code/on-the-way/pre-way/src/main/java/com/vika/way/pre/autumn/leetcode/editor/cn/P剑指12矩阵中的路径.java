//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
//
// [["a","b","c","e"], 
//["s","f","c","s"], 
//["a","d","e","e"]] 
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
//
// 
//
// 示例 1： 
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
//
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 161 👎 0


//Java：矩阵中的路径

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P剑指12矩阵中的路径 {
    public static void main(String[] args) {
        Solution solution = new P剑指12矩阵中的路径().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            if (word.length() == 0) {
                return true;
            }
            if (board.length == 0 || board[0].length == 0) {
                return false;
            }
            int m = board.length, n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != word.charAt(0)) {
                        continue;
                    }
                    if (exist(board, word, 0, i, j, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean exist(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
                return false;
            } else if (word.charAt(index++) != board[i][j]) {
                return false;
            } else if (index == word.length()) {
                return true;
            }
            visited[i][j] = true;
            boolean flag = exist(board, word, index, i + 1, j, visited);
            flag = flag || exist(board, word, index, i - 1, j, visited);
            flag = flag || exist(board, word, index, i, j + 1, visited);
            flag = flag || exist(board, word, index, i, j - 1, visited);
            visited[i][j] = false;
            return flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}