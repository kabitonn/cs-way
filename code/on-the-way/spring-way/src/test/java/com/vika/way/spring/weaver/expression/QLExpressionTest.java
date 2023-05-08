package com.vika.way.spring.weaver.expression;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenwei.tjw
 * @date 2022/12/16
 **/
public class QLExpressionTest {

    @Test
    public void testNumber() throws Exception {
        ExpressRunner runner = new ExpressRunner(false, false);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a", 1);
        context.put("b", 2);
        context.put("c", 3);
        context.put("d", "4");
        context.put("e", '5');
        context.put("f", "PURCAHSE");
        String express = "a + b * c";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);

        r = runner.execute("PURCAHSE", context, null, true, false);
        System.out.println(r);

        r = runner.execute("'PURCAHSE'", context, null, true, false);
        System.out.println(r);

        String expression = "a==1";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);
        expression = "a=='1'";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);
        expression = "a==\"1\"";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);
        expression = "a.toString()";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);


        expression = "d==4";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);
        expression = "d=='4'";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);
        expression = "d==\"4\"";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);

        expression = "e==5";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);
        expression = "e=='5'";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);
        expression = "e==\"5\"";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);

        expression = "f==PURCHASE";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);
        expression = "f=='PURCHASE'";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);
        expression = "f==\"PURCHASE\"";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);

    }


    @Test
    public void testDate() throws Exception {
        ExpressRunner runner = new ExpressRunner(false, false);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("endTime1", "2023-04-01 00:00:00");
        context.put("endTime2", "2023-04-01");
        context.put("endTime3", "2023-03-31 23:59:59");
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-03-31 23:59:59");
        context.put("endTime4", date);

        String expression = "!(endTime1 < '2023-04-01')";
        Object r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);

        expression = "!(endTime2 < '2023-04-01')";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);

        expression = "!(endTime3 < '2023-04-01')";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);

        expression = "endTime4.getTime() >= 1680278400000";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);

        expression = "endTime4.getTime().toString()";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(expression + ":" + r);
    }

    @Test
    public void testAssign() throws Exception {
        ExpressRunner runner = new ExpressRunner(false, false);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        Map<String, Object> map = new HashMap<>();
        map.put("extAttr", new HashMap<>());

        context.put("ql", map);

        String expression = "ql.extAttr.a=1;ql.extAttr.b=null;";
        Object r = runner.execute(expression, context, null, true, false);
        System.out.println(r);
        System.out.println(map);

        expression = "ql.extAttr.remove(\"b\")";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(map);

    }


    @Test
    public void testArray() throws Exception {
        ExpressRunner runner = new ExpressRunner(false, false);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        Map<String, Object> map = new HashMap<>();
        map.put("sourceType", "EXTEND_RENEW-");
        map.put("chargeShopTypes", new Object[]{"1", "2"});
        context.put("ql", map);

        String expression = "!(ql.sourceType in ['EXTEND_RENEW'])";
        Object r = runner.execute(expression, context, null, true, false);
        System.out.println(r);

        expression = "!(ql.chargeShopTypes in ['',null])";
        r = runner.execute(expression, context, null, true, false);
        System.out.println(r);
    }
}
