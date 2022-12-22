package com.vika.way.spring.weaver.utils;

import com.alibaba.fastjson.JSON;
import com.vika.way.spring.weaver.executor.ExecutionContext;
import com.vika.way.spring.weaver.expression.ExpressionExecutionUnit;
import com.vika.way.spring.weaver.expression.SpELExecutor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.expression.spel.SpelNode;
import org.springframework.expression.spel.ast.Indexer;
import org.springframework.expression.spel.ast.MethodReference;
import org.springframework.expression.spel.ast.VariableReference;

import java.util.*;

import static com.vika.way.spring.weaver.constans.WeaverExecuteCommonConstant.*;

/**
 * @author chenwei.tjw
 * @date 2022/12/22
 **/
public class ExpressionParserUtils {


    /**
     * split 'EXPRESSION_MULTIPLE_STATEMENT_DELIMITER' 获取真正的执行表达式
     * @param expression
     * @return
     */
    public static List<String> getRealExpression(String expression) {
        if(StringUtils.isBlank(expression)) {
            return new ArrayList<>();
        }
        // trim \n\r
        String[] split = expression.replace(System.getProperty("line.separator"), "").split(EXPRESSION_MULTIPLE_STATEMENT_DELIMITER);
        //兼容线上采购老逻辑，将#$root均替换为#source
        List<String> replaceList = new ArrayList<>(split.length);
        for (String s : split) {
            if(StringUtils.isNotBlank(s)) {
                replaceList.add(s.replace("#$root", "#source").trim());
            }
        }
        return replaceList;
    }

    /**
     * 获取表达式隐含循环度数,即org.springframework.expression.spel.ast.Indexer的最高层级
     * i,j,k代表degree=1,2,3
     *
     * @param expression
     * @return
     */
    public static int getCyclesDegree(String expression) {
        if (StringUtils.isEmpty(expression) || expression.length() <= 2) {
            return 0;
        }

        int length = 0;
        for (int i = 0; i < expression.length() - 2; i++) {
            if ('[' == expression.charAt(i) && ']' == expression.charAt(i + 2)) {
                char temp = expression.charAt(i + 1);
                length = Math.max(length, temp - 'i' + 1);
            } else {
                continue;
            }
        }
        return length;
    }

    /**
     * 对表达式降级,即[i][j][k]... -> [placeNum][i][j]...
     *
     * @param expression
     * @param placeNum
     * @return
     */
    public static String downgrade(String expression, int placeNum) {
        if (StringUtils.isEmpty(expression) || expression.length() <= 2) {
            return expression;
        }

        char[] expressionArray = expression.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expressionArray.length; ) {
            // 如果只有'['而没有']'则数据越界报错，提示表达式语法有误;因此无须判断是否越界
            if ('[' == expressionArray[i] && ']' == expressionArray[i + 2]) {
                char temp = expressionArray[i + 1];
                if (temp == 'i') {
                    String indexStr = String.valueOf(placeNum);
                    // 如果'['前一个字符不是字母或者']'说明不是数组，需要将[i] -> i
                    if (i - 1 >= 0 && (!Character.isAlphabetic(expressionArray[i - 1]) && expressionArray[i - 1] != ']' && expressionArray[i - 1] != ')')) {
                        sb.append(indexStr);
                    } else {
                        sb.append('[').append(indexStr).append(']');
                    }
                } else if (temp > 'i') {
                    sb.append('[').append((char) (expressionArray[i + 1] - 1)).append(']');
                } else {
                    sb.append('[').append(temp).append(']');
                }
                i += 3;
            } else {
                sb.append(expressionArray[i]);
                i++;
            }

        }

        return sb.toString();
    }

    /**
     * 获取字段表达式指定循环次数的列表的大小
     * @param fieldExpression 支持rootField/sourceField/targetField
     * @param degree
     * @param executionContext
     * @return
     */
    public static int getListSizeByDegree(String fieldExpression, int degree, ExecutionContext executionContext) {
        if(degree <= 0) {
            return 1;
        }
        String expressionTemp = null;
        // 截取"="前内容，兼容使用"="做赋值语句；建议釆用.set()方法设置值
        expressionTemp = StringUtils.substringBefore(fieldExpression, EXPRESSION_ASSIGNMENT_PLACEHOLDER);
        // 截取列表层级标识符前的表达式
        expressionTemp = StringUtils.substringBefore(expressionTemp, String.join("","[", String.valueOf((char) ('i' + degree - 1)),"]"));

        return getListSize(fieldExpression, executionContext, expressionTemp);
    }

    /**
     * 获取字段表达式指定列表的大小
     * @param fieldExpression 原字段公式
     * @param executionContext
     * @param expressionTemp 层级表达式
     * @return
     */
    private static int getListSize(String fieldExpression, ExecutionContext executionContext, String expressionTemp) {
        ExpressionExecutionUnit<Object> executionUnit = new ExpressionExecutionUnit(expressionTemp);
        Object result = executionUnit.execute(executionContext);
        //如果获取到的列表层级为空,则返回层级长度为0
        if (result == null) {
            return 0;
        }
        if(result.getClass().isArray()) {
            return ((Object[])result).length;
        }

        if(result instanceof Collection) {
            return ((Collection<Object>)result).size();
        }

        throw new RuntimeException(
                new StringBuffer()
                        .append(expressionTemp)
                        .append(" in ")
                        .append(fieldExpression)
                        .append(" isn't instanceof Collection or Array,please check. Context: ")
                        .append(JSON.toJSONString(executionContext.getVariables()))
                        .toString()
        );
    }



    /**
     * 获取#source字段
     * @param expression
     * @return
     */
    public static String getSourceField(String expression) {
        if (StringUtils.isBlank(expression)) {
            return "";
        }
        SpelNode node = SpELExecutor.getSpELNode(expression);
        if(null != node) {
            return getSourceFieldFromNode(node);
        }
        return "";
    }

    /**
     * 获取target字段
     * @param expression
     * @return
     */
    public static String getTargetField(String expression) {
        if (StringUtils.isBlank(expression)) {
            return "";
        }
        SpelNode node = SpELExecutor.getSpELNode(expression);
        if(null != node) {
            return getTargetFieldFromNode(node);
        }
        return "";
    }
    /**
     * 获取#source字段
     *
     * @param node
     * @return
     */
    public static String getSourceFieldFromNode(SpelNode node) {
        return getMaxDegreeFieldFromNode(node, BUILT_IN_PREFIX_HASHTAG + BUILT_IN_MAPPING_SOURCE);
    }

    /**
     * 获取target字段
     * @param node
     * @return
     */
    public static String getTargetFieldFromNode(SpelNode node) {
        return getMaxDegreeFieldFromNode(node, BUILT_IN_PREFIX_HASHTAG + BUILT_IN_MAPPING_TARGET);
    }

    /**
     * 获取最大深度的field
     * @param node
     * @param fieldIdentifier
     * @return
     */
    public static String getMaxDegreeFieldFromNode(SpelNode node, String fieldIdentifier) {
        Set<String> fieldsList = getFieldListFromNode(node, fieldIdentifier);
        return getMaxDegreeField(fieldsList);
    }
    /**
     * 获取保存fieldIdentifier的所有field
     * @param node
     * @param fieldIdentifier
     * @return
     */
    public static Set<String> getFieldListFromNode(SpelNode node, String fieldIdentifier) {
        return getFieldExpression(node, null, fieldIdentifier, new HashSet<>());
    }


    /**
     * 获取循环次数最高的表达式
     * @param fieldsList
     * @return
     */
    public static String getMaxDegreeField(Set<String> fieldsList) {
        if(CollectionUtils.isNotEmpty(fieldsList)) {
            String expression = null;
            int maxDegree = -1;
            for(String field : fieldsList) {
                int temp = getCyclesDegree(field);
                if(temp > maxDegree) {
                    maxDegree = temp;
                    expression = field;
                }
            }

            return expression;
        }
        return null;
    }

    /**
     * 从SpelNode中提取 root/target/source等目标字段
     * 注意：SPEL实现toStringAST在Indexer场景下存在bug,因此需要replace(".[","[")
     * @param node
     * @param parent
     * @param fieldIdentifier
     * @param fieldsSet 共享匹配字段集合
     * @return
     */
    public static Set<String> getFieldExpression(SpelNode node, SpelNode parent, String fieldIdentifier, Set<String> fieldsSet) {
        if(null == node) {
            return fieldsSet;
        }

        if(!node.toStringAST().contains(fieldIdentifier)) {
            return fieldsSet;
        }

        if (node.getChildCount() == 0) {
            // 如果node就是字段标识，如果没有父结点，则直接返回；否则从父节点的第一个子结点开始加载
            if (null == parent) {
                fieldsSet.add(node.toStringAST().replace(".[","["));
            }else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < parent.getChildCount(); i++) {
                    SpelNode spelNode = parent.getChild(i);
                    if(spelNode instanceof VariableReference) {
                        sb.append(spelNode.toStringAST());
                    }else if (spelNode instanceof Indexer) {
                        sb.append(spelNode.toStringAST());
                    }else if(spelNode instanceof MethodReference) {
                        sb.append(".");
                        sb.append(spelNode.toStringAST());
                    }else {
                        sb.append(".");
                        sb.append(spelNode.toStringAST());
                    }
                }
                fieldsSet.add(sb.toString().replace(".[","["));
            }
            return fieldsSet;
        } else {
            for (int i = 0; i < node.getChildCount(); i++) {
                SpelNode child = node.getChild(i);
                getFieldExpression(child, node, fieldIdentifier, fieldsSet);
            }
        }

        return fieldsSet;
    }
}
