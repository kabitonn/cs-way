package com.vika.way.pre.autumn.exam.netease;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：tangjiawei
 * @date ：2020/9/11 19:55
 */
public class MinFitNumber {

    public String minFitNumber(String a, String b) {
        List<Character> list = new ArrayList<>();
        for (char c : b.toCharArray()) {
            list.add(c);
        }
        Collections.sort(list);
        return permute(a, "", list, 0);
    }

    public String permute(String a, String s, List<Character> list, int index) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == a.charAt(index)) {
                char c = list.get(i);
                s = s + list.remove(i);
                String r = permute(a, s, list, index + 1);
                if (!"-1".equals(r)) {
                    return r;
                }
                list.add(i, c);
            } else if (list.get(i) > a.charAt(index)) {
                char c = list.remove(i);
                s = s + c;
                for (char ch : list) {
                    s = s + ch;
                }
                return s;
            }
        }
        return "-1";
    }

    public void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    @Test
    public void test() {
        String r = minFitNumber("421423213", "421423213");
        System.out.println(r);
    }
}
