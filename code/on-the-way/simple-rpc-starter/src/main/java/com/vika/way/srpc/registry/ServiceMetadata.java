package com.vika.way.srpc.registry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 服务元数据
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceMetadata {
    /**
     * 服务名
     */
    private String serviceName;

    /**
     * 服务版本
     */
    private String serviceVersion;

    /**
     * 服务提供方的地址
     */
    private String address;

    /**
     * 服务暴露端口
     */
    private int port;

}
