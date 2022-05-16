package com.vika.way.pre.autumn.exam.amazon;

import org.junit.Test;

/**
 * @author ：tangjiawei
 * @date ：2020/9/10 19:13
 */
public class SecurityPacket {

    public int convert(int n) {
        int mask = (1 << countBit(n)) - 1;
        return mask ^ n;
    }

    public int countBit(int n) {
        int bit = 0;
        while (n != 0) {
            n >>= 1;
            bit++;
        }
        return bit;
    }

    public void convert(int[] nums) {
        for (int num : nums) {
            System.out.print(convert(num)+" ");
        }
    }

    @Test
    public void test() {
        int[] nums = {20, 30, 40, 50, 60};
        convert(nums);
    }
}
