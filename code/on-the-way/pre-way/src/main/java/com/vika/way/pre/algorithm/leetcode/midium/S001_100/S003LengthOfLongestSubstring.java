package com.vika.way.pre.algorithm.leetcode.midium.S001_100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class S003LengthOfLongestSubstring {

	public static void main(String[] args) {
		S003LengthOfLongestSubstring solution3 = new S003LengthOfLongestSubstring();
		System.out.println(solution3.lengthOfLongestSubstring1("abcabcbb"));

	}
	public int lengthOfLongestSubstring(String s) {
		if(s.length()==0) {
			return 0;
		}
		int maxNum = 1;
		char[] str = s.toCharArray();
		for(int i=0;i<str.length;i++) {
			p:for(int j=i+1;j<str.length;j++) {
				for(int k=0;k<j-i;k++) {
					if(str[j]==str[i+k]) {
						break p;
					}
				}
				if(j-i+1>maxNum) {
					maxNum = j-i+1;
				}
			}
		}
		return maxNum;
        
    }
	public int lengthOfLongestSubstring1(String s) {
		int maxNum = 0;
		char[] str = s.toCharArray();
		for(int i=0;i<str.length;i++) {
			maxNum = Math.max(maxNum,1);
			p:for(int j=i+1;j<str.length;j++) {
				int k=0;
				for(;k<j-i;k++) {
					if(str[j]==str[i+k]) {
						break p;
					}
				}
				maxNum = Math.max(maxNum,j-i+1);
			}
		}
		return maxNum;
        
    }
	public int lengthOfLongestSubstring2(String s) {
		int maxNum = 0;
		Set<Character> set = new HashSet<>();
		char[] str = s.toCharArray();
		int n = str.length;
		for(int i=0;i<n;i++) {
			set.add(str[i]);
			for(int j=i+1;j<n;j++) {
				if(!set.contains(str[j])) {
					set.add(str[j]);
				}
				else {
					break;
				}
			}
			maxNum = Math.max(maxNum,set.size());
			set.clear();
		}
		return maxNum;
        
    }
	/**
	 * 通过使用 HashSet 作为滑动窗口，我们可以用 O(1)O(1) 的时间来完成对字符是否在当前的子字符串中的检查。

滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，
即 [i, j)[i,j)（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i, j)[i,j) 
向右滑动 11 个元素，则它将变为 [i+1, j+1)[i+1,j+1)（左闭，右开）。

回到我们的问题，我们使用 HashSet 将字符存储在当前窗口 [i, j)[i,j)（最初 j = ij=i）中。 然后我们向右侧滑动索引
 jj，如果它不在 HashSet 中，我们会继续滑动 jj。直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的
 最长子字符串将会以索引 ii 开头。如果我们对所有的 ii 这样做，就可以得到答案。

	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring03(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxNum = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                maxNum = Math.max(maxNum, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return maxNum;
    }
	/**
	 * 上述的方法最多需要执行 2n 个步骤。事实上，它可以被进一步优化为仅需要 n 个步骤。我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。
	 *  当我们找到重复的字符时，我们可以立即跳过该窗口。

	也就是说，如果 s[j]s[j] 在 [i, j)[i,j) 范围内有与 j
  重复的字符，我们不需要逐渐增加 i 。 我们可以直接跳过 [i，j] 范围内的所有元素，并将 i 变为 j' + 1
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring4(String s) {
        int n = s.length();
        int maxNum = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0,j=0;j<n;j++) {
        	char c = s.charAt(j);
        	if(map.containsKey(c)) {
        		i = Math.max(map.get(c),i);
        	}
        	maxNum = Math.max(maxNum, j-i+1);
        	map.put(c, j+1);	//i=j'+1
        }
        
        return maxNum;
    }

	public int lengthOfLongestSubstring5(String s) {
		int n = s.length(), maxNum = 0;
		int[] map = new int[128];
		for (int j = 0, i = 0; j < n; j++) {
			i = Math.max(map[s.charAt(j)], i);
			maxNum = Math.max(maxNum, j - i + 1);
			map[s.charAt(j)] = j + 1;	//i=j'+1
		}
		return maxNum;
	}

}
