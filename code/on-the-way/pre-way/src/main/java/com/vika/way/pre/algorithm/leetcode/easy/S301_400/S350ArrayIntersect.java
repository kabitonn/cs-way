package com.vika.way.pre.algorithm.leetcode.easy.S301_400;

import java.util.Arrays;
import java.util.HashMap;

public class S350ArrayIntersect {

    public static void main(String[] args) {

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int size = nums1.length > nums2.length ? nums2.length : nums1.length;
        int[] res = new int[size];
        int i = 0, j = 0, index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] == nums2[j]) {
                res[index++] = nums1[i];
                i++;
                j++;
            }
        }

        return Arrays.copyOf(res, index);
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = nums1.length > nums2.length ? nums2.length : nums1.length;
        int[] res = new int[size];
        int index = 0;
        for (int n : nums1) {
            int count = map.getOrDefault(n, 0);
            map.put(n, ++count);
        }
        for (int n : nums2) {
            if (map.containsKey(n)&&map.get(n)>0) {
                res[index++] = n;
                map.put(n, map.get(n)-1);
            }
        }
        return Arrays.copyOf(res, index);
    }
}
