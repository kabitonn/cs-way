package com.vika.way.srpc.consumer.config;

import com.vika.way.srpc.annotation.RPCConsumer;
import com.vika.way.srpc.provider.client.service.GreetService;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenwei.tjw
 * @date 2022/5/13
 **/
@Configuration
public class RpcConfig {

    @RPCConsumer
    private GreetService greetService;

}
