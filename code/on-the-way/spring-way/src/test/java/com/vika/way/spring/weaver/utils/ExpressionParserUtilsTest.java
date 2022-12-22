package com.vika.way.spring.weaver.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.vika.way.spring.weaver.executor.ExecutionContext;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author chenwei.tjw
 * @date 2022/12/22
 **/
public class ExpressionParserUtilsTest {

    @Test
    public void testGetCyclesDegree() throws Exception {
        System.out.println(ExpressionParserUtils.getCyclesDegree(null));
        System.out.println(ExpressionParserUtils.getCyclesDegree(""));
        System.out.println(ExpressionParserUtils.getCyclesDegree("#root['i']"));
        System.out.println(ExpressionParserUtils.getCyclesDegree("#root[i]"));
        System.out.println(ExpressionParserUtils.getCyclesDegree("#root[i].get('items')[j]"));
        System.out.println(ExpressionParserUtils.getCyclesDegree("#root[i].get('items')[j].list[k]"));
        System.out.println(ExpressionParserUtils.getCyclesDegree("#targetevent1['itemList'][i]['scItemId'] = #sourceevent1['payload']['orderLines'][i]['product']['productId']"));
    }

    @Test
    public void testDowngrade() {
        System.out.println(ExpressionParserUtils.downgrade("#root", 0));
        System.out.println(ExpressionParserUtils.downgrade("#root[i]", 101));
        System.out.println(ExpressionParserUtils.downgrade("#root[i]af[j]", 0));
        System.out.println(ExpressionParserUtils.downgrade("#root[i]af[j]cf[k]", 88));
        System.out.println(ExpressionParserUtils.downgrade("#root[i]af[j]cf[k][l]", 999));
        System.out.println(ExpressionParserUtils.downgrade("#$root.get('payload').get('orderLines')[i].get('receiveFinishQuantity')[j].get('pricing')", 0));
        System.out.println(ExpressionParserUtils.downgrade("#$root.get('payload').get('orderLines')[0].get('receiveFinishQuantity')[i].get('pricing') != null", 0));
    }

    @Test
    public void testGetListSizeByDegree() {
        ExecutionContext executionContext = new ExecutionContext();

        JSONObject source = new JSONObject();
        source.put("items", Lists.newArrayList("","",""));
        executionContext.setVariable("source", source);

        JSONObject target = new JSONObject();
        target.put("items", Lists.newArrayList("","","","",""));
        executionContext.setVariable("target", target);
        System.out.println(ExpressionParserUtils.getListSizeByDegree("#target['items'][i] = #source.get('serviceName')",1, executionContext));
        System.out.println(ExpressionParserUtils.getListSizeByDegree("#source['items'][i]",1, executionContext));

    }
}
