package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

public class S400NthDigit {

    public static void main(String[] args) {
        S400NthDigit solution = new S400NthDigit();
        System.out.println(solution.findNthDigit(10000));
    }

    public int findNthDigit(int n) {
        int num = 0;
        int bits = 1;
        int count = 9;
        while (n - count * bits >= 0 && count < Integer.MAX_VALUE / bits) {
            num += count;
            n -= count * bits;
            count *= 10;
            bits++;
        }
        num += n / bits;
        int r = n % bits;
        if (r == 0) {
            return num % 10;
        } else {
            //return (int) ((num+1)/Math.pow(10, bit-r))%10;
            return ((num + 1) + "").charAt(r - 1) - '0';
        }
    }

    public int findNthDigit2(int n) {
        /*1-9/10-99/100-999/……*/
        //first 是每组的第一个值
        int first = 1;
        //每组每个数的位数
        int bits = 1;
        //每组数字个数
        int count = 9;
        n--;    //从0开始
        while (n / bits / count >= 1) {
            n -= count * bits;
            count *= 10;
            first *= 10;
            bits++;
        }
        return (first+n/bits+"").charAt(n%bits)-'0';
    }
}
