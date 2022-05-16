package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class S522LongestUncommonSubsequenceII {

    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int maxLen = -1;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                maxLen = Math.max(maxLen, strs[i].length());
            }
        }
        return maxLen;
    }

    public int findLUSlength1(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return strs[i].length();
            }
        }
        return -1;
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() <= 0) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
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

    public static void main(String[] args) {
        S522LongestUncommonSubsequenceII solution = new S522LongestUncommonSubsequenceII();
        String[] strs = {"", ""};
        System.out.println(solution.findLUSlength(strs));
        String s1 = "a1";
        try {
            printBytesLen(s1, "gbk");
            printBytesLen(s1, "utf-8");
            printBytesLen(s1, "unicode");
            printBytesLen(s1, "utf-16");
            printBytesLen(s1, "utf-16be");
            printBytesLen(s1, "utf-16le");
            printBytesLen(s1, "utf-32");
            printBytesLen(s1, "utf-32be");
            printBytesLen(s1, "utf-32le");
            printBytesLen("h", "utf-8");
            printBytesLen("h", "unicode");
            printBytesLen("h", "utf-16");
            printBytesLen("h", "utf-16be");
            printBytesLen("h", "utf-16le");
            printBytesLen("h", "utf-32");
            printBytesLen("h", "utf-32be");
            printBytesLen("h", "utf-32le");
        } catch (Exception e) {

        } finally {

        }
    }

    public static void printBytesLen(String string, String charset)
        throws UnsupportedEncodingException {
        byte[] bytes = string.getBytes(charset);
        System.out.println("[" + string + "]使用[" + charset + "]占用的字节长度:" + bytes.length + ";十六进制:" + bytesToHex(bytes));
    }

    //转16进制
    public static String bytesToHex(byte[] bytes) {
        return new BigInteger(1, bytes).toString(16);
    }
}
