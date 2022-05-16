package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.Arrays;

public class S324WiggleSortII {

    //输入序列在排序后最多只有序列长度一半(n/2)的相邻的数连续相等。
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int[] copy = Arrays.copyOf(nums, len);
        Arrays.sort(copy);
        int mid = (len + 1) / 2;
        for (int i = 0; i < mid; i++) {
            nums[i * 2] = copy[mid - 1 - i];
        }
        for (int i = 0; i < len / 2; i++) {
            nums[i * 2 + 1] = copy[len - 1 - i];
        }
    }

    public void wiggleSort0(int[] nums) {
        int len = nums.length;
        int[] copy = Arrays.copyOf(nums, len);
        Arrays.sort(copy);
        int mid = (len + 1) / 2 - 1, end = len - 1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i % 2 == 0 ? copy[mid--] : copy[end--];
        }
    }

    public void wiggleSort1(int[] nums) {
        int len = nums.length;
        int[] copy = Arrays.copyOf(nums, len);
        Arrays.sort(copy);
        int j = len - 1;
        for (int i = 0; i * 2 + 1 < len; i++) {
            nums[i * 2 + 1] = copy[j--];
        }
        for (int i = 0; i * 2 < len; i++) {
            nums[i * 2] = copy[j--];
        }
    }
}
