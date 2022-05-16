package com.vika.way.pre.algorithm.alg.company;

import java.util.Scanner;

public class CheckString {

    public String checkString(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }
        char[] str = new char[n];
        char[] chars = s.toCharArray();
        str[0] = chars[0];
        int a = 0, b = 1;
        int k = 1;
        for (int i = 1; i < n; i++) {
            if (chars[i] == chars[i - 1]) {
                b++;
                if (a == 2) {
                    if (b == 2) {
                        b = 1;
                        continue;
                    }
                } else if (b == 3) {
                    b = 2;
                    continue;
                }
            } else {
                a = b;
                b = 1;
            }
            str[k++] = chars[i];
        }
        return new String(str, 0, k);
    }

    public static void main(String[] args) {
        CheckString checkString = new CheckString();
        System.out.println(checkString.checkString("AABBCCCCCDDDD"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            System.out.println(checkString.checkString(s));
        }
    }
}
