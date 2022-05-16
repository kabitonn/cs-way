package com.vika.way.pre.algorithm.leetcode.midium.S401_500;


class SolBase {

}

public class S470ImplementRand10UsingRand7 extends SolBase {

    public int rand7() {
        return 1;
    }

    public int rand10_1() {
        int a, b;
        do {
            a = rand7();
            b = rand7();
        } while (a > 4 && b < 4);
        return (a + b) % 10 + 1;
    }

    public int rand10_2() {
        int a, b, index;
        do {
            a = rand7();
            b = rand7();
            index = (a - 1) * 7 + b;
        } while (index > 40);
        return index % 10 + 1;
    }

    public int rand10() {
        int a = rand7();
        int b = rand7();
        while (a > 5) {
            a = rand7();
        }
        while (b == 7) {
            b = rand7();
        }
        return a + ((b & 1) == 0 ? 0 : 5);
    }
}
