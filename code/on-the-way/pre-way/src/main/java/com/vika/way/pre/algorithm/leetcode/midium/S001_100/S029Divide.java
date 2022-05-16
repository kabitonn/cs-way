package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

public class S029Divide {

	public static void main(String[] args) {
		S029Divide solution = new S029Divide();
		System.out.println(solution.divide1(Integer.MIN_VALUE, Integer.MIN_VALUE));

	}
	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		// 全部记录为负数，统一符号，同时避免最大负数转为正数时会溢出的问题
		int negativetiveDividend = dividend > 0 ? 0 - dividend : dividend;
		int negativeDivisor = divisor > 0 ? 0 - divisor : divisor;
		// 记录位运算左移次数
		int leftTime = 0;
		int result = 0;
		// 记录最小整数右移一位的结果
		int maxRight1 = Integer.MIN_VALUE >> 1;
		if (dividend == 0 || negativetiveDividend - negativeDivisor > 0) {
            return 0;
        }
		while (negativetiveDividend - negativeDivisor < 0) {
			// 如果除数小于最小整数右移一位，说明不能再左移了，跳出循环
			if (negativeDivisor < maxRight1 || negativetiveDividend - (negativeDivisor << 1) > 0) {
                break;
            }
			negativeDivisor = negativeDivisor << 1;
			leftTime ++;
		}
		// 递归
		result = (1 << leftTime) 
				+ divide(negativetiveDividend - negativeDivisor, divisor > 0 ? 0 - divisor : divisor);
		if ((dividend^divisor)<0) {
			result = 0 - result;
		}
		return result;
	}
	public int divide1(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		// 全部记录为负数，统一符号，同时避免最大负数转为正数时会溢出的问题
		int negativetiveDividend = dividend > 0 ? 0 - dividend : dividend;
		int negativeDivisor = divisor > 0 ? 0 - divisor : divisor;
		boolean negative= (dividend^ divisor)<0;
		if (dividend == 0 || negativetiveDividend - negativeDivisor > 0) {
            return 0;
        }
		int res = 0;
		int leftTime = 0;
		// 记录最小整数右移一位的结果
		int maxRight1 = Integer.MIN_VALUE >> 1;
		int curNegativetiveDividend = negativetiveDividend;
		int curNegativeDivisor = negativeDivisor;
		while (curNegativetiveDividend - curNegativeDivisor <= 0 && curNegativetiveDividend!=0) {
			curNegativetiveDividend -= curNegativeDivisor;
			res += (1<<leftTime);
			
			if (curNegativeDivisor < maxRight1 || curNegativetiveDividend - (curNegativeDivisor << 1) > 0) {
				curNegativeDivisor = negativeDivisor;
				leftTime = 0;
				continue;
			}
			curNegativeDivisor <<=1;
			leftTime ++;
		}
		return res = negative?-res:res;
	}
}
