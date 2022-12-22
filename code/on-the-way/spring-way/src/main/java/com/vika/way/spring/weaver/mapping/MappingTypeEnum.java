package com.vika.way.spring.weaver.mapping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum MappingTypeEnum {

    INPUT_PARAM_MAPPING("INPUT_PARAM_MAPPING", "入参映射"),
    OUTPUT_PARAM_MAPPING("OUTPUT_PARAM_MAPPING", "出参映射"),
    MODEL_MAPPING("MODEL_MAPPING", "模型映射"),
    ;

    private String name;

    private String desc;
}
