package com.vika.way.srpc.common;

import lombok.AllArgsConstructor;

/**
 * Rpc异常
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
@AllArgsConstructor
public class RpcException extends RuntimeException {
    private static final long serialVersionUID = -3861619476424257548L;

    private String errorCode;

    private String errorMessage;
}
