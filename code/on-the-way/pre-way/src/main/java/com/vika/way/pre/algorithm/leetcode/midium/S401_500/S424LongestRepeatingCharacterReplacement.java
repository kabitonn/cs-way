package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

public class S424LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        S424LongestRepeatingCharacterReplacement solution = new S424LongestRepeatingCharacterReplacement();
        System.out.println(solution.characterReplacement1("AABBB", 2));
    }

    public int characterReplacement0(String s, int k) {
        return Math.max(characterReplacement0_1(s, k), characterReplacement0_2(s, k));
    }

    public int characterReplacement0_1(String s, int k) {
        int max = 0;
        int i = 0, j = 1;
        int n = s.length();
        int replaceNum = 0, replaceIndex = -1;
        while (j < n) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            } else if (replaceNum < k) {
                if (replaceNum == 0) {
                    replaceIndex = j;
                }
                j++;
                replaceNum++;
            } else {
                max = Math.max(max, j - i);
                replaceNum = 0;
                i = replaceIndex != -1 ? replaceIndex : j;
                j = i + 1;
            }
        }
        max = Math.max(max, n - i);
        return max;
    }

    public int characterReplacement0_2(String s, int k) {
        int max = 0;
        int i = 0, j = 1;
        int n = s.length();
        int replaceNum = 0, replaceIndex = -1;
        int base = i;
        while (j < n) {
            if (s.charAt(j) == s.charAt(base)) {
                j++;
            } else if (replaceNum < k) {
                if (replaceNum == 0) {
                    replaceIndex = j;
                    base = j;
                    replaceNum += j - i - 1;
                }
                j++;
                replaceNum++;
            } else {
                max = Math.max(max, j - i);
                replaceNum = 0;
                i = replaceIndex != -1 ? replaceIndex : j;
                base = i;
                j = i + 1;
            }
        }
        max = Math.max(max, n - i);
        return max;
    }

    public int characterReplacement(String s, int k) {
        int max = 0;
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n - max; i++) {
            int replaceNum = 0, len = 1;
            for (int j = i + 1; j < n; j++) {
                if (chars[j] == chars[i]) {
                    len++;
                } else if (replaceNum < k) {
                    replaceNum++;
                    len++;
                } else {
                    break;
                }
            }
            if (replaceNum < k) {
                len += i > k - replaceNum ? k - replaceNum : i;
            }
            max = Math.max(max, len);
        }
        return max;
    }

    public int characterReplacement1(String s, int k) {
        int max = 0;
        int i = 0, j = 1;
        int n = s.length();
        int replaceNum = 0, replaceIndex = -1;
        while (j < n) {
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            } else if (replaceNum < k) {
                if (replaceNum == 0) {
                    replaceIndex = j;
                }
                replaceNum++;
                j++;
            } else {
                max = Math.max(max, j - i);
                replaceNum = 0;
                i = replaceIndex != -1 ? replaceIndex : j;
                j = i + 1;
            }
        }
        if (replaceNum < k) {
            if (i > k - replaceNum) {
                i -= k - replaceNum;
            } else {
                i = 0;
            }
        }
        max = Math.max(max, n - i);
        return max;
    }

    public int characterReplacement2(String s, int k) {
        int max = 0;
        int[] count = new int[26];
        int n = s.length();
        char[] chars = s.toCharArray();
        int i = 0, maxCount = 0;
        for (int j = 0; j < n; j++) {
            int index = chars[j] - 'A';
            count[index]++;
            maxCount = Math.max(maxCount, count[index]);
            if (j - i + 1 - maxCount > k) {
                count[chars[i++] - 'A']--;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }


}
