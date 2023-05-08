package com.vika.way.pre.mapstruct;


import lombok.Data;

import java.util.List;
import java.util.Map;

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

    private Map<String, Object> attribute;

    private List<String> advances;

}
