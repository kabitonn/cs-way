package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.Random;
import java.util.TreeMap;

public class S528RandomPickWithWeight_1 {

    TreeMap<Integer, Integer> weight;
    Random random;
    int sum;

    public S528RandomPickWithWeight_1(int[] w) {
        weight = new TreeMap<>();
        random = new Random();
        sum = 0;
        for (int i = 0; i < w.length; i++) {
            weight.put(sum, i);
            sum += w[i];
        }
    }

    public int pickIndex() {
        int target = random.nextInt(sum);
        int index = weight.get(weight.floorKey(target));
        return index;
    }
}
