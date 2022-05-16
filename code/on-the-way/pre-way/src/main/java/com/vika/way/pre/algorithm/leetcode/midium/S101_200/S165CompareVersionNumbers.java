package com.vika.way.pre.algorithm.leetcode.midium.S101_200;

public class S165CompareVersionNumbers {
    public static void main(String[] args) {
        S165CompareVersionNumbers solution = new S165CompareVersionNumbers();
        System.out.println(solution.compareVersion("0.1", "1.1"));
    }

    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int n1 = strs1.length, n2 = strs2.length;
        int n = n1 > n2 ? n1 : n2;
        for (int i = 0; i < n; i++) {
            int v1 = i < n1 ? Integer.valueOf(strs1[i]) : 0;
            int v2 = i < n2 ? Integer.valueOf(strs2[i]) : 0;
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }
}
