package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

public class S012IntToRoman {

	public static void main(String[] args) {
		S012IntToRoman solution = new S012IntToRoman();
		System.out.println(solution.intToRoman2(1994));
		
	}
    public String intToRoman(int num) {
    	StringBuilder sb = new StringBuilder();
    	while(num>=1000) {
    		sb.append("M");
    		num-=1000;
    	}
    	while(num>=900) {
    		sb.append("CM");
    		num-=900;
    	}
    	while(num>=500) {
    		sb.append("D");
    		num-=500;
    	}
    	while(num>=400) {
    		sb.append("CD");
    		num-=400;
    	}
    	while(num>=100) {
    		sb.append("C");
    		num-=100;
    	}
    	while(num>=90) {
    		sb.append("XC");
    		num-=90;
    	}
    	while(num>=50) {
    		sb.append("L");
    		num-=50;
    	}
    	while(num>=40) {
    		sb.append("XL");
    		num-=40;
    	}
    	while(num>=10) {
    		sb.append("X");
    		num-=10;
    	}
    	while(num>=9) {
    		sb.append("IX");
    		num-=9;
    	}
    	while(num>=5) {
    		sb.append("V");
    		num-=5;
    	}
    	while(num>=4) {
    		sb.append("IV");
    		num-=4;
    	}
    	while(num>=1) {
    		sb.append("I");
    		num-=1;
    	}
        return sb.toString();
    }
    public String intToRoman1(int num) {
    	StringBuilder sb = new StringBuilder();
    	int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    	String[] strings = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    	for(int i=0;i<values.length;i++) {
    		while(num>=values[i]) {
    			sb.append(strings[i]);
    			num-=values[i];
    		}
    		
    	}
        return sb.toString();
    }
    public String intToRoman2(int num) {
        String M[] = {"", "M", "MM", "MMM"};//0,1000,2000,3000
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};//0,100,200,300...
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};//0,10,20,30...
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};//0,1,2,3...
        return M[num/1000] + C[(num%1000)/100]+ X[(num%100)/10] + I[num%10];
    }
}
