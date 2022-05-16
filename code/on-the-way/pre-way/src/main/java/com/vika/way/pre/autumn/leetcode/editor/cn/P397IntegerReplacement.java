//给定一个正整数 n，你可以做如下操作： 
//
// 1. 如果 n 是偶数，则用 n / 2替换 n。 
//2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。 
//n 变为 1 所需的最小替换次数是多少？ 
//
// 示例 1: 
//
// 
//输入:
//8
//
//输出:
//3
//
//解释:
//8 -> 4 -> 2 -> 1
// 
//
// 示例 2: 
//
// 
//输入:
//7
//
//输出:
//4
//
//解释:
//7 -> 8 -> 4 -> 2 -> 1
//或
//7 -> 6 -> 3 -> 2 -> 1
// 
// Related Topics 位运算 数学 
// 👍 70 👎 0


//Java：整数替换

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P397IntegerReplacement {
    public static void main(String[] args) {
        Solution solution = new P397IntegerReplacement().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerReplacement(int n) {
            long m = n;
            int count = 0;
            while (m > 1) {
                if ((m & 1) == 0) {
                    m >>= 1;
                } else if ((m & 2) == 0) {
                    m -= 1;
                } else if (m > 3) {
                    m += 1;
                } else if (m == 3) {
                    m--;
                }
                count++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}