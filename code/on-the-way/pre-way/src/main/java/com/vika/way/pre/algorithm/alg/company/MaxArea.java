package com.vika.way.pre.algorithm.alg.company;

import java.util.Scanner;

public class MaxArea {

    public int maxArea0(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int[] sums = new int[n + 1];
        int max = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
            sum += nums[i];
            sums[i + 1] = sum;
            max = Math.max(max, nums[i] * nums[i]);
        }
        int product;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], nums[j]);
                product = dp[i][j] * (sums[j + 1] - sums[i]);
                System.out.println("" + i + j + product);
                max = Math.max(max, product);
            }
        }
        return max;
    }

    public int maxArea(int[] nums) {
        int n = nums.length;
        int max = 0, min, sum;
        int product;
        for (int i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                min = Math.min(min, nums[j]);
                product = min * sum;
                max = Math.max(max, product);
            }
        }
        return max;
    }

    public int maxArea1(int[] nums) {
        int n = nums.length;
        int max = 0;
        int min, sum;
        int left, right;
        for (int i = 0; i < n; i++) {
            min = nums[i];
            left = i - 1;
            right = i + 1;
            sum = nums[i];
            while (left >= 0 && nums[left] >= min) {
                sum += nums[left--];
            }
            while (right < n && nums[right] >= min) {
                sum += nums[right++];
            }
            max = Math.max(max, min * sum);
        }
        return max;
    }

    public int maxArea2(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int[] left = new int[n];
        int[] right = new int[n];
        int[] stack = new int[n];
        int top = 0;
        for (int i = 0; i < n; i++) {
            while (top > 0 && nums[stack[top - 1]] >= nums[i]) {
                top--;
            }
            left[i] = top > 0 ? stack[top - 1] + 1 : 0;
            stack[top++] = i;
        }
        top = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (top > 0 && nums[stack[top - 1]] >= nums[i]) {
                top--;
            }
            right[i] = top > 0 ? stack[top - 1] - 1 : n - 1;
            stack[top++] = i;
        }
        int max = 0;
        int product;
        for (int i = 0; i < n; i++) {
            product = nums[i] * (sums[right[i] + 1] - sums[left[i]]);
            max = Math.max(max, product);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] array = {81, 87, 47, 59, 81, 18, 25, 40, 56, 0};
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea2(array));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(maxArea.maxArea(nums));

    }
}
