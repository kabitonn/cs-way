package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class S459RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }


    Pattern pattern = Pattern.compile("(\\w+)\\1+");

    public boolean repeatedSubstringPattern0(String s) {
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
        //return s.matches("(\\w+)\\1+");
    }


    public boolean repeatedSubstringPattern1(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i != 0) {
                continue;
            }
            String substr = s.substring(0, i);
            int index = i;
            while (index < n) {
                if (index == s.indexOf(substr, index)) {
                    index += i;
                } else {
                    break;
                }
            }
            if (index == n) {
                return true;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        int[] next = new int[n + 1];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < n) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next[n] != 0 && n % (n - next[n]) == 0;
    }

    public static void main(String[] args) {
        S459RepeatedSubstringPattern solution = new S459RepeatedSubstringPattern();
        System.out.println(solution.repeatedSubstringPattern1("aba"));
    }

}
