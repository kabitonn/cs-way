package com.vika.way.pre.algorithm.alg.sort;



import com.vika.way.pre.algorithm.alg.common.RandomArray;

import java.util.Arrays;

public class ShellSort {


    public void shellSort(int[] nums) {
        int n = nums.length;
        int gap = n >> 1;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                if (nums[i] >= nums[i - gap]) {
                    continue;
                }
                int temp = nums[i];
                int j = i - gap;
                for (; j >= 0 && nums[j] > temp; j -= gap) {
                    nums[j + gap] = nums[j];
                }
                nums[j + gap] = temp;
            }
            gap >>= 1;
        }
    }

    public static void main(String[] args) {

        int n = 100000;
        int[] nums = RandomArray.randomArray(n, n);
        int[] copy = nums.clone();
        Arrays.sort(copy);
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(nums);
        System.out.println(Arrays.equals(copy, nums));
        System.out.println(1.0+2.0);
    }
}
