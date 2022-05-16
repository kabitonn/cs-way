package com.vika.way.srpc.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * RPC返回结果
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
@Data
public class RpcResponse implements Serializable {
    private static final long serialVersionUID = 7932067669933360614L;

    private String requestId;

    private String error;

    private Object result;
}
