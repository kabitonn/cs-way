package com.vika.way.pre.mapstruct;

import com.vika.way.pre.reflection.User;
import org.junit.Test;

/**
 * @Author tangjiawei
 * @Date 2020/8/27
 */
public class TestPersonMapper {
    @Test
    public void testToUser() {
        Person person = new Person();
        person.setAge(10);
        User user = PersonMapper.INSTANCE.toUser(person);
        System.out.println(user);
    }
}
