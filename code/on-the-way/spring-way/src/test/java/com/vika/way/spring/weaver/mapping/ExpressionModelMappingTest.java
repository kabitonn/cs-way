package com.vika.way.spring.weaver.mapping;

import com.alibaba.fastjson.JSONObject;
import com.vika.way.spring.utils.FileReadUtils;
import com.vika.way.spring.weaver.executor.ExecutionContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author chenwei.tjw
 * @date 2022/12/22
 **/
public class ExpressionModelMappingTest {


    @Before
    public void setUp() {

    }

    @Test
    public void testMapping() throws Exception {
        JSONObject source = FileReadUtils.readObject("erp/input_content.json", JSONObject.class);
        JSONObject target = new JSONObject();

        List<ModelMappingDTO> mappingDTOList = new ArrayList<>();
        mappingDTOList.add(new ModelMappingDTO("#target['mainContractList']={new java.util.HashMap()}"));
        mappingDTOList.add(new ModelMappingDTO("#target['mainContractList'][i]['IsAccessoryContract']=#source['IsAccessoryContract']"));
        mappingDTOList.add(new ModelMappingDTO("#target['mainContractList'][i]['principalContract']=#source['principalContract']"));

        ModelMapping modelMapping = new ExpressionModelMapping(MappingTypeEnum.MODEL_MAPPING, mappingDTOList);
        modelMapping.setSourceObject(source);
        modelMapping.setTargetObject(target);

        Boolean result = modelMapping.execute(new ExecutionContext());
        System.out.println(target);
    }


}

