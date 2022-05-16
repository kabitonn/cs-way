package com.vika.way.pre.basic.oop;

public class SonClass extends SuperClass {
    @Override
    public int over() {
        return 1;
    }

    @Override
    public SonClass over1() {
        return this;
    }
}
