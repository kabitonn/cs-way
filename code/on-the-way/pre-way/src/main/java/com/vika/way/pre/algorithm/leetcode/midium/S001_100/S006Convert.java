package com.vika.way.pre.algorithm.leetcode.midium.S001_100;


public class S006Convert {

    public static void main(String[] args) {
        S006Convert solution = new S006Convert();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(solution.convert1(s, numRows));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int asc = -1;
        int curRow = 0;
        for (int i = 0; i < len; i++) {
            rows[curRow].append(s.charAt(i));
            if (curRow == 0 || curRow == numRows - 1) {
                asc = -asc;
            }
            curRow += asc;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            stringBuilder.append(rows[i].toString());
        }
        return stringBuilder.toString();
    }

    public String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        int cycle = 2 * numRows - 2;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < len; j += cycle) {
                stringBuilder.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycle - i < len) {
                    stringBuilder.append(s.charAt(j + cycle - i));
                }
            }
        }
        return stringBuilder.toString();
    }
}
