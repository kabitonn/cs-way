package com.vika.way.pre.jvm.classload;

import org.junit.Test;

public class StaticClinit {

    static {
        //i = 1;
    }

    private static int i;

    static {
        System.out.println(i);
        i = 3;
        System.out.println(i);
    }

    @Test
    public void test() {

    }

}
