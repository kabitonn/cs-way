package com.vika.way.pre.algorithm.alg.sort;



import com.vika.way.pre.algorithm.alg.common.RandomArray;

import java.util.Arrays;

public class CountingSort {

    public void countingSort(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (max < min) {
            return;
        }
        int bias = -min;
        int[] counter = new int[max - min + 1];
        for (int num : nums) {
            counter[num + bias]++;
        }
        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i] + bias;
            temp[counter[num] - 1] = nums[i];
            counter[num]--;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    public void countingSortOne(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (max <= min) {
            return;
        }
        int bias = -min;
        int[] counter = new int[max - min + 1];
        for (int num : nums) {
            counter[num + bias]++;
        }
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            while (counter[c] == 0) {
                c++;
            }
            nums[i] = c - bias;
            counter[c]--;
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        int[] nums = RandomArray.randomArray(n, n);
        int[] copy = nums.clone();
        Arrays.sort(copy);
        CountingSort countingSort=new CountingSort();
        countingSort.countingSortOne(nums);
        System.out.println(Arrays.equals(copy,nums));
    }
}
