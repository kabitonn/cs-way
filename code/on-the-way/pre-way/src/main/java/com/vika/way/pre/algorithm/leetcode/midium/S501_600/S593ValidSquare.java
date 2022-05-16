package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.util.Arrays;

public class S593ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] edge = new int[6];
        int count = 0;
        edge[count++] = getDistance(p1, p2);
        edge[count++] = getDistance(p1, p3);
        edge[count++] = getDistance(p1, p4);
        edge[count++] = getDistance(p2, p3);
        edge[count++] = getDistance(p2, p4);
        edge[count++] = getDistance(p3, p4);
        Arrays.sort(edge);
        if (edge[0] != 0 && edge[0] == edge[1] && edge[0] == edge[2] && edge[0] == edge[3]) {
            if (edge[4] == edge[5]) {
                return true;
            }
        }
        return false;
    }

    public int getDistance(int[] p1, int[] p2) {
        int dx = p2[0] - p1[0];
        int dy = p2[1] - p1[1];
        return dx * dx + dy * dy;
    }

    public boolean validSquare1(int[] p1, int[] p2, int[] p3, int[] p4) {
        int p12 = getDistance(p1, p2);
        int p13 = getDistance(p1, p3);
        int p14 = getDistance(p1, p4);
        int p23 = getDistance(p2, p3);
        int p24 = getDistance(p2, p4);
        int p34 = getDistance(p3, p4);
        if (p12 == 0 || p13 == 0 || p14 == 0 || p23 == 0 || p24 == 0 || p34 == 0) {
            return false;
        }
        if ((p12 == p34 && p13 == p14 && p13 == p23 && p13 == p24) ||
            (p13 == p24 && p12 == p14 && p12 == p23 && p12 == p34) ||
            (p14 == p23 && p12 == p13 && p12 == p24 && p12 == p34)) {
            return true;
        }
        return false;
    }


    // 待完善，检验对角线，仍需判断对角线相交
    public boolean validSquare2(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] p12 = getDiff(p1, p2);
        int[] p13 = getDiff(p1, p3);
        int[] p14 = getDiff(p1, p4);
        int[] p23 = getDiff(p2, p3);
        int[] p24 = getDiff(p2, p4);
        int[] p34 = getDiff(p3, p4);
        if (valid(p12, p34) || valid(p13, p24) || valid(p14, p23)) {
            return true;
        }
        return false;
    }

    public boolean valid(int[] d1, int[] d2) {
        boolean edge = d1[2] > 0 && d1[2] == d2[2];
        boolean vertical = (d1[0] * d2[0] + d1[1] * d2[1]) == 0;
        return edge && vertical;
    }

    public int[] getDiff(int[] p1, int[] p2) {
        int dx = p2[0] - p1[0];
        int dy = p2[1] - p1[1];
        return new int[]{dx, dy, dx * dx + dy * dy};
    }

    public static void main(String[] args) {
        S593ValidSquare solution = new S593ValidSquare();
        /*
        int[] p1 = {1, 0};
        int[] p2 = {-1, 0};
        int[] p3 = {0, 1};
        int[] p4 = {0, -1};
         */
        int[] p1 = {0, 1};
        int[] p2 = {1, 2};
        int[] p3 = {0, 2};
        int[] p4 = {0, 0};
        System.out.println(solution.validSquare1(p1, p2, p3, p4));
    }

}

