package com.vika.way.pre.algorithm.leetcode.easy.S201_300;

import java.util.HashMap;
import java.util.Map;

public class S290WordPattern {

	public static void main(String[] args) {

	}
    public boolean wordPattern(String pattern, String str) {
    	Map<String, Character> map = new HashMap<>();
        String[] strs = str.split(" ");
        char[] ps = pattern.toCharArray();
        if(strs.length!=ps.length) {return false;}
        for(int i=0;i<strs.length;i++) {
        	if(!map.containsKey(strs[i])) {
        		if(map.containsValue(ps[i])) {return false;}
        		map.put(strs[i], ps[i]);
        	}
        	else {
				if(map.get(strs[i])!=ps[i]) {return false;}
			}
        }
        
        return true;
    }
}
