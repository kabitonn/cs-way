package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

import java.util.HashMap;
import java.util.Map;

public class S260SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int[] onceNum = new int[2];
        int index = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                onceNum[index++] = key;
                if (index == 2) {
                    break;
                }
            }
        }
        return onceNum;
    }

    public int[] singleNumber1(int[] nums) {
        int[] onceNum = new int[2];
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }
        int mask = xor;
        //获取区分两个唯一数的最右非0比特位所代表的值
        mask &= (-mask);
        //mask &= (~mask) + 1;
        for (int n : nums) {
            if ((n & mask) == 0) {
                onceNum[0] ^= n;
            } else {
                onceNum[1] ^= n;
            }
        }
        return onceNum;
    }

    public int[] singleNumber1_1(int[] nums) {
        int[] onceNum = new int[2];
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }
        int mask = 1;
        while ((xor & mask) == 0) {
            mask <<= 1;
        }
        for (int n : nums) {
            if ((n & mask) == 0) {
                onceNum[0] ^= n;
            } else {
                onceNum[1] ^= n;
            }
        }
        return onceNum;
    }
}
