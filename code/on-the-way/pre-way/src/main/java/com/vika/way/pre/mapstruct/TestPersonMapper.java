package com.vika.way.pre.mapstruct;

import com.google.common.collect.Lists;
import com.vika.way.pre.reflection.User;
import org.junit.Test;

import java.util.List;

/**
 * @Author tangjiawei
 * @Date 2020/8/27
 */
public class TestPersonMapper {
    @Test
    public void testToUser() {
        Person person = new Person();
        person.setAge(10);
        person.setHigh(10);
        User user = PersonMapper.INSTANCE.toUser(person);
        System.out.println(user);

        List<Person> personList = Lists.newArrayList(person, null);
        List<User> userList = PersonMapper.INSTANCE.convertList(personList);
        System.out.println(userList);

        System.out.println(PersonMapper.INSTANCE.convertList(null));
    }
}
