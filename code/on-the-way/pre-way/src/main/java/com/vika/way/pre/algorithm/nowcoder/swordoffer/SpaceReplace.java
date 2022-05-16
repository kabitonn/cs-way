package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpaceReplace {

    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }

    final static Pattern pattern = Pattern.compile(" ");

    public String replaceSpace1(StringBuffer str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String s = str.toString();
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            s = matcher.replaceAll("%20");
            matcher = pattern.matcher(s);
        }
        return s;
    }
}
