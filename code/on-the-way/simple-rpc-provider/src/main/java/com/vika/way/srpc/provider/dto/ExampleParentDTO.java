package com.vika.way.srpc.provider.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenwei.tjw
 * @date 2023/3/2
 **/
@Data
public class ExampleParentDTO implements Serializable {

    private static final long serialVersionUID = 5893113804948766721L;

    private String name;

    protected String nameAlias;
}
