package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

public class S405NumbertoHex {

	public static void main(String[] args) {

	}
    public String toHex(int num) {
    	if(num==0) {return "0";}
    	char[] map = new char[] {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb =  new StringBuilder();
    	while(num!=0) {
        	int last = num&15;
        	sb.append(map[last]);
        	num>>>=4;
        }
    	return sb.reverse().toString();
    }
    public String toHex1(int num) {
    	if(num==0) {return "0";}
    	char[] map = new char[] {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String string = "";
    	while(num!=0) {
    		string = map[(num&0xf)]+string;
        	num>>>=4;
        }
    	return string;
    }
}
