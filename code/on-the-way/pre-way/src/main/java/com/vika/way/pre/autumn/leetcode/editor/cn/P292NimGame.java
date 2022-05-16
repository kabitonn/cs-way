//你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。 
//
// 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。 
//
// 示例: 
//
// 输入: 4
//输出: false 
//解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
//     因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
// 
// Related Topics 脑筋急转弯 极小化极大 
// 👍 362 👎 0


//Java：Nim 游戏

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P292NimGame {
    public static void main(String[] args) {
        Solution solution = new P292NimGame().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canWinNim(int n) {
            return n % 4 != 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}