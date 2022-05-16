package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

public class S152MaximumProductSubarray {

    public static void main(String[] args) {
        S152MaximumProductSubarray solution = new S152MaximumProductSubarray();
        int[] nums = {-4, -3, -2};
        System.out.println(solution.maxProduct2(nums));
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int prodcut = 1;
            for (int j = i; j < n; j++) {
                prodcut *= nums[j];
                if (prodcut > maxProduct) {
                    maxProduct = prodcut;
                }
            }
        }
        return maxProduct;
    }

    public int maxProduct1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int maxProduct = nums[0];
        int max = nums[0], min = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            maxProduct = Math.max(maxProduct, max);
        }
        return maxProduct;
    }

    public int maxProduct2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int maxProduct = nums[0];
        int max = nums[0], min = nums[0];
        for (int i = 1; i < n; i++) {
            int preMax = max, preMin = min;
            if (nums[i] < 0) {
                max = Math.max(preMin * nums[i], nums[i]);
                min = Math.min(preMax * nums[i], nums[i]);
            } else {
                max = Math.max(preMax * nums[i], nums[i]);
                min = Math.min(preMin * nums[i], nums[i]);
            }
            maxProduct = Math.max(maxProduct, max);
        }
        return maxProduct;
    }

    public int maxProduct3(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int maxProduct = Integer.MIN_VALUE;
        int product = 0, negative = 0;
        boolean hasNegative = false;
        for (int i = 0; i < n; i++) {
            if (product == 0) {
                hasNegative = false;
                product = 1;
            }
            product *= nums[i];
            if (product > maxProduct) {
                maxProduct = product;
            }
            if (hasNegative && product / negative > maxProduct) {
                maxProduct = product / negative;
            }
            if (product < 0 && !hasNegative) {
                hasNegative = true;
                negative = product;
            }
        }
        return maxProduct;
    }
}
