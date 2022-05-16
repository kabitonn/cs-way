package com.vika.way.srpc.provider;


import com.vika.way.srpc.consumer.HelloService;
import com.vika.way.srpc.registry.ServiceRegistryFactory;
import com.vika.way.srpc.registry.ServiceRegistryType;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fuxi@cainiao.com
 * @date 2020/6/5
 **/

@Slf4j
public class TestServer {

    public static void main(String[] args) throws Exception {
        String serverAddress = "127.0.0.1:18867";
        String registryAddress = "127.0.0.1:2181";
        RpcProviderPostProcessor rpcServer = new RpcProviderPostProcessor(serverAddress,
            ServiceRegistryFactory.getInstance(ServiceRegistryType.zookeeper, registryAddress));
        HelloService helloService = new HelloServiceImpl();
        rpcServer.addService(helloService, rpcServer.getServerAddress());
        try {
            rpcServer.start();
        } catch (Exception ex) {
            log.error("Exception: {}", ex);
        }
    }
}
