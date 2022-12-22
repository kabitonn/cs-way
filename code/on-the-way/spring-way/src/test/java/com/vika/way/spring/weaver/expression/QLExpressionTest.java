package com.vika.way.spring.weaver.expression;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.junit.Test;

/**
 * @author chenwei.tjw
 * @date 2022/12/16
 **/
public class QLExpressionTest {

    @Test
    public void testNumber() throws Exception {
        ExpressRunner runner = new ExpressRunner(false,false);
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
}
