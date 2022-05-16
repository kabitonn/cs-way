package com.vika.way.pre.basic.oop;

public class Outer {

    class Father {
        private int a;
    }

    class Son extends Father {
        public int getA() {
            return super.a;
        }
    }
}