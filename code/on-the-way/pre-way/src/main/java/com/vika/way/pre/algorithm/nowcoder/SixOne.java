package com.vika.way.pre.algorithm.nowcoder;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class SixOne {

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

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    int min = Integer.MAX_VALUE;

    public void permute(int[] nums, int start) {
        if (start == nums.length) {
            min = Math.min(min, maxMinHeightDiff(nums));
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            permute(nums, start + 1);
            swap(nums, i, start);
        }
    }

    public int maxMinHeightDiff(int[] nums) {
        int n = nums.length;
        int max = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, Math.abs(nums[i] - nums[i + 1]));
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        SixOne sixOne = new SixOne();
        sixOne.permute(nums, 0);
        System.out.println(sixOne.min);
    }
    @Test
    public void test(){
        int [] nums={100,103,98,105};
        permute(nums,0);
        System.out.println(min);
    }
}
