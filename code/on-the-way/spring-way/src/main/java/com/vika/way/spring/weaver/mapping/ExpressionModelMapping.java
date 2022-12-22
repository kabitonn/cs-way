package com.vika.way.spring.weaver.mapping;

import com.vika.way.spring.weaver.constans.WeaverExecuteLangEnum;
import com.vika.way.spring.weaver.executor.ExecutionContext;
import com.vika.way.spring.weaver.expression.ExpressionExecutionUnit;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.vika.way.spring.weaver.constans.WeaverExecuteCommonConstant.*;
import static com.vika.way.spring.weaver.utils.ExpressionParserUtils.*;

/**
 * 表达式模型映射
 *
 * @author chenwei.tjw
 * @date 2022/12/22
 **/
@Data
public class ExpressionModelMapping extends ModelMapping {


    /**
     * 映射类型
     */
    private MappingTypeEnum mappingTypeEnum;

    /**
     * 表达式语言
     */
    private WeaverExecuteLangEnum executeLangEnum = WeaverExecuteLangEnum.SpEL;

    /**
     * 模型映射DTO
     */
    private List<ModelMappingDTO> mappingDTOList;

    /**
     * 短路校验
     */
    private boolean isShortCircuit = true;

    public ExpressionModelMapping(MappingTypeEnum mappingTypeEnum, List<ModelMappingDTO> mappingDTOList) {
        this.mappingTypeEnum = mappingTypeEnum;
        this.mappingDTOList = mappingDTOList;
    }

    public ExpressionModelMapping(MappingTypeEnum mappingTypeEnum, WeaverExecuteLangEnum executeLangEnum, List<ModelMappingDTO> mappingDTOList) {
        this.mappingTypeEnum = mappingTypeEnum;
        this.executeLangEnum = executeLangEnum;
        this.mappingDTOList = mappingDTOList;
    }

    public ExpressionModelMapping(MappingTypeEnum mappingTypeEnum, WeaverExecuteLangEnum executeLangEnum, List<ModelMappingDTO> mappingDTOList, boolean isShortCircuit) {
        this.mappingTypeEnum = mappingTypeEnum;
        this.executeLangEnum = executeLangEnum;
        this.mappingDTOList = mappingDTOList;
        this.isShortCircuit = isShortCircuit;
    }

    @Override
    Boolean mapping(Object sourceObject, Object targetObject, ExecutionContext executionContext) {
        if (null == targetObject || null == sourceObject) {
            return Boolean.TRUE;
        }
        executionContext.setVariable(BUILT_IN_MAPPING_SOURCE, sourceObject);
        executionContext.setVariable(BUILT_IN_MAPPING_TARGET, targetObject);

        if (mappingTypeEnum.equals(MappingTypeEnum.INPUT_PARAM_MAPPING)) {

        } else if (mappingTypeEnum.equals(MappingTypeEnum.MODEL_MAPPING)) {
            return modelMapping(executionContext);
        } else if (mappingTypeEnum.equals(MappingTypeEnum.OUTPUT_PARAM_MAPPING)) {

        }

        return Boolean.TRUE;
    }

    /**
     * 模型映射
     *
     * @param executionContext
     * @return
     */
    public Boolean modelMapping(ExecutionContext executionContext) {

        if (CollectionUtils.isEmpty(mappingDTOList)) {
            return Boolean.TRUE;
        }

        Set<String> errorSet = new HashSet<>(mappingDTOList.size());
        Throwable latestThrowable = null;
        boolean isValidateFailed = false;

        for (ModelMappingDTO mappingDTO : mappingDTOList) {
            if (mappingDTO.needValidate()) {
                ExpressionExecutionUnit validatorExecutionUnit = new ExpressionExecutionUnit(mappingDTO.getValidateExpression());
                boolean valid = (Boolean) validatorExecutionUnit.execute(executionContext);
                // 校验不通过直接跳过
                if (!valid) {
                    continue;
                }
            }

            for (String expression : getRealExpression(mappingDTO.getExpression())) {
                try {
                    int degree = getCyclesDegree(mappingDTO.getSourceMappingFiled());
                    execute0(expression, degree, executionContext, errorSet);
                } catch (Throwable e) {
                    latestThrowable = e;
                    errorSet.add(mappingDTO.getExpression());
                    if (isShortCircuit) {
                        throw new ModelMappingException(e, executionContext.getVariables(), errorSet);
                    }
                }
            }
        }

        if (null != latestThrowable) {
            throw new ModelMappingException(latestThrowable, executionContext.getVariables(), errorSet);
        }

        if (CollectionUtils.isNotEmpty(errorSet)) {
            executionContext.setVariable(VALIDATE_RESULT_PLACEHOLDER, errorSet);
        }

        if (isValidateFailed) {
            return false;
        }

        return CollectionUtils.isEmpty(errorSet);
    }

    /**
     * 递归执行
     *
     * @param expression
     * @param degree
     * @param executionContext
     * @param errorSet
     * @return
     */
    private boolean execute0(String expression, int degree, ExecutionContext executionContext, Set<String> errorSet) {
        if (degree <= 0) {
            // source degree == 0时直接取expression的degree
            int targetDegree = getCyclesDegree(expression);
            if (targetDegree <= 0) {
                try {
                    ExpressionExecutionUnit executionUnit = new ExpressionExecutionUnit(expression, executeLangEnum);
                    executionUnit.execute(executionContext);
                } catch (Throwable e) {
                    errorSet.add(expression);
                    if (isShortCircuit) {
                        throw e;
                    }
                }
            } else {
                // target层级比source层级高时再循环target执行，注意：该循环可能由于target结构体尚未初始化而存在潜在风险，使用场景有限
                int size = getListSizeByDegree(getTargetField(expression), 1, executionContext);
                for (int i = 0; i < size; i++) {
                    // [i][j][k]... -> [num][i][j]...
                    String temp = downgrade(expression, i);
                    try {
                        ExpressionExecutionUnit executionUnit = new ExpressionExecutionUnit(temp, executeLangEnum);
                        executionUnit.execute(executionContext);
                    } catch (Throwable e) {
                        errorSet.add(expression);
                        if (isShortCircuit) {
                            throw e;
                        }
                    }
                }
            }
            return true;
        }

        // 处理第一层循环
        String sourceField = getSourceField(expression);
        int size = getListSizeByDegree(sourceField, 1, executionContext);
        for (int i = 0; i < size; i++) {
            // [i][j][k]... -> [num][i][j]...
            String temp = downgrade(expression, i);
            execute0(temp, degree - 1, executionContext, errorSet);
        }

        if (degree == 1) {
        }
        return true;
    }

}
