package com.vika.way.pre.basic.string;

import org.junit.Test;

import java.math.BigDecimal;

public class StringPoolTest {

    @Test
    public void testIntern() {
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);// false
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s1 == s3);//false
        System.out.println(s3 == s4);//true
    }

    @Test
    public void testIntern2() {
        String str1 = "ja";
        String str2 = "va";
        String str = str1 + str2;
        String s = str.intern();//jdk中存在Java的字面量 常量池已存在
        String str3 = "java";
        System.out.println(s == str);//false
        System.out.println(str == str3);//false
        System.out.println(s == str3);//true
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(str));

        String str4 = new StringBuilder("Ja").append("va").toString();
        System.out.println(str4.intern() == str4);

        String str5 = new StringBuilder("JA").append("VA").toString();
        System.out.println(str5.intern() == str5);
    }

    @Test
    public void testIntern3() {
        String str1 = "str";
        String str2 = "ing";
        String str = str1 + str2; //在堆上创建的新的对象，常量池中还不存在对应实例
        String s = str.intern();
        String str3 = "string";
        System.out.println(s == str);//true 常量池中字面量的引用是堆中的引用实例，因为"string"第一次出现是在堆中
        System.out.println(str == str3);//true 常量池中字面量的引用是堆中的引用实例，str3查找时已出现在常量池中
        System.out.println(System.identityHashCode(s));//460141958 地址
        System.out.println(System.identityHashCode(str));//460141958 地址
    }

    @Test
    public void testIntern4() {
        final String str1 = "str";
        final String str2 = "ing";
        String str = str1 + str2; //常量替换，常量池中的对象
        String s = str.intern();
        String str3 = "string";
        System.out.println(s == str);//true
        System.out.println(str == str3);//true
        System.out.println(System.identityHashCode(s));//460141958 地址
        System.out.println(System.identityHashCode(str));//460141958 地址
    }

    @Test
    public void testConcat1() {
        String str1 = "str";
        String str2 = "ing";

        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2; //在堆上创建的新的对象，常量池中还不存在对应实例
        String str5 = "string";//常量池中的对象
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false
    }

    @Test
    public void testConcat2() {
        final String str1 = "str";
        final String str2 = "ing";

        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2; //常量替换，常量池中存在对应实例
        String str5 = "string";//常量池中的对象
        System.out.println(str3 == str4);//true
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//true
    }

    @Test
    public void testBigDecmal() {

        BigDecimal amount = new BigDecimal("0.0072");
        BigDecimal taxRate = new BigDecimal("0.13");
        BigDecimal taxAmount =  amount.divide(BigDecimal.ONE.add(taxRate), 6, BigDecimal.ROUND_HALF_UP).multiply(taxRate);
        System.out.println(amount.divide(BigDecimal.ONE.add(taxRate), 6, BigDecimal.ROUND_HALF_UP));
        System.out.println(taxAmount);
    }
}
