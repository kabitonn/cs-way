package com.vika.way.spring.weaver.expression;

import com.alibaba.fastjson.JSON;
import com.vika.way.spring.weaver.constans.WeaverExecuteLangEnum;
import com.vika.way.spring.weaver.executor.ExecutionContext;
import com.vika.way.spring.weaver.utils.ExpressionParserUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author chenwei.tjw
 * @date 2022/10/26
 **/
public class SpelExpressionExecutionUnitTest {

    ExpressionExecutionUnit expressionExecutionUnit = new ExpressionExecutionUnit(null);
    ExecutionContext executionContext = new ExecutionContext();


    @Test
    public void testConditionExecute() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("root", 1);
        executionContext.setVariables(map);
        String expression = "1==1?true:false";
        ExpressionExecutionUnit expressionExecutionUnit = new ExpressionExecutionUnit(expression);
        expressionExecutionUnit.setExpressionText(expression);
        Object result = expressionExecutionUnit.execute(executionContext);
    }


    @Test
    public void testExecute() throws Exception {
        //#this 变量始终被定义并引用当前评估对象（针对那些非限定引用被解析）

        //#root 变量始终被定义并引用根上下文对象。
        Map<String, Object> map = new HashMap<>();
        map.put("$root", new HashMap<>());
        map.put("type", 1);

        System.out.println(JSON.toJSONString(map));
        executionContext.setVariables(map);
        String expression = "#$root['type']=#type";
        expressionExecutionUnit.setExpressionText(expression);
        Object result = expressionExecutionUnit.execute(executionContext);

        System.out.println(JSON.toJSONString(map));
        expressionExecutionUnit.setExpressionText("#root");
        result = expressionExecutionUnit.execute(executionContext);
    }

    @Test
    public void testScript() {
        ExecutionContext executionContext = new ExecutionContext();
        Map<String, Object> map = new HashMap<>();
        map.put("quantity", 1);
        map.put("baseCurrencyAmount", "111");
        executionContext.setVariable("source", map);
        executionContext.setVariable("target", new HashMap<>());

        String expression = "#target['hi'] = (#source['quantity']==0?null:new java.math.BigDecimal(#source['baseCurrencyAmount'])\n"
                + ".divide(new java.math.BigDecimal(#source['quantity']), 6, T(java.math.BigDecimal).ROUND_HALF_UP).toString())";
        expressionExecutionUnit = new ExpressionExecutionUnit(expression, WeaverExecuteLangEnum.SpEL);
        Object obj = expressionExecutionUnit.execute(executionContext);
        System.out.println(obj);

        expressionExecutionUnit = new ExpressionExecutionUnit("new java.math.BigDecimal(#source['quantity'])", WeaverExecuteLangEnum.SpEL);
        obj = expressionExecutionUnit.execute(executionContext);
        System.out.println(obj);
        System.out.println(new BigDecimal(0).equals(0));
        System.out.println(JSON.toJSONString(executionContext.getVariable("target")));
    }


    @Test
    public void testArray() {

        ExecutionContext executionContext = new ExecutionContext();
        Map<String, Object> map = new HashMap<>();
        map.put("quantity", 1);
        executionContext.setVariable("source", map);
        executionContext.setVariable("target", new HashMap<>());

        String expression = "#target['mainList']={new java.util.HashMap(),new java.util.HashMap()}";
        expressionExecutionUnit = new ExpressionExecutionUnit(expression, WeaverExecuteLangEnum.SpEL);
        Object obj = expressionExecutionUnit.execute(executionContext);
        System.out.println(obj);

        expression = "#target['mainList'][0]['principal']=#source['quantity']";
        expressionExecutionUnit = new ExpressionExecutionUnit(expression, WeaverExecuteLangEnum.SpEL);
        obj = expressionExecutionUnit.execute(executionContext);
        System.out.println(obj);

        System.out.println(JSON.toJSONString(executionContext.getVariable("target")));


        System.out.println(ExpressionParserUtils.getListSizeByDegree("#target['mainList'][i]['principal'] = #source.get('quantity')[i]",1, executionContext));


        expression = "#target['receiveFinishTime']=1672502599000L";
        expressionExecutionUnit = new ExpressionExecutionUnit(expression, WeaverExecuteLangEnum.SpEL);
        obj = expressionExecutionUnit.execute(executionContext);
        System.out.println(obj);

        expression = "#target['receiveFinishTime']>=1672502400000L";
        expressionExecutionUnit = new ExpressionExecutionUnit(expression, WeaverExecuteLangEnum.SpEL);
        obj = expressionExecutionUnit.execute(executionContext);
        System.out.println(obj);

    }


}