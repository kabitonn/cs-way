package com.vika.way.srpc.registry;

/**
 * eureka实现服务治理
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
public class EurekaServiceRegistry implements ServiceRegistry {
    public EurekaServiceRegistry(String address) {
    }

    /**
     * 服务注册
     *
     * @param serviceMetadata 服务元数据
     * @throws Exception
     */
    @Override
    public void register(ServiceMetadata serviceMetadata) throws Exception {

    }

    /**
     * 服务注销
     *
     * @param serviceMetadata 服务元数据
     * @throws Exception
     */
    @Override
    public void unRegister(ServiceMetadata serviceMetadata) throws Exception {

    }

    /**
     * 服务发现
     *
     * @param serviceName 服务名
     * @return 返回服务发现的结果
     * @throws Exception 异常
     */
    @Override
    public ServiceMetadata discovery(String serviceName) throws Exception {
        return null;
    }

    /**
     * 关闭
     *
     * @throws Exception
     */
    @Override
    public void close() throws Exception {

    }
}
