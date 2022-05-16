package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S119GetTriangleRow {

    public static void main(String[] args) {
        S119GetTriangleRow solution = new S119GetTriangleRow();
        System.out.println(solution.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return new ArrayList<>(Arrays.asList(1));
        }
        //if(rowIndex==1) {return new ArrayList<>(Arrays.asList(1,1));}
        List<Integer> row = null;
        List<Integer> preLine = new ArrayList<>(Arrays.asList(1));
        for (int i = 1; i <= rowIndex; i++) {
            row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(preLine.get(j - 1) + preLine.get(j));
            }
            row.add(1);
            preLine = row;
        }
        return row;
    }

    public List<Integer> getRow0(int rowIndex) {
        if (rowIndex == 0) {
            return new ArrayList<>(Arrays.asList(1));
        }
        Integer[] line = new Integer[rowIndex + 1];
        line[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            int pre = line[0];
            for (int j = 1; j < i; j++) {
                int tmp = line[j];
                line[j] = line[j] + pre;
                pre = tmp;
            }
            line[i] = 1;
        }
        return new ArrayList<>(Arrays.asList(line));
    }

    public List<Integer> getRow1(int rowIndex) {
        if (rowIndex == 0) {
            return new ArrayList<>(Arrays.asList(1));
        }
        Integer[] line = new Integer[rowIndex + 1];
        line[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                line[j] = line[j] + line[j - 1];
            }
            line[i] = 1;
        }
        List<Integer> row = new ArrayList<>(Arrays.asList(line));
        return row;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        int N = rowIndex;
        long pre = 1;
        row.add(1);
        for (int k = 1; k <= N; k++) {
            long cur = pre * (N - k + 1) / k;
            row.add((int) cur);
            pre = cur;
        }
        return row;
    }
}
