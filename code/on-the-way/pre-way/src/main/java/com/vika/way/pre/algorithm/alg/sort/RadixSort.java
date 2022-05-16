package com.vika.way.pre.algorithm.alg.sort;



import com.vika.way.pre.algorithm.alg.common.RandomArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {

    final int radix = 10;

    public void radixSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int numKey = 0;
        while (max != 0) {
            numKey++;
            max /= 10;
        }
        List<Integer>[] bucketList = new List[radix];
        for (int i = 0; i < radix; i++) {
            bucketList[i] = new ArrayList<>();
        }
        int mod = radix, div = 1;
        for (int i = 0; i < numKey; i++, mod *= radix, div *= radix) {
            int key;
            for (int num : nums) {
                key = num % mod / div;
                bucketList[key].add(num);
            }
            int k = 0;
            for (List<Integer> list : bucketList) {
                for (int num : list) {
                    nums[k++] = num;
                }
                list.clear();
            }
        }
    }

    public static void main(String[] args) {
        int n = 20;
        int[] nums = RandomArray.randomArray(n, n);
        int[] copy = nums.clone();
        Arrays.sort(copy);
        System.out.println(Arrays.toString(nums));
        RadixSort radixSort = new RadixSort();
        radixSort.radixSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.equals(copy, nums));
    }
}
