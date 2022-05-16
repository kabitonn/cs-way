package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

import java.util.Arrays;

public class S453MinMovesEqualArrayElement {
    public static void main(String[] args) {
        S453MinMovesEqualArrayElement solution = new S453MinMovesEqualArrayElement();
        int[] nums = {1, 2, 3};
        System.out.println(solution.minMoves3(nums));
    }

    //数学法防止溢出
    public int minMoves4(int[] nums) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int n : nums) {
            min = Math.min(min, n);
        }
        for (int n : nums) {
            count += n - min;
        }
        return count;
    }

    //数学法
    public int minMoves3(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int n : nums) {
            if (n < min) {
                min = n;
            }
            sum += n;
        }
        int count = sum - min * nums.length;
        return count;

    }

    //动态规划
    public int minMoves2(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            int diff = count + nums[i] - nums[i - 1];
            nums[i] += count;
            count += diff;
        }
        return count;
    }

    //排序
    public int minMoves1(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            count += nums[i] - nums[0];
        }
        return count;
    }

    public int minMoves0(int[] nums) {
        int count = 0;
        int min = 0, max = nums.length - 1;
        while (true) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[max] < nums[i]) {
                    max = i;
                }
                if (nums[min] > nums[i]) {
                    min = i;
                }
            }
            int diff = nums[max] - nums[min];
            if (diff == 0) {
                break;
            }
            count += diff;
            for (int i = 0; i < nums.length; i++) {
                if (i != max) {
                    nums[i] = nums[i] + diff;
                }
            }
        }
        return count;
    }

    public int minMoves(int[] nums) {
        int count = 0;
        while (true) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                }
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            if (min == max) {
                break;
            } else {
                int n = max - min;
                count += n;
                for (int i = 0; i < nums.length; i++) {
                    if (i != maxIndex) {
                        nums[i] += n;
                    }
                }
            }
        }
        return count;
    }
}
