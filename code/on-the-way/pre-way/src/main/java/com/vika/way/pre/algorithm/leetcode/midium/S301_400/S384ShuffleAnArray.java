package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.Arrays;
import java.util.Random;

public class S384ShuffleAnArray {

    final int[] nums;
    int[] shuffle;
    Random random;
    int length;

    public S384ShuffleAnArray(int[] nums) {
        length = nums.length;
        this.nums = Arrays.copyOf(nums, length);
        shuffle = Arrays.copyOf(nums, length);
        random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        shuffle = Arrays.copyOf(nums, length);
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        if (length == 0) {
            return shuffle;
        }
        int count = random.nextInt(length);
        for (int k = 0; k < count; k++) {
            int i = random.nextInt(length);
            int j = random.nextInt(length);
            swap(shuffle, i, j);
        }
        return shuffle;
    }

    public int[] shuffle1() {
        for (int i = 0; i < length; i++) {
            int j = random.nextInt(length - i) + i;
            swap(shuffle, i, j);
        }
        return shuffle;
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        S384ShuffleAnArray solution = new S384ShuffleAnArray(nums);
        System.out.println(Arrays.toString(solution.shuffle()));
    }
}
