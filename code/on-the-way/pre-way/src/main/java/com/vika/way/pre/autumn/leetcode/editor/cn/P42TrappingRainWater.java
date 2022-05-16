//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 1499 👎 0


//Java：接雨水

package com.vika.way.pre.autumn.leetcode.editor.cn;

public class P42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap1(int[] height) {
            int n = height.length;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int leftMax = 0;
                for (int j = 0; j < i; j++) {
                    leftMax = Math.max(leftMax, height[j]);
                }
                int rightMax = 0;
                for (int j = n - 1; j > i; j--) {
                    rightMax = Math.max(rightMax, height[j]);
                }
                sum += Math.max(0, Math.min(leftMax, rightMax) - height[i]);
            }
            return sum;
        }

        public int trap2(int[] height) {
            int n = height.length;
            int[] leftMax = new int[n];
            int[] rightMax = new int[n];
            int sum = 0;
            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
            }
            for (int i = n - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
            }
            for (int i = 0; i < n; i++) {
                sum += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
            }
            return sum;
        }

        public int trap(int[] height) {
            int n = height.length;
            int sum = 0;
            int left = 0, right = n - 1;
            int leftMax = 0, rightMax = 0;
            while (left < right) {
                if (height[left] < height[right]) {

                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}