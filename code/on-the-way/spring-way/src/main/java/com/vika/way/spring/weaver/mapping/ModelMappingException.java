package com.vika.way.spring.weaver.mapping;

import lombok.Data;

import java.util.Set;

/**
 * 模型映射异常
 */
@Data
public class ModelMappingException extends RuntimeException {

    /**
     * 执行表达式时的上下文
     */
    private Object context;

    /**
     * 执行异常的表达式列表
     */
    private Set mappingDTOList;

    /**
     * 标识是否校验不通过
     */
    private boolean isValidateFailed = false;

    /**
     * 不允许无参构造
     */
    private ModelMappingException() {

    }

    /**
     * 强制传入cause，防止误用构造器丢失stackTrace信息
     * @param cause
     * @param mappingDTOList
     * @param context
     */
    public ModelMappingException(Throwable cause, Object context, Set mappingDTOList) {
        super(cause);
        this.context = context;
        this.mappingDTOList = mappingDTOList;
    }

    /**
     * 校验不通过构造器
     * @param isValidateFailed
     * @param context
     * @param mappingDTOList
     */
    public ModelMappingException(boolean isValidateFailed, Object context, Set<ModelMappingDTO> mappingDTOList) {
        this.context = context;
        this.mappingDTOList = mappingDTOList;
        this.isValidateFailed = isValidateFailed;
    }

    /**
     * 校验不通过构造器
     * @param isValidateFailed
     * @param context
     * @param mappingDTOList
     */
    public ModelMappingException(Throwable cause, boolean isValidateFailed, Object context, Set mappingDTOList) {
        super(cause);
        this.context = context;
        this.mappingDTOList = mappingDTOList;
        this.isValidateFailed = isValidateFailed;
    }
}
