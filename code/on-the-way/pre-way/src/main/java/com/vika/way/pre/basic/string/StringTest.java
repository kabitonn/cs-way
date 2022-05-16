package com.vika.way.pre.basic.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringTest {

    @Test
    public void testCharSet() throws UnsupportedEncodingException {
        System.out.println(System.getProperties());
        // 使用String的有参构造方法
        String str = new String("hhhh ty智障%shfu摸淑芬十分uif内服NSF黑");
        // 1.以GBK编码方式获取str的字节数组，再用String有参构造函数构造字符串
        System.out.println(new String(str.getBytes("GBK"), "GBK"));
        // 2.以UTF-8编码方式获取str的字节数组，再以默认编码构造字符串
        System.out.println(new String(str.getBytes("UTF-8"), "GBK"));
    }


    @Test
    public void testBytes() throws UnsupportedEncodingException {
        String str = "Aa鄢";
        System.out.println("UTF-32" + Arrays.toString(str.getBytes("UTF-32")));
        System.out.println("UTF-32BE" + Arrays.toString(str.getBytes("UTF-32BE")));
        System.out.println("UTF-32LE" + Arrays.toString(str.getBytes("UTF-32LE")));
        System.out.println("Unicode" + Arrays.toString(str.getBytes("Unicode")));
        System.out.println("UTF-16" + Arrays.toString(str.getBytes("UTF-16")));
        System.out.println("UTF-16BE" + Arrays.toString(str.getBytes("UTF-16BE")));
        System.out.println("UTF-16LE" + Arrays.toString(str.getBytes("UTF-16LE")));
        System.out.println("UTF-8" + Arrays.toString(str.getBytes("UTF-8")));
        System.out.println("default" + Arrays.toString(str.getBytes()));
        System.out.println("GBK" + Arrays.toString(str.getBytes("GBK")));
        System.out.println("ISO" + Arrays.toString(str.getBytes("ISO-8859-1")));
        System.out.println("ASCII" + Arrays.toString(str.getBytes("ASCII")));
    }

    public String bytes2Hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        String tmp = null;
        for (byte b : bytes) {
            // 将每个字节与0xFF进行与运算，然后转化为10进制，然后借助于Integer再转化为16进制
            tmp = Integer.toHexString(0xFF & b);
            if (tmp.length() == 1) {
                tmp = "0" + tmp;
            }
            sb.append(tmp);
        }
        return sb.toString();
    }

    @Test
    public void testIntegerString(){
        Integer integer=null;
        System.out.println(String.valueOf(integer));
    }
}
