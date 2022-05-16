//初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启
//则关闭）。第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮着的灯泡。 
//
// 示例: 
//
// 输入: 3
//输出: 1 
//解释: 
//初始时, 灯泡状态 [关闭, 关闭, 关闭].
//第一轮后, 灯泡状态 [开启, 开启, 开启].
//第二轮后, 灯泡状态 [开启, 关闭, 开启].
//第三轮后, 灯泡状态 [开启, 关闭, 关闭]. 
//
//你应该返回 1，因为只有一个灯泡还亮着。
// 
// Related Topics 脑筋急转弯 数学 
// 👍 131 👎 0


//Java：灯泡开关

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P319BulbSwitcher {
    public static void main(String[] args) {
        Solution solution = new P319BulbSwitcher().new Solution();
        // TO TEST
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.bulbSwitch(99999999));
        System.out.println(solution.bulbSwitch1(99999999));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 超时
         *
         * @param n
         * @return
         */
        public int bulbSwitch1(int n) {
            boolean[] switches = new boolean[n];
            for (int i = 1; i <= n; i++) {
                int j = -1;
                for (j = j + i; j < n; j += i) {
                    switches[j] = !switches[j];
                }
            }
            int count = 0;
            for (boolean s : switches) {
                count += s ? 1 : 0;
            }
            return count;
        }

        public int bulbSwitch(int n) {

            return (int) Math.sqrt(n);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}