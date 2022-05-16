package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

public class S014LongestCommonPrefix {

	public static void main(String[] args) {
		S014LongestCommonPrefix solution =  new S014LongestCommonPrefix();
		String[] strs = {"aca","cba"};
		System.out.println(solution.longestCommonPrefix1(strs));
	}
    public String longestCommonPrefix(String[] strs) {
    	StringBuilder sb = new  StringBuilder();
    	int min = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++) {
        	if (strs[i].length()<min) {
				min = strs[i].length();
			}
        }
        if(min == Integer.MAX_VALUE) {
			min=0;
		}
        boolean is = true;
        char c;
        for(int i=0;i<min;i++) {
        	is = true;
        	c = strs[0].charAt(i);
        	for(int j=1;j<strs.length;j++) {
        		if(strs[j].charAt(i)!=c) {
        			is = false;
        			break;
        		}
        	}
        	if(is) {
        		sb.append(c);
        	}
        	else {
				break;
			}
        }
        String string = sb.toString();
        return string;
    }
    private String longestCommonPrefix1(String[] strs) {
    	if(strs == null ||strs.length == 0) {
			return "";
		}
    	int min = Integer.MAX_VALUE;
    	for (String str : strs) {
			min = Math.min(min, str.length());
		}
        char c;
        int i=0;
        for(;i<min;i++) {
        	c = strs[0].charAt(i);
        	for(int j=1;j<strs.length;j++) {
        		if(strs[j].charAt(i)!=c) {
        			return strs[0].substring(0, i);
        		}
        	}
        }
        return strs[0].substring(0, i);
    }
    public String longestCommonPrefix2(String[] strs) {
    	if(strs == null ||strs.length == 0) {
			return "";
		}
    	String prefix = strs[0];
    	for(int i=1;i<strs.length;i++) {
    		while(strs[i].indexOf(prefix)!=0) {
    			prefix=prefix.substring(0, prefix.length()-1);
    			if(prefix.length()==0) {
					return "";
				}
    		}
    	}
    	return prefix;
	}
    public String longestCommonPrefix3(String[] strs) {
    	if(strs == null ||strs.length == 0) {
			return "";
		}
        char c;
        for(int i=0;i<strs[0].length();i++) {
        	c = strs[0].charAt(i);
        	for(int j=1;j<strs.length;j++) {
        		if(strs[j].length()<=i||strs[j].charAt(i)!=c) {
        			return strs[0].substring(0, i);
        		}
        	}
        }
        return strs[0];
    }
    public String longestCommonPrefix4(String[] strs) {
    	if(strs == null ||strs.length == 0) {
			return "";
		}
        return longestCommonPrefix(strs,0,strs.length-1);
    }
    public String longestCommonPrefix(String[] strs, int left, int right) {
    	if(left == right) {
			return strs[left];
		}
    	int mid = (left+right)/2;
    	String lcpleft = longestCommonPrefix(strs, left, mid);
    	String lcpright = longestCommonPrefix(strs, mid+1, right);
    	String lcp = commonPrefix(lcpleft,  lcpright);
    	return lcp;
    }
    public String commonPrefix(String leftStr, String rightStr) {
    	int min = Math.min(leftStr.length(), rightStr.length());
    	for(int i=0;i<min;i++) {
    		if(leftStr.charAt(i)!=rightStr.charAt(i)) {
    			return leftStr.substring(0, i);
    		}
    	}
		return leftStr.substring(0,min);
	}
}
