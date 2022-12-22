package com.vika.way.spring.weaver.constans;

/**
 * 编织内置常量
 */
public class WeaverExecuteCommonConstant {

    /**
     * 内置井号
     */
    public final static String BUILT_IN_PREFIX_HASHTAG = "#";

    /**
     * 内置$号
     */
    public final static String BUILT_IN_DOLLAR_PREFIX_HASHTAG = "$";

    /**
     * 映射来源占位符
     */
    public final static String BUILT_IN_MAPPING_SOURCE = "source";

    /**
     * 映射来源占位符(附单据)
     */
    public final static String BUILT_IN_MAPPING_SOURCE_EXTRA = "source_extra";

    /**
     * 映射目标占位符
     */
    public final static String BUILT_IN_MAPPING_TARGET = "target";

    /**
     * 表达式多行分隔符
     */
    public final static String EXPRESSION_MULTIPLE_STATEMENT_DELIMITER = ";";

    /**
     * 子模型列表游标占位符
     */
    public final static String SUB_MODEL_CURSOR_PLACEHOLDER = "[i]";

    /**
     * 子模型属于列表游标占位符
     */
    public final static String SUB_MODEL_ATTR_CURSOR_PLACEHOLDER = "[j]";

    /**
     * 第三层循环
     */
    public final static String SUB_MODEL_THIRD_CURSOR_PLACEHOLDER = "[k]";

    /**
     * 表达式赋值等号占位符
     */
    public final static String EXPRESSION_ASSIGNMENT_PLACEHOLDER = "=";

    /**
     * 多重校验结果占位符
     */
    public final static String VALIDATE_RESULT_PLACEHOLDER = "@RESULT";

    /**
     * 合并调用标识符
     */
    public final static String MERGE_SERVICE_INVOKE_PLACEHOLDER = "@MERGE";

    /**
     * 模型数组平铺标识符,该标识符需放置到平铺数组后
     * 例如#source.get('payload').line[i].get('logicItems')[k]`
     * 务必保证表达式层次小于等于2
     *
     */
    public final static String MODEL_ARRAY_FLAT_PLACEHOLDER = "`";

    /**
     * 默认分页查询大小
     */
    public final static int SERVICE_PAGE_NUMBER_DEFAULT = 100;
}
