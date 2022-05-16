package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S395LongestSubstringWithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        S395LongestSubstringWithAtLeastKRepeatingCharacters solution = new S395LongestSubstringWithAtLeastKRepeatingCharacters();
        System.out.println(solution.longestSubstring1("aaabb", 2));
    }

    public int longestSubstring(String s, int k) {
        if (k < 2) {
            return s.length();
        }
        int n = s.length();
        char[] chs = s.toCharArray();
        for (int len = n; len >= k; len--) {
            int[] nums = new int[26];
            int i = 0, j = 0;
            while (j <= n && i <= n - len) {
                int l = j - i;
                if (l < len) {
                    nums[chs[j++] - 'a']++;
                } else if (l == len) {
                    boolean flag = true;
                    for (int num : nums) {
                        if (num != 0 && num < k) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        return len;
                    }
                    nums[chs[i++] - 'a']--;
                }
            }
        }
        return 0;
    }

    public int longestSubstring0(String s, int k) {
        int max = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (valid(s.substring(i, j), k)) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }

    public boolean valid(String s, int k) {
        int[] nums = new int[26];
        for (char c : s.toCharArray()) {
            nums[c - 'a']++;
        }
        for (int num : nums) {
            if (num != 0 && num < k) {
                return false;
            }
        }
        return true;
    }

    public int longestSubstring1(String s, int k) {
        if (k < 2) {
            return s.length();
        }
        int n = s.length();
        if (k > n) {
            return 0;
        }
        return count(s.toCharArray(), 0, n - 1, k);
    }

    public int count(char[] chars, int left, int right, int k) {
        int[] nums = new int[26];
        for (int i = left; i <= right; i++) {
            nums[chars[i] - 'a']++;
        }
        while (right - left + 1 >= k && nums[chars[left] - 'a'] < k) {
            left++;
        }
        while (right - left + 1 >= k && nums[chars[right] - 'a'] < k) {
            right--;
        }
        if (right - left + 1 < k) {
            return 0;
        }
        int i = left;
        for (; i <= right; i++) {
            if (nums[chars[i] - 'a'] < k) {
                break;
            }
        }
        if (i <= right) {
            return Math.max(count(chars, left, i - 1, k), count(chars, i + 1, right, k));
        }
        return right - left + 1;
    }
}
