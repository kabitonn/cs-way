package com.vika.way.srpc.consumer;


import com.vika.way.srpc.registry.ServiceRegistryFactory;
import com.vika.way.srpc.registry.ServiceRegistryType;
import com.vika.way.srpc.utils.RpcUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fuxi@cainiao.com
 * @date 2020/6/5
 **/

@Slf4j
public class TestClient {

    public static void main(String[] args) throws Exception {
        String address = "127.0.0.1:2181";
        HelloService helloService = RpcUtils.create(HelloService.class, "1.0.0.daily",
            ServiceRegistryFactory.getInstance(ServiceRegistryType.zookeeper, address));
        String rpcResponse = helloService.sayHello("consumer test");
        log.info("rpcResponse---->{}", rpcResponse);
    }
}
