package com.vika.way.pre.algorithm.nowcoder.swordoffer;

/**
 * 不用加减乘除做加法
 */
public class AddSpecial {

    public int Add(int num1, int num2) {
        return num2 != 0 ? Add(num1 ^ num2, (num1 & num2) << 1) : num1;
    }

    public int Add1(int num1, int num2) {
        int sum = num1;
        int carry = num2;
        while (carry != 0) {
            int temp = sum;
            sum ^= carry;
            carry = (temp & carry) << 1;
        }
        return sum;
    }
}
