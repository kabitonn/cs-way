package com.vika.way.pre.algorithm.leetcode.datastructure;

import java.util.Arrays;

public class NumArray1_3 {

    int[] sumTree;
    int[] nums;
    int size;

    public NumArray1_3(int[] nums) {
        this.nums = Arrays.copyOf(nums, nums.length);
        size = nums.length;
        sumTree = new int[size << 1];
        buildTree();
    }

    public void buildTree() {
        for (int i = size, j = 0; i < size << 1; j++, i++) {
            sumTree[i] = nums[j];
        }
        for (int i = size - 1; i >= 0; i--) {
            sumTree[i] = sumTree[i * 2] + sumTree[i * 2 + 1];
        }
    }

    public void update(int i, int val) {
        int pos = i;
        nums[pos] = val;
        pos += size;
        sumTree[pos] = val;
        while (pos > 1) {
            sumTree[pos >> 1] = sumTree[pos] + sumTree[pos ^ 1];
            pos >>= 1;
        }

    }

    public int sumRange(int i, int j) {
        int m = i + size;
        int n = j + size;
        int sum = 0;
        while (m <= n) {
            if ((m & 1) == 1) {
                sum += sumTree[m++];
            }
            m >>= 1;
            if ((n & 1) == 0) {
                sum += sumTree[n--];
            }
            n >>= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray1_3 array = new NumArray1_3(nums);
        System.out.println(array.sumRange(0, 2));
    }
}
