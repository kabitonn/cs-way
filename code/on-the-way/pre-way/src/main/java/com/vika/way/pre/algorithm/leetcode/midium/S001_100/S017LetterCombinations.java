package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.*;

public class S017LetterCombinations {
	
	public static void main(String[] args) {
		S017LetterCombinations solution = new S017LetterCombinations();
		System.out.println(solution.letterCombinations2("23"));
	}
	private String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public List<String> letterCombinations1(String digits) {
    	LinkedList<String> list = new LinkedList<>();
        if(digits.length()==0) {
            return list;
        }
        list.add("");
        while(list.peek().length()!=digits.length()) {
        	String head = list.remove();
        	String s = mapping[digits.charAt(head.length())-'0'];
        	for( char c:s.toCharArray()) {
        		list.add(head+c);
        	}
        }
        return list;
    }
    public List<String> letterCombinations(String digits) {
    	
        List<String> list = new ArrayList<>();
        if(digits.length()==0) {
            return list;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        list.add("");
        for(char ch:digits.toCharArray()) {
        	String s = map.get(ch);
        	List<String> tmpList = new ArrayList<>();
        	for(char c:s.toCharArray()) {
        		for(String str:list) {
        			tmpList.add(str+c);
        		}
        	}
        	list = tmpList;
        }
        return list;
    }
    public List<String> letterCombinations2(String digits) {
    	List<String> list = new ArrayList<>();
    	if(digits.equals("")) {
            return list;
        }
    	combination(digits,"",list);
    	return list;
    }
    public void combination(String digits, String prefix, List<String> list) {
    	if(prefix.length()==digits.length()){
    		list.add(prefix);
    		return;
    	}
    	String s = mapping[digits.charAt(prefix.length())-'0'];
    	for(char c:s.toCharArray()){
    		combination(digits, prefix+c, list);
    	}
    }
}
