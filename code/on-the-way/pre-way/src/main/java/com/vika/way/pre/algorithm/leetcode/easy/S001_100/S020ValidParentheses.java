package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

import java.util.Stack;

public class S020ValidParentheses {

	public static void main(String[] args) {

	}
	public boolean isValid1(String s) {
		Stack<Character> bracket = new Stack<>();
		for(char c:s.toCharArray()) {
			switch (c) {
			case '(':
			case '[':
			case '{':
				bracket.push(c);
				break;
			case ')':
				if(!bracket.empty()&&bracket.peek()=='(') {
					bracket.pop();
				}
				else {
					return false;
				}
				break;
			case ']':
				if(!bracket.empty()&&bracket.peek()=='[') {
					bracket.pop();
				}
				else {
					return false;
				}
				break;
			case '}':
				if(!bracket.empty()&&bracket.peek()=='{') {
					bracket.pop();
				}
				else {
					return false;
				}
				break;
			default:
				break;
			}
		}
		return bracket.empty();
	}
	public boolean isValid2(String s) {
        char[] stack = new char[s.length()];
        int p = 0;
        for(char c:s.toCharArray()) {
			switch (c) {
			case '(':
			case '[':
			case '{':
				stack[p++] = c;
				break;
			case ')':
				if(p!=0&&stack[p-1]=='(') {
					p--;
				}
				else {
					return false;
				}
				break;
			case ']':
				if(p!=0&&stack[p-1]=='[') {
					p--;
				}
				else {
					return false;
				}
				break;
			case '}':
				if(p!=0&&stack[p-1]=='{') {
					p--;
				}
				else {
					return false;
				}
				break;
			default:
				break;
			}
		}
        return p==0?true:false;
    }
	public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int p = 0;
        for(int i=0;i<s.length();i++) {
        	if(p==0) {
        		stack[p++]=s.charAt(i);
        	}
        	else if(isPair(stack[p-1],s.charAt(i))) {
        		p--;
        	}
        	else if(!isPair(stack[p-1],s.charAt(i))) {
        		stack[p++]=s.charAt(i);
			}
        }
        return p==0?true:false;
    }
	public boolean isPair(char a,char b) {
		boolean isPair = false;
		switch (b) {
		case ')':
			if(a=='(') {
				isPair = true;
			}
			else {
				isPair = false;
			}
			break;
		case ']':
			if(a=='[') {
				isPair = true;
			}
			else {
				isPair = false;
			}
			break;
		case '}':
			if(a=='{') {
				isPair = true;
			}
			else {
				isPair = false;
			}
			break;
		default:
			break;
		}
		return isPair;
	}
}
