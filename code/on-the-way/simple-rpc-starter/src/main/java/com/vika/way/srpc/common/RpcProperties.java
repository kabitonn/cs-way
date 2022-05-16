package com.vika.way.srpc.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * RPC配置参数
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
@Data
@ConfigurationProperties(prefix = "simple.rpc")
public class RpcProperties {
    private String serviceAddress;

    private String serviceRegistryAddress;

    private String serviceRegistryType;
}
