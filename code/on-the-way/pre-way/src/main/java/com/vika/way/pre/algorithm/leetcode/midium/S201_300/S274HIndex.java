package com.vika.way.pre.algorithm.leetcode.midium.S201_300;

import java.util.Arrays;

public class S274HIndex {
    public static void main(String[] args) {
        S274HIndex solution = new S274HIndex();
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution.hIndex(citations));
    }

    public int hIndex0_1(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int h = 0;
        // 至多有 h 篇论文分别被引用了至少 h 次
        while (h < len && citations[len - h - 1] >= h + 1) {
            h++;
        }
        return h;
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int h = 0;
        // 至多有 h 篇论文分别被引用了至少 h 次
        while (h < len && citations[len - h - 1] > h) {
            h++;
        }
        return h;
    }

    public int hIndex0(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int index = len - 1;
        while (index >= 0 && citations[index] >= len - index) {
            index--;
        }
        return len - index - 1;
    }

    public int hIndex1(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        // 计数
        for (int c : citations) {
            papers[Math.min(n, c)]++;
        }
        // 找出最大的 k
        int k = n;
        for (int s = papers[n]; k > s; s += papers[k]) {
            k--;
        }
        return k;
    }

    public int hIndex2(int[] citations) {
        Arrays.sort(citations);
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
    public int hIndex2_1(int[] citations) {
        Arrays.sort(citations);
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
        //left为满足citations[i] >= len - i 的左边界的索引
        return len - left;
    }

}
