package com.vika.way.srpc.provider;


import com.vika.way.srpc.annotation.RPCProvider;
import com.vika.way.srpc.consumer.HelloService;

/**
 * @author fuxi@cainiao.com
 * @date 2020/6/5
 **/

@RPCProvider(serviceInterface = HelloService.class, serviceVersion = "1.0.0.daily")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String greet) {
        return "greet: " + greet;
    }

}
