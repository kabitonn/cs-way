package com.vika.way.pre.algorithm.leetcode.midium.S501_600;

public class S537ComplexNumberMultiplication {

    public String complexNumberMultiply(String a, String b) {
        int pos1 = a.indexOf('+');
        int pos2 = b.indexOf('+');
        int a1 = Integer.valueOf(a.substring(0, pos1));
        int b1 = Integer.valueOf(a.substring(pos1 + 1, a.length() - 1));
        int a2 = Integer.valueOf(b.substring(0, pos2));
        int b2 = Integer.valueOf(b.substring(pos2 + 1, b.length() - 1));
        int A = a1 * a2 - b1 * b2;
        int B = a1 * b2 + a2 * b1;
        return A + "+" + B + "i";
    }
}
