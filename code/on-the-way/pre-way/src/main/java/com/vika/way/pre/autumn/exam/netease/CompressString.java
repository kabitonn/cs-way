package com.vika.way.pre.autumn.exam.netease;

import org.junit.Test;

/**
 * @author ：tangjiawei
 * @date ：2020/9/11 19:28
 */
public class CompressString {

    public String compress(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        char prev = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != prev) {
                sb.append(append(count, prev));

                prev = chars[i];
                count = 1;
            } else {
                count++;
                if (count > 55) {
                    sb.append('0');
                    sb.append('Z');
                    sb.append(prev);
                    prev = chars[i];
                    count = 1;
                }
            }
        }
        sb.append(append(count, prev));
        return sb.toString();
    }

    public String append(int count, char prev) {
        StringBuilder sb = new StringBuilder();
        if (count <= 3) {
            for (int j = 0; j < count; j++) {
                sb.append(prev);
            }
        } else {
            sb.append('0');
            char c = count >= 30 ? (char) (count - 30 + 'A') : (char) (count - 4 + 'a');
            sb.append(c);
            sb.append(prev);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        // String s = "abbbbbbAAAdcdddd";
        String s="BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBgeFYHHnjHAPQQc";
        String r = compress(s);
        System.out.println(r);
    }
}
