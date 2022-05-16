//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 525 👎 0


//Java：颜色分类

package com.vika.way.pre.autumn.leetcode.editor.cn;

import java.util.Arrays;

public class P75SortColors {
    public static void main(String[] args) {
        Solution solution = new P75SortColors().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors1(int[] nums) {
            Arrays.sort(nums);
        }

        public void sortColors2(int[] nums) {
            int[] color = new int[3];
            for (int n : nums) {
                color[n]++;
            }
            int i = 0;
            for (int j = 0; j < color.length; j++) {
                for (int k = 0; k < color[j]; k++) {
                    nums[i++] = j;
                }
            }
        }

        public void sortColors3(int[] nums) {
            int p0 = 0;
            int p2 = nums.length - 1;
            int p = 0;
            while (p <= p2) {
                if (nums[p] == 0) {
                    int tmp = nums[p0];
                    nums[p0++] = 0;
                    nums[p++] = tmp;
                } else if (nums[p] == 2) {
                    int tmp = nums[p2];
                    nums[p2--] = 2;
                    nums[p] = tmp;
                } else if (nums[p] == 1) {
                    p++;
                }
            }
        }

        public void sortColors(int[] nums) {
            int p0 = -1, p1 = -1, p2 = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    nums[++p2] = 2;
                    nums[++p1] = 1;
                    nums[++p0] = 0;
                } else if (nums[i] == 1) {
                    nums[++p2] = 2;
                    nums[++p1] = 1;
                } else if (nums[i] == 2) {
                    nums[++p2] = 2;
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}