package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

public class S481MagicalString {
    public int magicalString(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n < 4) {
            return 1;
        }
        char[] chars = new char[n];
        int count = 1;
        chars[0] = '1';
        chars[1] = '2';
        chars[2] = '2';
        int i = 3, j = 2;
        while (i < n) {
            if (chars[j] == '1') {
                if (chars[i - 1] == '1') {
                    chars[i++] = '2';
                } else {
                    chars[i++] = '1';
                    count++;
                }
            } else if (chars[j] == '2') {
                if (chars[i - 1] == '1') {
                    chars[i++] = '2';
                    if (i < n) {
                        chars[i++] = '2';
                    }
                } else {
                    chars[i++] = '1';
                    count++;
                    if (i < n) {
                        chars[i++] = '1';
                        count++;
                    }
                }
            }
            j++;
        }
        return count;
    }

    public int magicalString1(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] chars = new int[n];
        chars[0] = 1;
        int i = 1, j = 1;
        int count = 1, num = 2, c = 2;
        while (i < n) {
            if (num > 0) {
                chars[i++] = c;
                num--;
            }
            if (c == 1) {
                count++;
            }
            if (num == 0) {
                num = chars[++j];
                c = c == 2 ? 1 : 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        S481MagicalString solution = new S481MagicalString();
        System.out.println(solution.magicalString1(3));
    }
}
