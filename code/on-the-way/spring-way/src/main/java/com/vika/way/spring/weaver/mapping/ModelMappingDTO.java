package com.vika.way.spring.weaver.mapping;

import lombok.Data;
import org.apache.commons.lang.StringUtils;

import static com.vika.way.spring.weaver.utils.ExpressionParserUtils.getSourceField;
import static com.vika.way.spring.weaver.utils.ExpressionParserUtils.getTargetField;

/**
 * @author chenwei.tjw
 * @date 2022/12/22
 **/
@Data
public class ModelMappingDTO {

    /**
     * 模型映射前置校验表达式，可为空
     */
    private String validateExpression;

    /**
     * 模型映射前置校验的字段，可为空
     */
    private String validateFiled;

    /**
     * 模型映射表达式
     */
    private String expression;

    /**
     * 模型映射来源字段
     */
    private String sourceMappingFiled;

    /**
     * 模型映射目标字段
     */
    private String targetMappingField;

    /**
     * 模型映射结果类型转换，可为空
     */
    private String mappingCastClass;


    /**
     * 是否需要校验
     * @return
     */
    public boolean needValidate() {
        if(StringUtils.isBlank(validateExpression) ||
                StringUtils.isBlank(validateFiled)) {
            return false;
        }

        return true;
    }


    public ModelMappingDTO(String expression) {
        this.expression = expression;
        if(StringUtils.isEmpty(expression)) {
            throw new RuntimeException("expression is null");
        }

        this.sourceMappingFiled = getSourceField(expression);
        this.targetMappingField = getTargetField(expression);
    }

    public ModelMappingDTO(String expression, String sourceMappingFiled, String targetMappingField) {
        this.expression = expression;
        this.sourceMappingFiled = sourceMappingFiled;
        this.targetMappingField = targetMappingField;
        if(expression == null) {
            throw new RuntimeException("expression is null");
        }

        if(StringUtils.isEmpty(sourceMappingFiled)) {
            this.sourceMappingFiled = getSourceField(expression);
        }

        if(StringUtils.isEmpty(targetMappingField)) {
            this.targetMappingField = getTargetField(expression);
        }

    }

    public ModelMappingDTO(String expression, String sourceMappingFiled, String targetMappingField, String mappingCastClass) {
        this(expression, sourceMappingFiled, targetMappingField);
        this.mappingCastClass = mappingCastClass;
    }

    public ModelMappingDTO(String validateExpression, String validateFiled, String expression, String sourceMappingFiled, String targetMappingField) {
        this(expression, sourceMappingFiled, targetMappingField);
        this.validateExpression = validateExpression;
        this.validateFiled = validateFiled;
    }

    public ModelMappingDTO(String validateExpression, String validateFiled, String expression, String sourceMappingFiled, String targetMappingField, String mappingCastClass) {
        this(expression, sourceMappingFiled, targetMappingField);
        this.validateExpression = validateExpression;
        this.validateFiled = validateFiled;
        this.mappingCastClass = mappingCastClass;
    }

}
