package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

import java.util.Arrays;

public class S238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        S238ProductOfArrayExceptSelf solution = new S238ProductOfArrayExceptSelf();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(solution.productExceptSelf1(nums)));
    }
    public int[] productExceptSelf0(int[] nums) {
        long product = 1;
        int count = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                index = i;
            } else {
                product *= nums[i];
            }
        }
        int[] output = new int[nums.length];
        if (count > 1) {
            return output;
        } else if (count == 1) {
            output[index] = (int) product;
            return output;
        }
        for (int i = 0; i < nums.length; i++) {
            output[i] = (int) (product / nums[i]);
        }
        return output;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = leftProduct;
            leftProduct *= nums[i];
        }
        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return output;
    }

    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int leftProduct = 1;
        int rightProduct = 1;
        Arrays.fill(output, 1);
        for (int i = 0; i < n; i++) {
            output[i] *= leftProduct;
            leftProduct *= nums[i];

            output[n - i - 1] *= rightProduct;
            rightProduct *= nums[n - i - 1];
        }
        return output;
    }
}
