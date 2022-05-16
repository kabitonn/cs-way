package com.vika.way.pre.algorithm.nowcoder.swordoffer;

public class JumpFloor {

    public int JumpFloor(int target) {
        if (target == 0) {
            return 0;
        }
        int pre = 0, cur = 1;
        int temp;
        int n = target;
        while (n-- > 0) {
            temp = cur;
            cur += pre;
            pre = temp;
        }
        return cur;
    }
}
