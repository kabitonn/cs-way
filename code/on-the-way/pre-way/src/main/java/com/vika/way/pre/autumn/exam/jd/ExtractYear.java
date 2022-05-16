package com.vika.way.pre.autumn.exam.jd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：tangjiawei
 * @date ：2020/9/17 19:17
 */
public class ExtractYear {

    final Pattern pattern = Pattern.compile("[0-9]{4,}");

    public List<String> extractAllYear(String s) {
        Matcher matcher = pattern.matcher(s);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            String number = matcher.group();
            int i = 0;
            while (number.charAt(i) == '0') {
                i++;
            }
            number = number.substring(i);
            if (number.length() > 4) {
                continue;
            }
            int num = Integer.valueOf(number);
            if (num >= 1000 && num <= 3999) {
                list.add(number);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ExtractYear main = new ExtractYear();
        List<String> list = main.extractAllYear(str);
        for (String s : list) {
            System.out.print(s + " ");
        }
    }

    @Test
    public void test() {
        // String str = "And millionaires2000% will h0111111old 46 23% of total wealth by 2019, the report says. This ratio is likely to increase in 2020.";
        String str = "02010";
        List<String> list = extractAllYear(str);
        for (String s : list) {
            System.out.print(s + " ");
        }
    }

}
