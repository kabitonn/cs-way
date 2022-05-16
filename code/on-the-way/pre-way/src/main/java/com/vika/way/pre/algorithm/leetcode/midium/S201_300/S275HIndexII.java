package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

public class S275HIndexII {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0;
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] < len - mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return len - left;
    }

    public int hIndex2(int[] citations) {
        int len = citations.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] < len - mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //left为满足citations[i] >= len - i 的左边界的索引
        if (left < len && citations[left] < len - left) {
            left++;
        }
        return len - left;
    }
}
