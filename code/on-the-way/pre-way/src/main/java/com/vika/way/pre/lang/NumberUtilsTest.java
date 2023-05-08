package com.vika.way.pre.lang;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

/**
 * @author chenwei.tjw
 * @date 2023/2/22
 **/
public class NumberUtilsTest {

    @Test
    public void testIsNumber() {
        boolean r = NumberUtils.isNumber("-2000.00");
        System.out.println(r);

        r = NumberUtils.isNumber("-2000.00.");
        System.out.println(r);
    }

}
