package com.vika.way.pre.autumn.interview.tencent;

/**
 * @author ：tangjiawei
 * @date ：2020/9/12 22:37
 */

/**
 * 4、工行有30万个员工，其工卡号码分别是1~30万，在接下来的某天他们将举行年会，需要抽出10万个员工发奖品。
 * 我们有一个随机数生成函数rand()能够生成0~65535的整数，请写一个公平的抽奖程序，输出这10万个员工的工卡号码。
 * 注：直接在这里写代码，要求使用C++实现完整的代码
 */
public class SelfRandom {

    public int rand() {
        return (int) Math.random();
    }

    public int slefRand() {
        int g = rand();
        int s = rand();
        while (g > 60000) {
            g = rand();
        }
        while (s > 50000) {
            s = rand();
        }
        return g / 10000 * 50000 + s;
    }
}
