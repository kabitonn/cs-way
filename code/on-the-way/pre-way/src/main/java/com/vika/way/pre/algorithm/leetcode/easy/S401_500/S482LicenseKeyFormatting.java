package com.vika.way.pre.algorithm.leetcode.easy.S401_500;

public class S482LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '-') {
                continue;
            }
            if (len % K == 0 && len != 0) {
                sb.append('-');
            }
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] -= 32;
            }
            sb.append(chars[i]);
            len++;
        }
        return sb.reverse().toString();
    }

    public String licenseKeyFormatting1(String S, int K) {
        int count = 0;
        char[] chars = S.toCharArray();
        for (char ch : chars) {
            if (ch == '-') {
                count++;
            }
        }
        int len = chars.length - count;
        if (len == 0) {
            return "";
        }
        int num = len % K == 0 ? len / K - 1 : len / K;
        len += num;
        char[] str = new char[len];
        count = 0;
        int pos = len - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '-') {
                continue;
            }
            if (count % K == 0 && count != 0) {
                str[pos--] = '-';
            }
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] -= 32;
            }
            str[pos--] = chars[i];
            count++;
        }
        return new String(str);
    }

    public String licenseKeyFormatting2(String S, int K) {
        int count = 0;
        char[] chars = S.toCharArray();
        int len = chars.length * 2;
        char[] str = new char[len];
        int pos = len - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '-') {
                continue;
            }
            if (count % K == 0 && count != 0) {
                str[pos--] = '-';
            }
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] -= 32;
            }
            str[pos--] = chars[i];
            count++;
        }
        return new String(str, ++pos, len - pos);
    }

    public static void main(String[] args) {
        S482LicenseKeyFormatting solution = new S482LicenseKeyFormatting();
        String S = "";
        int K = 2;
        System.out.println(solution.licenseKeyFormatting2(S, K));
    }
}
