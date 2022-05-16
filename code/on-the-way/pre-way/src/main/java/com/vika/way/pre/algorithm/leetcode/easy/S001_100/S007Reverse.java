package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

public class S007Reverse {

	public static void main(String[] args) {
		S007Reverse solution = new S007Reverse();
		System.out.println(solution.reverse(2147483647));
	}
	public int reverse(int x) {
        long reverse = 0;
        while(x!=0) {
        	reverse = reverse*10+x%10;
        	x/=10;
        }
        if(reverse < Integer.MIN_VALUE||reverse > Integer.MAX_VALUE) {
        	return 0;
        }
        return (int)reverse;
        
    }
	
	public int reverse1(int x) {
        int reverse = 0;
        while(x!=0) {
        	if (reverse > Integer.MAX_VALUE/10 ) {
                return 0;
            }
            if (reverse < Integer.MIN_VALUE/10 ) {
                return 0;
            }
        	reverse = reverse*10+x%10;
        	x/=10;
        }
        return reverse;
        
    }
	

}
