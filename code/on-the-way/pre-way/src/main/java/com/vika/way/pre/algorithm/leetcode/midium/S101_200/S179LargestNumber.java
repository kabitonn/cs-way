package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

import java.util.Arrays;
import java.util.Comparator;

public class S179LargestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (compareTo(nums[i], nums[j]) < 0) {
                    swap(nums, i, j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (sb.length() == 0 && i != n - 1 && nums[i] == 0) {
                continue;
            }
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public int compareTo(int a, int b) {
        String ab = "" + a + b;
        String ba = "" + b + a;
        return ab.compareTo(ba);
    }

    public void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public String largestNumber1(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o2.compareTo(o1);
                }
                String o12 = o1 + o2;
                String o21 = o2 + o1;
                return o21.compareTo(o12);
            }
        });
        if (strs[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String n : strs) {
            sb.append(n);
        }
        return sb.toString();
    }
    public String largestNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> {
            if (a.length() == b.length()) {
                return b.compareTo(a);
            }
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });
        if (strs[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String n : strs) {
            sb.append(n);
        }
        return sb.toString();
    }
}
