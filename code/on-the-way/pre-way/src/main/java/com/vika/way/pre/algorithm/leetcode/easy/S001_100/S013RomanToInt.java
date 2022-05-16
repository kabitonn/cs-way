package com.vika.way.pre.algorithm.leetcode.easy.S001_100;

import java.util.HashMap;
import java.util.Map;

public class S013RomanToInt {

    public static void main(String[] args) {
        S013RomanToInt solution = new S013RomanToInt();
        System.out.println(solution.romanToInt1("MCMXCIV"));
    }

    public int romanToInt1(String s) {
        int num = 0;
        int n = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                n = map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                n = map.get(s.substring(i, i + 1));
                i++;
            }
            num += n;
        }
        return num;
    }

    public int romanToInt(String s) {
        int num = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    n = 1000;
                    break;
                case 'D':
                    n = 500;
                    break;
                case 'C':
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'D') {
                            n = 400;
                            i++;
                        } else if (s.charAt(i + 1) == 'M') {
                            n = 900;
                            i++;
                        } else {
                            n = 100;
                        }
                    } else {
                        n = 100;
                    }

                    break;
                case 'L':
                    n = 50;
                    break;
                case 'X':
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'L') {
                            n = 40;
                            i++;
                        } else if (s.charAt(i + 1) == 'C') {
                            n = 90;
                            i++;
                        } else {
                            n = 10;
                        }
                    } else {
                        n = 10;
                    }

                    break;
                case 'V':
                    n = 5;
                    break;
                case 'I':
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'V') {
                            n = 4;
                            i++;
                        } else if (s.charAt(i + 1) == 'X') {
                            n = 9;
                            i++;
                        } else {
                            n = 1;
                        }
                    } else {
                        n = 1;
                    }
                    break;
                default:
                    break;
            }
            num += n;
        }
        return num;
    }

    public int romanToInt2(String s) {
        int sum = 0;
        if (s.contains("IV")) {
            sum -= 2;
        }
        if (s.contains("IX")) {
            sum -= 2;
        }
        if (s.contains("XL")) {
            sum -= 20;
        }
        if (s.contains("XC")) {
            sum -= 20;
        }
        if (s.contains("CD")) {
            sum -= 200;
        }
        if (s.contains("CM")) {
            sum -= 200;
        }
        char c[] = s.toCharArray();
        int count = 0;
        for (; count <= s.length() - 1; count++) {
            if (c[count] == 'M') {
                sum += 1000;
            }
            if (c[count] == 'D') {
                sum += 500;
            }
            if (c[count] == 'C') {
                sum += 100;
            }
            if (c[count] == 'L') {
                sum += 50;
            }
            if (c[count] == 'X') {
                sum += 10;
            }
            if (c[count] == 'V') {
                sum += 5;
            }
            if (c[count] == 'I') {
                sum += 1;
            }
        }
        return sum;
    }
}
