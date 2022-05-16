package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class RectCover {

    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        return RectCover(target - 1) * 2 + RectCover(target - 1);
    }

    public int RectCover1(int target) {
        if (target <= 2) {
            return target;
        }
        int cur = 2;
        int pre = 1;
        for (int i = 3; i <= target; i++) {
            int temp = cur;
            cur += pre;
            pre = temp;
        }
        return cur;
    }
}
