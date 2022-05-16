package com.vika.way.srpc.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * RPC请求
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
@Data
public class RpcRequest implements Serializable {

    private static final long serialVersionUID = -8621833534438443285L;

    private String requestId;
    private String className;
    private String methodName;
    private String serviceVersion;
    private Class<?>[] parameterTypes;
    private Object[] parameters;

}
