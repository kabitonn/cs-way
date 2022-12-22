package com.vika.way.pre.stream;

import com.google.common.collect.Lists;
import com.vika.way.pre.reflection.User;
import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author chenwei.tjw
 * @date 2022/8/19
 **/
public class Collect {

    @Test
    public void test() {

        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
        pairArrayList.add(new Pair<>("version", 12.10));
        pairArrayList.add(new Pair<>("version", 12.19));
        pairArrayList.add(new Pair<>("version", 6.28));
        Map<String, Double> map = pairArrayList.stream().collect(Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));
    }

    @Test
    public void test0() {
        List<User> userList = Lists.newArrayList(
                new User().setId("B").setName("张三"),
                new User().setId("A").setName("李四"),
                new User().setId("C").setName("王五")
        );

        userList.stream().collect(Collectors.toMap(User::getId, User::getName, (n1, n2) -> n1, TreeMap::new));

    }


}
