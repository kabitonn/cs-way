package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import java.util.HashSet;
import java.util.Set;

public class S318MaximumProductOfWordLengths {

    public static void main(String[] args) {
        S318MaximumProductOfWordLengths solution = new S318MaximumProductOfWordLengths();
        String[] words = {"cdbbfebebafbefc", "ecbeaeddcce", "aefeeddafccaedafddd", "cbe", "ececca", "adcfdbdffcebfedadcb", "edbfadcecbebfee", "eabcb", "bdfedaedbaeacf", "faabafbbbefdea", "deccfdffacbebdefbfa", "ffdf", "fdbeabbec", "cbcfeedaf", "ecdbfdebbebffbbbb", "ebee", "cfcdcbcfdacbdaaebfef", "dafabedfa", "babbdfcc", "eadeafdbcdbbaefbbbbdc", "faabad", "eeeaecdbbacbedbaeabd", "acfa", "eaaafeb", "acef", "dccaccfffedaabefccead", "bacdbfe", "fdfdafaa", "bacecdff", "cfadccadfdabbdcdaec", "acbdfffdbcdfffbdbec", "afbcfefc", "facaacffccecfff", "af", "aedcddabdddfdeafabfd", "fafbfeacffbbbceebaedc", "aabbbabddcadadda", "eccca", "fcafbdfb", "ffdadaeaebedec", "ccfc", "efaed", "eebbb", "dcafccfbbdfbddcfbefb", "aaeeb", "fcdd", "ccccb", "ddebebfdcdbaaf", "beeeb", "edbfdabdcfb", "cacfbf", "bceacbdababbfca", "ffb", "fcba", "bdfedbaafebbffcefece", "bf", "dbfbeabcecffdbcc", "dccebefccbecf", "aaebfacdaaabfbcfacd", "cb", "edbbbfcdbefeabcfd", "daabdcbadccfeffafa", "cfafbcdfbdabfadddddff", "cbfd", "bcaa", "dffbfebffedc", "ebcbfbaeadbbdfcaa", "dcedebbcdfffabbac", "dbedacddcec", "badedda", "beeeaaffcdadbdecaddc", "dcdbcdbffeddcfea", "dedbdecbca", "cbecacdcfcdcfbfeebdda", "bebbacebbfacfbbbed", "dc", "cdddaedbfeaeebdbef", "accbbd", "bbafead", "dcfba", "efac", "ffce", "cfa", "bac", "bdfdfecccfeadeafedee", "eedddbefdaefbcbf", "acedbeadaedfcdffebea", "cc", "cffbeebdedfdbf", "fdeacddefadbdecbe", "ccccedafdbedaeeb", "cfafddadadcfdbdfb", "aadbbedecd", "cadeffaaffdcaeeefdfbf", "adcaaefbffdfaadedbbb", "cbeebfeeddcfd", "abfaaecdffbdfafe", "fccbbae", "cefdee", "cfdbfbabacafecc"};
        System.out.println(solution.maxProduct1(words));
    }

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        long[] keys = new long[n];
        for (int i = 0; i < n; i++) {
            long key = 1;
            for (char c : words[i].toCharArray()) {
                key *= prime[c - 'a'];
            }
            keys[i] = key;
        }
        int maxProduct = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gcd(keys[i], keys[j]) != 1) {
                    continue;
                }
                maxProduct = Math.max(words[i].length() * words[j].length(), maxProduct);
                System.out.println(words[i] + words[i].length() + "   " + words[j] + words[j].length());
            }
        }
        return maxProduct;
    }

    public long gcd(long a, long b) {
        long r = 0;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public int maxProduct1(String[] words) {
        int n = words.length;
        Set<Character>[] set = new Set[n];
        for (int i = 0; i < n; i++) {
            set[i] = new HashSet<>();
            for (char c : words[i].toCharArray()) {
                set[i].add(c);
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!both(set[i], set[j])) {
                    maxProduct = Math.max(words[i].length() * words[j].length(), maxProduct);
                }
            }
        }
        return maxProduct;
    }

    public boolean both(Set<Character> set1, Set<Character> set2) {
        if (set1.size() > set2.size()) {
            Set tmp = set1;
            set1 = set2;
            set2 = tmp;
        }
        for (char c : set1) {
            if (set2.contains(c)) {
                return true;
            }
        }
        return false;
    }

    public int maxProduct2(String[] words) {
        int n = words.length;
        int[] keys = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                keys[i] |= 1 << c - 'a';
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((keys[i] & keys[j]) == 0) {
                    maxProduct = Math.max(words[i].length() * words[j].length(), maxProduct);
                }
            }
        }
        return maxProduct;
    }

}
