package com.vika.way.pre.algorithm.alg.common;

import java.util.Random;

public class RandomArray {

    static Random random = new Random();

    public static int[] randomArray(int max, int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(max);
        }

        return nums;


    }



}
