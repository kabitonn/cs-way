package com.vika.way.pre.algorithm.leetcode.easy.S301_400;

import java.util.ArrayList;
import java.util.List;

public class S392IsSubsequence {

    public static void main(String[] args) {
        S392IsSubsequence solution=new S392IsSubsequence();
        System.out.println(solution.isSubsequence2("abb","ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() <= 0) {
            return true;
        }
        int preIndex = -1;
        for (char c : s.toCharArray()) {
            int index = t.indexOf(c, preIndex + 1);
            if (index == -1) {
                return false;
            }
            preIndex = index;
        }
        return true;
    }

    public boolean isSubsequence1(String s, String t) {
        if (s.length() <= 0) {
            return true;
        }
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                if (i == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    List<Integer>[] index = new List[26];

    public boolean isSubsequence2(String s, String t) {
        for (int i = 0; i < 26; i++) {
            index[i] = new ArrayList<>();
        }
        for (int i = 0; i < t.length(); i++) {
            index[t.charAt(i) - 'a'].add(i);
        }
        int preIndex = -1;
        for (char c : s.toCharArray()) {
            List<Integer> list = index[c - 'a'];
            int left = 0, right = list.size();
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (list.get(mid) <= preIndex) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == list.size()) {
                return false;
            }
            preIndex = list.get(left);
        }
        return true;
    }

}
