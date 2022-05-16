package com.vika.way.srpc.registry;

/**
 * 服务注册工厂
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
public class ServiceRegistryFactory {
    private static volatile ServiceRegistry serviceRegistry;

    public static ServiceRegistry getInstance(ServiceRegistryType type, String registryAddress) throws Exception {

        if (null == serviceRegistry) {
            synchronized (ServiceRegistryFactory.class) {
                if (null == serviceRegistry) {
                    serviceRegistry = type == ServiceRegistryType.zookeeper ? new ZookeeperServiceRegistry(registryAddress) :
                            type == ServiceRegistryType.eureka ? new EurekaServiceRegistry(registryAddress) : null;
                }
            }
        }
        return serviceRegistry;
    }
}
