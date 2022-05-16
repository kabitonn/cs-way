package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.ArrayList;
import java.util.List;

public class S022GenerateParenthesis {

	public static void main(String[] args) {

	}
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        char[] str = new char[n*2];
        generate(str, 0, list);
        return list;
    }
    public void generate(char[] str,int index,List<String> list) {
    	if(index==str.length) {
    		if(isValid(str)) {
    			list.add(String.valueOf(str));
    		}
    	}
    	else {
			str[index]='(';
			generate(str, index+1, list);
			str[index]=')';
			generate(str, index+1, list);
		}
    }
    public boolean isValid(char[] str) {
    	int balance = 0;
    	for(char c:str) {
    		if(c=='(') {
    			balance++;
    		}
    		else {
    			balance--;
    			if(balance<0) {
                    return false;
                }
    		}
    	}
    	return balance==0?true:false;
    }
    public List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    public void backtrack(List<String> list,String str,int left,int right,int n) {
    	if(str.length()==n*2) {
    		list.add(str);
    		return;
    	}
    	if(left<n) {
    		backtrack(list, str+'(', left+1, right, n);
    	}
    	if(right<left) {
    		backtrack(list, str+')', left, right+1, n);
    	}
    }
    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>();
        char[] str = new char[n*2];
        generate2(list,str, 0,0,0, n);
        return list;
    }
    public void generate2(List<String> list,char[] str,Integer index,int left,int right,int n) {
    	if(index==n*2) {
    		list.add(String.valueOf(str));
    		return;
    	}
    	if(left<n) {
    		str[index] = '(';
    		generate2(list, str, index+1, left+1, right, n);
    	}
    	if(right<left) {
    		str[index] = ')';
    		generate2(list, str, index+1, left, right+1, n);
    	}
    }
    public List<String> generateParenthesis3(int n) {
        List<String> list = new ArrayList<>();
        if(n==0) {
        	list.add("");
        }
        for(int a=0;a<n;a++) {
        	for(String left:generateParenthesis3(a)) {
        		for(String right:generateParenthesis3(n-1-a)) {
        			list.add("("+left+")"+right);
        		}
        	}
        }
        return list;
    }
}

