package com.vika.way.spring.utils;


import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONTokener;

/**
 * @author chenwei.tjw
 * @date 2023/4/25
 **/
public class JsonUtils {

    /**
     * 判断是否JSONArray,否则JSONObject
     *
     * @param str
     * @return
     */
    public static boolean isJSONArray(String str) {
        try {
            Object object = new JSONTokener(str).nextValue();
            return object instanceof JSONArray;
        } catch (JSONException e) {
            throw new IllegalArgumentException("无效json字符串");
        }
    }
}
