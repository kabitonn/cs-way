package com.vika.way.pre.algorithm.leetcode.easy.S101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S118GenerateTriangle {
	public static void main(String[] args) {
		S118GenerateTriangle solution = new S118GenerateTriangle();
		System.out.println(solution.generate(5));
	}
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if(numRows == 0) {return lists;}
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        lists.add(firstLine);
        for(int i=1;i<numRows;i++) {
        	List<Integer> preLine = lists.get(i-1);
        	List<Integer> line = new ArrayList<>();
        	line.add(1);
        	for(int j=1;j<i;j++) {
        		line.add(preLine.get(j-1)+preLine.get(j));
        	}
        	line.add(1);
        	lists.add(line);
        }
        return lists;
    }
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if(numRows == 0) {return lists;}
        lists.add(Arrays.asList(1));
        for(int i=1;i<numRows;i++) {
        	List<Integer> preLine = lists.get(i-1);
        	Integer[] line = new Integer[i+1];
        	line[0] = 1;
        	line[line.length-1] = 1;
        	for(int j=1;j<i;j++) {
        		line[j] = preLine.get(j-1)+preLine.get(j);
        	}
        	lists.add(new ArrayList<>(Arrays.asList(line)));
        }
        return lists;
    }
}
