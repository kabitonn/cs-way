package com.vika.way.srpc.registry;

/**
 * 注册服务
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
public interface ServiceRegistry {

    /**
     * 服务注册
     *
     * @param serviceMetadata 服务元数据
     * @throws Exception
     */
    void register(ServiceMetadata serviceMetadata) throws Exception;

    /**
     * 服务注销
     *
     * @param serviceMetadata 服务元数据
     * @throws Exception
     */
    void unRegister(ServiceMetadata serviceMetadata) throws Exception;

    /**
     * 服务发现
     *
     * @param serviceName 服务名
     * @return 返回服务发现的结果
     * @throws Exception 异常
     */
    ServiceMetadata discovery(String serviceName) throws Exception;

    /**
     * 关闭
     *
     * @throws Exception
     */
    void close() throws Exception;

}
