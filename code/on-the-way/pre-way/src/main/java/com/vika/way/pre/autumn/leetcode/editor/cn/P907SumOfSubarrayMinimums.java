//给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。 
//
// 由于答案可能很大，因此返回答案模 10^9 + 7。 
//
// 
//
// 示例： 
//
// 输入：[3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
//最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。 
//
// 
//
// 提示： 
//
// 
// 1 <= A <= 30000 
// 1 <= A[i] <= 30000 
// 
//
// 
// Related Topics 栈 数组 
// 👍 142 👎 0


//Java：子数组的最小值之和

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P907SumOfSubarrayMinimums {
    public static void main(String[] args) {
        Solution solution = new P907SumOfSubarrayMinimums().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int sumSubarrayMins(int[] A) {
            int n = A.length;
            for (int i = 1; i <= n; i++) {

            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}