package com.vika.way.pre.reflection;

import com.vika.way.pre.annotation.FieldMeta;
import lombok.Data;
import org.junit.Test;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：chenwei.tjw
 * @date ：2020/7/21 4:18 下午
 */
@Data
public class User {

    @FieldMeta("年龄")
    int age;

    Integer high = 0;

    String name;

    boolean sex;

    Boolean child;

    @Test
    public void testField() throws Exception {
        User user = new User();
        Class<?> clazz = user.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(field.get(user));
        }
        Field fieldAge = clazz.getDeclaredField("high");
        Integer high = Integer.parseInt(fieldAge.get(user).toString());
        System.out.println(fieldAge.get(user).getClass());
    }

    @Test
    public void test() throws Exception {
        User user = new User();
        Class<?> clazz = user.getClass();
        List<Field> fields = new ArrayList<>();
        ReflectionUtils.doWithFields(clazz, fields::add, field -> !Modifier.isStatic(field.getModifiers()));
        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(field.get(user));
            System.out.println(Arrays.toString(field.getAnnotations()));
        }
    }
}
