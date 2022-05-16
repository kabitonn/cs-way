package com.vika.way.pre.algorithm.leetcode.easy.S501_600;

public class S551StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                if (++a > 1) {
                    return false;
                }
                l = 0;
            } else if (c == 'L') {
                if (++l > 2) {
                    return false;
                }
            } else {
                l = 0;
            }
        }
        return true;
    }
}
