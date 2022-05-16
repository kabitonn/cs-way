package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

public class S088MergeSortedArray {

    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        //将 nums1 的数字全部移动到末尾
        for (int i = 1; i <= m; i++) {
            nums1[m + n - i] = nums1[m - i];
        }
        int i = n;
        int j = 0;
        int k = 0;
        //遍历 nums2
        while (j < n) {
            //如果 nums1 遍历结束，将 nums2 直接加入
            if (i == m + n) {
                while (j < n) {
                    nums1[k++] = nums2[j++];
                }
                return;
            }
            //哪个数小就对应的添加哪个数
            if (nums2[j] < nums1[i]) {
                nums1[k++] = nums2[j++];
            } else {
                nums1[k++] = nums1[i++];
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        //遍历 nums2
        while (j < n) {
            //判断 nums1 是否遍历完
            //（nums1 原有的数和当前已经插入的数相加）和 i 进行比较
            if (i == m + j) {
                //将剩余的 nums2 插入
                while (j < n) {
                    nums1[m + j] = nums2[j];
                    j++;
                }
                return;
            }
            //判断当前 nums2 是否小于 nums1
            if (nums2[j] < nums1[i]) {
                //nums1 后移数组，空出位置以便插入
                for (int k = m + j; k > i; k--) {
                    nums1[k] = nums1[k - 1];
                }
                nums1[i++] = nums2[j++];
            } else {
                i++;
            }
        }
    }
}
