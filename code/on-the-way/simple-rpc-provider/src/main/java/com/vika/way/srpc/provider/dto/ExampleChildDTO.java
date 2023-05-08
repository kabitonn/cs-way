package com.vika.way.srpc.provider.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenwei.tjw
 * @date 2023/3/2
 **/
@Data
public class ExampleChildDTO extends ExampleParentDTO {

    private static final long serialVersionUID = -4899745165076102185L;

    private String name;

    private String nameAlias;
}
