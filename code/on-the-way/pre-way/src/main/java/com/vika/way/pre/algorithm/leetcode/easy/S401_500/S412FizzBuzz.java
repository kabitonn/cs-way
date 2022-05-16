package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

import java.util.ArrayList;
import java.util.List;

public class S412FizzBuzz {

	public static void main(String[] args) {

	}
    public List<String> fizzBuzz(int n) {
    	List<String> list = new ArrayList<>();
    	for(int i=1;i<=n;i++) {
    		String str = "";
    		if(i%3==0) {str += "Fizz";}
    		if(i%5==0) {str += "Buzz";}
    		if(str.equals("")) {str += i;}
    		list.add(str);
    	}
    	return list;
    }
	public List<String> fizzBuzz1(int n) {
		List<String> list = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			String str = null;
			if(i%3==0&&i%5==0){str = "FizzBuzz";}
			else if(i%3==0){str = "Fizz";}
			else if(i%5==0){str = "Buzz";}
			else {str = String.valueOf(i);}
			list.add(str);
		}
		return list;
	}
}
