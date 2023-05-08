package com.vika.way.pre.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenwei.tjw
 * @date 2022/8/4
 **/
public class JsonUtil {


    @Test
    public void testStringIntgerObject() {
        String string = "{'number':1}";
        String string1 = "{'number':'1'}";

        JSONObject jsonObject0 = JSON.parseObject(string);
        JSONObject jsonObject1 = JSON.parseObject(string1);

        System.out.println(JSON.toJSONString(JSON.parseObject(string, StringObject.class)));
        System.out.println(JSON.toJSONString(JSON.parseObject(string, IntegerObject.class)));

        System.out.println(JSON.toJSONString(JSON.parseObject(string1, StringObject.class)));
        System.out.println(JSON.toJSONString(JSON.parseObject(string1, IntegerObject.class)));

        string = "{'number':1.5}";
        string1 = "{'number':'1.5'}";
        System.out.println(JSON.toJSONString(JSON.parseObject(string, StringObject.class)));
        System.out.println(JSON.toJSONString(JSON.parseObject(string, IntegerObject.class)));
        System.out.println(JSON.toJSONString(JSON.parseObject(string1, StringObject.class)));


        JSONObject object = JSON.parseObject(string);
        System.out.println(object.getJSONArray("a"));
        System.out.println(object.get("a"));
        System.out.println(object.getString("a"));
        System.out.println(object.getBigDecimal("a"));
        System.out.println(object.getBigInteger("a"));
        System.out.println(object.getByte("a"));
        System.out.println(object.getDate("a"));

        String array = "[{},{}]";
        List<JSONObject> list = JSON.parseArray(array, JSONObject.class);
        JSONObject jsonObject = list.stream().findFirst().get();
        jsonObject.put("b", new int[]{1, 2});
        List<JSONObject> list1 = list.stream().filter(p -> CollectionUtils.isNotEmpty(p.getJSONArray("b"))).collect(Collectors.toList());
        for (JSONObject o : list1) {
            o.put("a", new int[]{1, 2});
        }
        System.out.println(list);


    }

    @Test
    public void testSerialize() {
        StringObject object = new StringObject();
        object.setNumber("1");
        String json = JSON.toJSONString(object, SerializerFeature.WriteClassName);
        System.out.println(json);
    }

    @Test
    public void testAssign() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("k1.k2", "v");
        System.out.println(jsonObject);
    }

    @Test
    public void testList() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stringList", "");
        ListObject listObject = JSON.parseObject(JSON.toJSONString(jsonObject), ListObject.class);
        System.out.println(listObject);
    }

    @Test
    public void testString(){
        String str = "{}";
        System.out.println(str);
        System.out.println(JSON.parseObject(str));
        System.out.println(JSON.parseObject(str).toString());
        System.out.println(JSON.toJSONString(JSON.parseObject(str)));

        System.out.println(JSON.toJSONString(str));
        //System.out.println(JSON.parseObject(JSON.toJSONString(str)));
    }
}
