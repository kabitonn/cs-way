package com.vika.way.pre.mapstruct;


import lombok.Data;

/**
 * @author ：chenwei.tjw
 * @date ：2020/7/22 10:45 上午
 */
@Data
public class Person {

    private String name;

    private boolean sex;

    private int age;

    private Integer high = 0;

}
