package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.HashSet;
import java.util.Set;

public class S467UniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < p.length(); i++) {
            for (int j = i + 1; j <= p.length(); j++) {
                String str = p.substring(i, j);
                if (containsString(str)) {
                    set.add(str);
                }
            }
        }
        return set.size();
    }

    public boolean containsString(String t) {
        if (t.length() == 1) {
            return true;
        }
        for (int i = 1; i < t.length(); i++) {
            if (t.charAt(i) != t.charAt(i - 1) + 1 && t.charAt(i - 1) - t.charAt(i) != 25) {
                return false;
            }
        }
        return true;
    }

    public int findSubstringInWraproundString1(String p) {
        Set<String> set = new HashSet<>();
        int[] dp = new int[p.length()];
        for (int i = 0; i < p.length(); i++) {
            dp[i] = 1;
            if (i > 0 && isAdjacent(p.charAt(i), p.charAt(i - 1))) {
                dp[i] += dp[i - 1];
            }
            for (int j = 0; j < dp[i]; j++) {
                set.add(p.substring(i - j, i + 1));
            }
        }
        return set.size();
    }

    public boolean isAdjacent(char a, char b) {
        return a - b == 1 || b - a == 25;
    }

    public int findSubstringInWraproundString2(String p) {
        char[] chars = p.toCharArray();
        int[] count = new int[26];
        int dp = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && (chars[i] - chars[i - 1] == 1 || chars[i - 1] - chars[i] == 25)) {
                dp++;
            } else {
                dp = 1;
            }
            count[chars[i] - 'a'] = Math.max(count[chars[i] - 'a'], dp);
        }
        int sum = 0;
        for (int num : count) {
            sum += num;
        }
        return sum;
        //return Arrays.stream(count).sumArea();
    }

}
