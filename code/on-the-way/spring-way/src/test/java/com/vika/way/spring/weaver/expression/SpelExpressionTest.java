package com.vika.way.spring.weaver.expression;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author chenwei.tjw
 * @date 2022/10/26
 **/
public class SpelExpressionTest {

    StandardEvaluationContext context = new StandardEvaluationContext();
    ExpressionParser parser = new SpelExpressionParser();
    Expression expression = null;

    @Test
    public void testEvaluation() {

        expression = parser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[]) expression.getValue();
        System.out.println(JSON.toJSONString(bytes));

        expression = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) expression.getValue();
        System.out.println(length);

        Map object = new HashMap();
        object.put("name", "Tesla");
        expression = parser.parseExpression("get('name')");
        String name = expression.getValue(object, String.class);
        System.out.println(name);

        expression = parser.parseExpression("get('name')== 'Nikola Tesla'");
        boolean result = expression.getValue(object, Boolean.class);
        System.out.println(result);
    }

    @Test
    public void testEvaluationContext() {
        EvaluationContext context = new StandardEvaluationContext();
        SimpleDemo simple = new SimpleDemo();
        simple.booleanList.add(true);

        parser.parseExpression("booleanList[0]").setValue(context, simple, "false");
        Boolean b = simple.booleanList.get(0);
        System.out.println(b);

    }

    @Test
    public void testParserConfig() {
        SpelParserConfiguration config = new SpelParserConfiguration(true, true);
        parser = new SpelExpressionParser(config);
        expression = parser.parseExpression("list[3]");
        SimpleDemo simple = new SimpleDemo();
        Object o = expression.getValue(simple);
        System.out.println(JSON.toJSONString(o));
        try {

            config = new SpelParserConfiguration(true, false);
            parser = new SpelExpressionParser(config);
            expression = parser.parseExpression("list[3]");
            simple = new SimpleDemo();
            o = expression.getValue(simple);
            System.out.println(JSON.toJSONString(o));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            config = new SpelParserConfiguration(false, true);
            parser = new SpelExpressionParser(config);
            expression = parser.parseExpression("list[3]");
            simple = new SimpleDemo();
            o = expression.getValue(simple);
            System.out.println(JSON.toJSONString(o));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testCompilation() {
        SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,
                this.getClass().getClassLoader());
        parser = new SpelExpressionParser(config);

        expression = parser.parseExpression("list");

        SimpleDemo simple = new SimpleDemo();
        Object o = expression.getValue(simple);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void testLiteral() {
        String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();
        System.out.println(helloWorld);

        double avogadrosNumber = (Double) parser.parseExpression("6.0221415E+23").getValue();
        System.out.println(avogadrosNumber);

        // evals to 2147483647
        int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
        System.out.println(maxValue);

        boolean trueValue = (Boolean) parser.parseExpression("true").getValue();
        System.out.println(trueValue);

        Object nullValue = parser.parseExpression("null").getValue();
        System.out.println(nullValue);
    }


    @Test
    public void testProperties() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        Inventor inventor = new Inventor("Nikola Tesla", "city", "country");
        context.setRootObject(inventor);
        //SpEL对于属性名首字母是不区分大小写的
        System.out.println(parser.parseExpression("birthdate.Year").getValue(context));
        System.out.println(parser.parseExpression("birthdate.year").getValue(context));
        System.out.println(parser.parseExpression("Birthdate.Year").getValue(context, Integer.class));
        int year = parser.parseExpression("birthdate.year + 1900").getValue(context, Integer.class);
        System.out.println(year);

        String city = (String) parser.parseExpression("PlaceOfBirth.City").getValue(context);
        System.out.println(city);
    }

    @Test
    public void testCollection() {
        EvaluationContext context = new StandardEvaluationContext();
        SpelParserConfiguration config = new SpelParserConfiguration(true, true);
        parser = new SpelExpressionParser(config);

        Inventor inventor = new Inventor("Nikola Tesla");
        inventor.setInventions(new String[]{"0", "1", "2", "3", "4", "5", "6"});

        String invention = parser.parseExpression("inventions[3]").getValue(
                context, inventor, String.class);
        System.out.println(invention);

        Society society = new Society();
        society.setMembers(Arrays.asList(inventor));
        // Members List
        String name = parser.parseExpression("Members[0].Name").getValue(
                context, society, String.class);
        System.out.println(name);

        // List and Array navigation
        invention = parser.parseExpression("Members[0].Inventions[6]").getValue(context, society, String.class);
        System.out.println(invention);

        PlaceOfBirth placeOfBirth = new PlaceOfBirth();
        inventor.setPlaceOfBirth(placeOfBirth);
        Map officers = new HashMap();
        officers.put("president", inventor);
        officers.put("advisors", Arrays.asList(inventor));
        society.setOfficers(officers);
        // Officer's Dictionary
        Inventor president = parser.parseExpression("Officers['president']").getValue(
                society, Inventor.class);
        System.out.println(president);

        String city = parser.parseExpression("Officers['president'].PlaceOfBirth.City").getValue(
                society, String.class);
        String country = parser.parseExpression("Officers['advisors'][0].PlaceOfBirth.Country").getValue(
                society, String.class);
        System.out.println(city);
        System.out.println(country);

        parser.parseExpression("Officers['president'].PlaceOfBirth.City").setValue(
                society, "Idvor");
        parser.parseExpression("Officers['advisors'][0].PlaceOfBirth.Country").setValue(
                society, "Croatia");
        city = parser.parseExpression("Officers['president'].PlaceOfBirth.City").getValue(
                society, String.class);
        country = parser.parseExpression("Officers['advisors'][0].PlaceOfBirth.Country").getValue(
                society, String.class);
        System.out.println(city);
        System.out.println(country);
        System.out.println(JSON.toJSONString(society));
    }


    @Test
    public void testInline() {
        EvaluationContext context = new StandardEvaluationContext();

        // evaluates to a Java list containing the four numbers
        List numbers = (List) parser.parseExpression("{1,2,3,4}").getValue(context);
        System.out.println(JSON.toJSONString(numbers));

        List listOfLists = (List) parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(context);
        System.out.println(JSON.toJSONString(listOfLists));

        // evaluates to a Java map containing the two entries
        Map inventorInfo = (Map) parser.parseExpression("{name:'Nikola',dob:'10-July-1856'}").getValue(context);
        System.out.println(JSON.toJSONString(inventorInfo));

        Map mapOfMaps = (Map) parser.parseExpression("{name:{first:'Nikola',last:'Tesla'},dob:{day:10,month:'July',year:1856}}").getValue(context);
        System.out.println(JSON.toJSONString(mapOfMaps));
    }

    @Test
    public void testArrayConstruction() {
        EvaluationContext context = new StandardEvaluationContext();

        int[] numbers1 = (int[]) parser.parseExpression("new int[4]").getValue(context);
        System.out.println(JSON.toJSONString(numbers1));

        // Array with initializer
        int[] numbers2 = (int[]) parser.parseExpression("new int[]{1,2,3}").getValue(context);
        System.out.println(JSON.toJSONString(numbers2));

        // Multi dimensional array
        int[][] numbers3 = (int[][]) parser.parseExpression("new int[4][5]").getValue(context);
        System.out.println(JSON.toJSONString(numbers3));

    }

    @Test
    public void testMethod() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        // string literal, evaluates to "bc"
        String bc = parser.parseExpression("'abc'.substring(1, 3)").getValue(String.class);
        System.out.println(bc);

        Society society = new Society();
        context.setRootObject(society);
        // evaluates to true
        boolean isMember = parser.parseExpression("isMember('Mihajlo Pupin')").getValue(context,
                Boolean.class);
        System.out.println(isMember);
    }

    @Test
    public void testOperators() {
        // evaluates to true
        boolean trueValue = parser.parseExpression("2 == 2").getValue(Boolean.class);
        System.out.println(trueValue);

        // evaluates to false
        boolean falseValue = parser.parseExpression("2 < -5.0").getValue(Boolean.class);
        System.out.println(falseValue);

        // evaluates to true
        trueValue = parser.parseExpression("'black' < 'block'").getValue(Boolean.class);
        System.out.println(trueValue);

        trueValue = parser.parseExpression("'black' < 'block'?true:false").getValue(Boolean.class);
        System.out.println(trueValue);

        // evaluates to false
        falseValue = parser.parseExpression(
                "'xyz' instanceof T(Integer)").getValue(Boolean.class);
        System.out.println(falseValue);

        // evaluates to true
        trueValue = parser.parseExpression(
                "'-50.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
        System.out.println(trueValue);

        //evaluates to false
        falseValue = parser.parseExpression(
                "'500.0067' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
        System.out.println(falseValue);
    }

    @Test
    public void testLogicalOperators() {
        Society society = new Society();
        Inventor tesla = new Inventor("Nikola Tesla");
        Inventor pupin = new Inventor("Mihajlo Pupin");
        society.setMembers(Arrays.asList(tesla, pupin));

        StandardEvaluationContext societyContext = new StandardEvaluationContext();
        societyContext.setRootObject(society);

        // -- AND --

        // evaluates to false
        boolean falseValue = parser.parseExpression("true and false").getValue(Boolean.class);
        System.out.println(falseValue);
        // evaluates to true
        String expression = "isMember('Nikola Tesla') and isMember('Mihajlo Pupin')";
        boolean trueValue = parser.parseExpression(expression).getValue(societyContext, Boolean.class);
        System.out.println(trueValue);

        // -- OR --

        // evaluates to true
        trueValue = parser.parseExpression("true or false").getValue(Boolean.class);
        System.out.println(trueValue);

        // evaluates to true
        expression = "isMember('Nikola Tesla') or isMember('Albert Einstein')";
        trueValue = parser.parseExpression(expression).getValue(societyContext, Boolean.class);
        System.out.println(trueValue);

        // -- NOT --

        // evaluates to false
        falseValue = parser.parseExpression("!true").getValue(Boolean.class);
        System.out.println(falseValue);

        // -- AND and NOT --
        expression = "isMember('Nikola Tesla') and !isMember('Mihajlo Pupin')";
        falseValue = parser.parseExpression(expression).getValue(societyContext, Boolean.class);
        System.out.println(falseValue);
    }

    @Test
    public void testMathmaticalOperators() {
        // Addition
        int two = parser.parseExpression("1 + 1").getValue(Integer.class);  // 2

        String testString = parser.parseExpression(
                "'test' + ' ' + 'string'").getValue(String.class);  // 'test string'

        // Subtraction
        int four = parser.parseExpression("1 - -3").getValue(Integer.class);  // 4

        double d = parser.parseExpression("1000.00 - 1e4").getValue(Double.class);  // -9000

        // Multiplication
        int six = parser.parseExpression("-2 * -3").getValue(Integer.class);  // 6

        double twentyFour = parser.parseExpression("2.0 * 3e0 * 4").getValue(Double.class);  // 24.0

        // Division
        int minusTwo = parser.parseExpression("6 / -3").getValue(Integer.class);  // -2

        double one = parser.parseExpression("8.0 / 4e0 / 2").getValue(Double.class);  // 1.0

        // Modulus
        int three = parser.parseExpression("7 % 4").getValue(Integer.class);  // 3

        int oneI = parser.parseExpression("8 / 5 % 2").getValue(Integer.class);  // 1

        // Operator precedence
        int minusTwentyOne = parser.parseExpression("1+2-3*8").getValue(Integer.class);  // -21
    }

    @Test
    public void testAssignment() {
        Inventor inventor = new Inventor();
        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();

        parser.parseExpression("Name").setValue(context, inventor, "Aleksandar Seovic");
        System.out.println(JSON.toJSONString(inventor));
        // alternatively
        parser.parseExpression("Name = 'Aleksandar Seovic 2'").getValue(inventor);
        System.out.println(JSON.toJSONString(inventor));

    }

    @Test
    public void testTypes() {
        Class dateClass = parser.parseExpression("T(java.util.Date)").getValue(Class.class);
        System.out.println(dateClass);

        Class stringClass = parser.parseExpression("T(String)").getValue(Class.class);
        System.out.println(stringClass);

        boolean trueValue = parser.parseExpression(
                        "T(java.math.RoundingMode).CEILING < T(java.math.RoundingMode).FLOOR")
                .getValue(Boolean.class);
        System.out.println(trueValue);
    }

    @Test
    public void testConstructors() {
        Object o = parser.parseExpression("new java.math.BigDecimal('1.0')").getValue();
        System.out.println(JSON.toJSONString(o));

    }

    @Test
    public void testVariables() {
        Inventor tesla = new Inventor("Nikola Tesla");

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("newName", "Mike Tesla");
        System.out.println(tesla.getName()); // "Nikola Tesla"
        parser.parseExpression("Name = #newName").getValue(context, tesla);
        System.out.println(tesla.getName()); // "Mike Tesla"

        List<Integer> primes = new ArrayList<>();
        primes.addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17));

        // create parser and set variable 'primes' as the array of integers
        ExpressionParser parser = new SpelExpressionParser();

        context.setVariable("primes", primes);
        context.setRootObject(tesla);
        // all prime numbers > 10 from the list (using selection ?{...})
        // evaluates to [11, 13, 17]
        List<Integer> primesGreaterThanTen = (List<Integer>) parser.parseExpression(
                "#primes.?[#this>10]").getValue(context);
        System.out.println(primesGreaterThanTen);

        Object root = parser.parseExpression("#root").getValue(context);
        System.out.println(JSON.toJSONString(root));

        Object thisObj = parser.parseExpression("#this").getValue(context);
        System.out.println(JSON.toJSONString(thisObj));
    }

    @Test
    public void testFunction() {
        try {
            context.registerFunction("add1", SpELExecutor.class.getMethod("add", List.class));
            context.setVariable("add2", SpELExecutor.class.getMethod("add", List.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        BigDecimal result = parser.parseExpression("#add1({1,2})").getValue(context, BigDecimal.class);
        System.out.println(result);
        result = parser.parseExpression("#add2({1,2,3})").getValue(context, BigDecimal.class);
        System.out.println(result);

    }

    @Test
    public void testBeanReferences() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        Inventor inventor = new Inventor("Nikola Tesla", "Serbian", "Serbian");
        factory.registerSingleton("inventor", inventor);
        context.setBeanResolver(new BeanFactoryResolver(factory));

        Inventor inventorBean = parser.parseExpression("@inventor").getValue(context, Inventor.class);
        System.out.println(JSON.toJSONString(inventorBean));
        System.out.println(inventor == inventorBean);
        System.out.println(factory.getBean("inventor") == inventorBean);

        Object value;
        value = parser.parseExpression("@inventor.getPlaceOfBirth()").getValue(context);
        System.out.println(JSON.toJSONString(value));

        value = parser.parseExpression("@inventor.placeOfBirth").getValue(context);
        System.out.println(JSON.toJSONString(value));

    }

    @Test
    public void testTernaryOperator() {
        Society society = new Society();
        society.setMembers(Arrays.asList(new Inventor("Nikola Tesla")));
        context.setRootObject(society);
        parser.parseExpression("Name").setValue(context, "IEEE");
        context.setVariable("queryName", "Nikola Tesla");

        String expression = "isMember(#queryName)? #queryName + ' is a member of the ' " +
                "+ Name + ' Society' : #queryName + ' is not a member of the ' + Name + ' Society'";

        String queryResultString = parser.parseExpression(expression)
                .getValue(context, String.class);
        // queryResultString = "Nikola Tesla is a member of the IEEE Society"
        System.out.println(queryResultString);
        System.out.println(JSON.toJSONString(society));

    }

    @Test
    public void testElvisOperator() {
        Inventor tesla = new Inventor("Nikola Tesla", "", "Serbian");
        String name = parser.parseExpression("Name?:'Elvis Presley'").getValue(context, tesla, String.class);
        System.out.println(name);  // Nikola Tesla

        tesla.setName(null);
        name = parser.parseExpression("Name?:'Elvis Presley'").getValue(context, tesla, String.class);
        System.out.println(name);  // Elvis Presley
    }

    @Test
    public void testSafeNavigationOperator() {
        Inventor tesla = new Inventor("Nikola Tesla", "Smiljan", "Serbian");

        String city = parser.parseExpression("PlaceOfBirth?.City").getValue(context, tesla, String.class);
        System.out.println(city);  // Smiljan

        tesla.setPlaceOfBirth(null);
        try {
            city = parser.parseExpression("PlaceOfBirth.City").getValue(context, tesla, String.class);
        } catch (Exception e) {
            System.out.println(e);
        }

        city = parser.parseExpression("PlaceOfBirth?.City").getValue(context, tesla, String.class);
        System.out.println(city);  // null - does not throw NullPointerException!!!
    }

    @Test
    public void testCollectionSelection() {
        Society society = new Society();
        Inventor tesla = new Inventor("Nikola Tesla", "Smiljan", "Serbian");
        society.addMember(tesla);

        context.setRootObject(society);
        context.setVariable("source", society);
        List<Inventor> list = (List<Inventor>) parser.parseExpression(
                "Members.?[Nationality == 'German']").getValue(context);
        System.out.println(list);

        list = (List<Inventor>) parser.parseExpression(
                "Members.?[Nationality == 'Serbian']").getValue(context);
        System.out.println(list);

        list = (List<Inventor>) parser.parseExpression(
                "#source.Members.?[Nationality == 'Serbian']").getValue(context);
        System.out.println(list);

        // Map 选取
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 20);
        map.put("2", 27);
        map.put("3", 28);

        Object value;
        value = parser.parseExpression("?[value<=27]").getValue(map, Map.class);
        System.out.println(JSON.toJSONString(value));

        value = parser.parseExpression("?[#this.getValue()<=27]").getValue(map, Map.class);
        System.out.println(JSON.toJSONString(value));


        value = parser.parseExpression("?[key>='2']").getValue(map, Map.class);
        System.out.println(JSON.toJSONString(value));


        value = parser.parseExpression("^[key>='2'].entrySet()").getValue(map);
        System.out.println(JSON.toJSONString(value));

        value = parser.parseExpression("$[key>='2']").getValue(map);
        System.out.println(JSON.toJSONString(value));

        //List 选取
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);


        value = parser.parseExpression("?[#this>=2]").getValue(integerList);
        System.out.println(value);

        value = parser.parseExpression("^[#this>=2]").getValue(integerList);
        System.out.println(value);

        value = parser.parseExpression("$[#this>=2]").getValue(integerList);
        System.out.println(value);

    }

    /**
     * 集合投影,返回列表
     */
    @Test
    public void testCollectionProjection() {
        Society society = new Society();
        Inventor tesla = new Inventor("Nikola Tesla", "Smiljan", "Serbian");
        Inventor tesla2 = new Inventor("Nikola Tesla 2", "Smiljan", "Serbian");
        Inventor tesla3 = new Inventor("Nikola Tesla 3");
        society.addMember(tesla);
        society.addMember(tesla2);
        society.addMember(tesla3);

        context.setRootObject(society);

        List placesOfBirth = (List) parser.parseExpression("Members.![placeOfBirth?.city]").getValue(context);
        System.out.println(JSON.toJSONString(placesOfBirth));
        //Map
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 20);
        map.put("2", 27);
        map.put("3", 28);

        Object value;
        value = parser.parseExpression("![key>='2']").getValue(map);
        System.out.println(JSON.toJSONString(value));

        value = parser.parseExpression("![#this.getKey()>='2']").getValue(map);
        System.out.println(JSON.toJSONString(value));


        value = parser.parseExpression("![#this.value+1]").getValue(map);
        System.out.println(JSON.toJSONString(value));

        //#this表示集合的当前元素，可省略
        value = parser.parseExpression("![value+1]").getValue(map);
        System.out.println(JSON.toJSONString(value));

        //List
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        value = parser.parseExpression("![#this]").getValue(integerList);
        System.out.println(JSON.toJSONString(value));

        value = parser.parseExpression("![#this+1]").getValue(integerList);
        System.out.println(JSON.toJSONString(value));


    }

    @Test
    public void ExpressionTemplating() {

        Object value;

        value = parser.parseExpression("random number is #{T(java.lang.Math).random()}", new TemplateParserContext()).getValue();
        System.out.println(value);

        ParserContext parserContext = new TemplateParserContext("${", "}");
        value = parser.parseExpression("random number is ${T(java.lang.Math).random()}", parserContext).getValue();
        System.out.println(value);

        context.setVariable("name", "Tesla");
        value = parser.parseExpression("name:${#name}", parserContext).getValue(context);
        System.out.println(value);

    }

    public class SimpleDemo {
        public List<Boolean> booleanList = new ArrayList<>();
        public List<String> list;
    }

    @Data
    @NoArgsConstructor
    public class Inventor {

        private String name;
        private String nationality;
        private String[] inventions;
        private Date birthdate;
        private PlaceOfBirth placeOfBirth;

        public Inventor(String name) {
            this.name = name;
            this.birthdate = new Date();
        }

        public Inventor(String name, String city, String country) {
            this.name = name;
            this.nationality = country;
            this.birthdate = new Date();
            this.placeOfBirth = new PlaceOfBirth();
            placeOfBirth.setCity(city);
            placeOfBirth.setCountry(country);
        }
    }

    @Data
    public class PlaceOfBirth {

        private String city;
        private String country;
    }

    @Data
    public class Society {

        private String name;

        public String advisors = "advisors";
        public String president = "president";

        private List<Inventor> members = new ArrayList<>();
        private Map officers = new HashMap();

        public boolean isMember(String name) {
            for (Inventor inventor : members) {
                if (inventor.getName().equals(name)) {
                    return true;
                }
            }
            return false;
        }

        public void addMember(Inventor inventor) {
            members.add(inventor);
        }

    }
}