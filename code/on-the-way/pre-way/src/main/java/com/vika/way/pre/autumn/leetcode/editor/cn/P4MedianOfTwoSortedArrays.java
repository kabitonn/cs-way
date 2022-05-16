//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3142 👎 0


//Java：寻找两个正序数组的中位数

package com.vika.way.pre.autumn.leetcode.editor.cn;

import org.junit.Test;

public class P4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m=nums1.length;
            int n=nums2.length;
            int i=0,j=0;
            int mid = (m+n)/2;
            int[] nums = new int[m+n];
            int k=0;

            boolean isEven = (m+n)%2==0?true:false;
            while((k<=mid)&&(i<m||j<n)) {
                while(i<m&&(j>=n||nums1[i]<nums2[j])) {
                    nums[k++] = nums1[i++];
                }
                while(j<n&&(i>=m||nums1[i]>=nums2[j])) {
                    nums[k++] = nums2[j++];
                }
            }
            if(isEven) {
                return (nums[mid-1]+nums[mid])/2.0;
            }
            else {
                return nums[mid];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        Solution solution = new Solution();

    }
}