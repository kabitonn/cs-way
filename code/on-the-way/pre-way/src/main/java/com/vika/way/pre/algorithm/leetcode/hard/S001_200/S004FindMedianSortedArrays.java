package com.vika.way.pre.algorithm.leetcode.hard.S001_200;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

 * @author tokabi
 *
 */
public class S004FindMedianSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = {1};
		int[] nums2 = {1};
		S004FindMedianSortedArrays solution4 = new S004FindMedianSortedArrays();
		
		System.out.println(solution4.findMedianSortedArrays(nums1, nums2));

	}
	public double findMedianSortedArrays0(int[] nums1, int[] nums2) {
		int m=nums1.length;
		int n=nums2.length;
		int i=0,j=0;
		int[] nums = new int[m+n];
		int k=0;
		while(i<m||j<n) {
			while(i<m&&(j==n||nums1[i]<nums2[j])) {
				nums[k++] = nums1[i++];
			}
			while(j<n&&(i==m||nums1[i]>=nums2[j])) {
				nums[k++] = nums2[j++];
			}
		}
		if((m+n)%2==0) {
			return (double)(nums[(m+n)/2-1]+nums[(m+n)/2])/2.0;
		}
		else {
			return nums[(m+n)/2];
		}
	
    }

	public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
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
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int m=nums1.length;
		int n=nums2.length;
		int pre=0,cur=0;
		int i=0,j=0;
		
		int mid = (m+n)/2;
		boolean isEven = (m+n)%2==0?true:false;
		for(int k=0;k<=mid;k++) {
			pre = cur;
			if(i<m&&(j>=n||nums1[i]<nums2[j])) {
				cur = nums1[i++];
			}
			else if(j<n&&(i>=m)||nums1[i]>=nums2[j]) {
				cur = nums2[j++];
			}
		}
		if(isEven) {
			return (pre+cur)/2.0;
		}
		else {
			return cur;
		}
		
	}
	
	public double findMedianSortedArrays(int[] A, int[] B) {
		int m = A.length;
        int n = B.length;
        if (m > n) { 
            return findMedianSortedArrays(B,A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j-1] > A[i]){ // i 需要增大
                iMin = i + 1; 
            }
            else if (i != 0 && j != n && A[i-1] > B[j]) { // i 需要减小
                iMax = i - 1; 
            }
            else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0; 
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }
}
