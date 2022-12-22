package com.vika.way.spring.weaver.expression;

import com.alibaba.fastjson.JSON;
import com.vika.way.spring.utils.FileReadUtils;
import com.vika.way.spring.weaver.constans.WeaverExecuteLangEnum;
import com.vika.way.spring.weaver.executor.ExecutionContext;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenwei.tjw
 * @date 2022/12/16
 **/
public class QLExpressionExecutionUnitTest {
    ExpressionExecutionUnit expressionExecutionUnit = new ExpressionExecutionUnit(null, WeaverExecuteLangEnum.QL_EXPRESS);
    ExecutionContext executionContext = new ExecutionContext();

    @Test
    public void testScript() {
        ExecutionContext executionContext = new ExecutionContext();
        Map<String, Object> map = new HashMap<>();

        executionContext.setVariable("source", map);
        executionContext.setVariable("target", new HashMap<>());

        String expression = "$.source.baseCurrencyAmount=Q";
        expressionExecutionUnit.setExpressionText(expression);
        Object obj = expressionExecutionUnit.execute(executionContext);
        System.out.println(obj);

        expression = "$.target.quantity=1";
        expressionExecutionUnit.setExpressionText(expression);
        obj = expressionExecutionUnit.execute(executionContext);
        System.out.println(obj);
        System.out.println(JSON.toJSONString(executionContext.getVariable("source")));
        System.out.println(JSON.toJSONString(executionContext.getVariable("target")));
    }

    @Test
    public void testVariable() {
        ExecutionContext executionContext = new ExecutionContext();
        Map<String, Object> main = new HashMap<>();
        Map<String, Object> mainAttr = new HashMap<>();
        executionContext.setVariable("main", main);
        executionContext.setVariable("mainAttr", mainAttr);
        mainAttr.put("a", "1");
        mainAttr.put("b", 1);
        mainAttr.put("c", '1');
        mainAttr.put("d", "123");
        mainAttr.put("e", 123);
        mainAttr.put("f", 123L);
        mainAttr.put("g", "PURCHASE");

        List<String> expressions = new ArrayList<>();
        Object obj;

        expressions.add("$.mainAttr");

        expressions.add("$.mainAttr.a==1");
        expressions.add("$.mainAttr.a=='1'");
        expressions.add("$.mainAttr.a==\"1\"");

        expressions.add("$.mainAttr.b==1");
        expressions.add("$.mainAttr.b=='1'");
        expressions.add("$.mainAttr.b==\"1\"");

        expressions.add("$.mainAttr.c==1");
        expressions.add("$.mainAttr.c=='1'");
        expressions.add("$.mainAttr.c==\"1\"");

        expressions.add("$.mainAttr.d==123");
        expressions.add("$.mainAttr.d=='123'");
        expressions.add("$.mainAttr.d==\"123\"");


        expressions.add("$.mainAttr.e==123");
        expressions.add("$.mainAttr.e==123L");
        expressions.add("$.mainAttr.e=='123'");
        expressions.add("$.mainAttr.e==\"123\"");

        expressions.add("$.mainAttr.f==123");
        expressions.add("$.mainAttr.f==123L");
        expressions.add("$.mainAttr.f=='123'");
        expressions.add("$.mainAttr.f==\"123\"");

        expressions.add("$.mainAttr.f==123&&$.mainAttr.d=='123'");

        expressions.add("$.mainAttr.g==PURCHASE");
        expressions.add("$.mainAttr.g==\"PURCHASE\"");
        expressions.add("$.mainAttr.g=='PURCHASE'");


        for (String expression : expressions) {
            expressionExecutionUnit.setExpressionText(expression);
            obj = expressionExecutionUnit.execute(executionContext);
            System.out.println(expression + ":" + obj);
        }
    }

    @Test
    public void testString() throws IOException {
        Map map = FileReadUtils.readObject("ql/event.json", Map.class);
        executionContext.setVariables(map);
        List<String> expressions = new ArrayList<>();
        Object obj;

        expressions.add("$.mainAttr");

        expressions.add("$.mainAttr.tradeMode=='1'&&$.mainAttr.supplierMarketingType=='CONSIGNSALE'&&$.mainAttr.consignmentSettlementPrice=='FIX_PRICE'");
        expressions.add("$.mainAttr.tradeMode==\"1\"&&$.mainAttr.supplierMarketingType=='CONSIGNSALE'&&$.mainAttr.consignmentSettlementPrice=='FIX_PRICE'");
        expressions.add("$.mainAttr.tradeMode=='1' && $.mainAttr.supplierMarketingType=='CONSIGNSALE'");
        expressions.add("'1'==\"1\"");
        expressions.add("'1'.equals(\"1\")");
        expressions.add("'1'.getClass()");
        expressions.add("\"1\".getClass()");
        expressions.add("$.mainAttr.tradeMode=='1'.toString()");
        expressions.add("$.mainAttr.tradeMode==1");
        expressions.add("$.mainAttr.tradeMode=='1'");
        expressions.add("$.mainAttr.tradeMode.getClass()");
        expressions.add("$.mainAttr.tradeMode.equals(1)");
        expressions.add("$.mainAttr.tradeMode.equals('1')");

        expressions.add("$.mainAttr.poType=='120'");
        expressions.add("$.mainAttr.poType==120");
        expressions.add("$.mainAttr.poType.getClass()");

        expressions.add("$.mainAttr.payTime==1663136157000");
        expressions.add("$.mainAttr.payTime=='1663136157000'");
        expressions.add("$.mainAttr.payTime>=1663136156999");

        expressions.add("$.main.partnerCode>=282623144");

        for (String expression : expressions) {
            expressionExecutionUnit.setExpressionText(expression);
            obj = expressionExecutionUnit.execute(executionContext);
            System.out.println(expression + ":" + obj);
        }
    }
}
