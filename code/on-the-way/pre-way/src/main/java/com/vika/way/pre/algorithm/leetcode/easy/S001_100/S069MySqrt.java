package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

public class S069MySqrt {

	public static void main(String[] args) {
		S069MySqrt solution = new S069MySqrt();
		System.out.println(solution.mySqrt1(2));
		System.out.println(Math.sqrt(2147483647));
	}
    public int mySqrt(int x) {
    	for(int i=1;i<=x/2+1;i++) {
    		if(i==x/i) {return i;}
    		else if(i>x/i) {return i-1;}
    	}
    	return 0;
        //return (int)Math.sqrt(x);
    }
    public int mySqrt2(int x) {
        long a = x;
        while (a * a > x) {
            a = (a + x / a) / 2;
        }
        return (int) a;
    }

    public int mySqrt1(int x) {
    	if(x==0) {return 0;}
    	int left = 1;
    	int right = x/2+1;
    	//int res = 0;
    	while(left<=right) {
    		int mid = left+(right-left)/2;
    		if(mid == x/mid) {return mid;}
    		else if(mid > x/mid) {right = mid-1;}
    		else {
				//res = mid;
				left = mid+1;
    		}
    	}
    	return right;
        //return (int)Math.sqrt(x);
    }
	public int mySqrt3(int x) {
		if(x==0) {return 0;}
		int left = 1;
		int right = x/2+1;
		while(left<right){
			int mid = left + (right-left + 1)/2;
			if(mid > x / mid){	right = mid - 1;}
			else  if(mid <= x/mid){	left = mid;}
		}
		return left;
	}

}
