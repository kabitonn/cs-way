package com.vika.way.srpc.provider.service.impl;

import com.vika.way.srpc.annotation.RPCProvider;
import com.vika.way.srpc.provider.client.service.GreetService;

/**
 * @author chenwei.tjw
 * @date 2022/5/13
 **/
@RPCProvider(serviceInterface = GreetService.class)
public class GreetServiceImpl implements GreetService {
    /**
     * hello
     *
     * @param user
     * @return
     */
    @Override
    public String hello(String user) {
        return "hello:" + user;
    }

    /**
     * goodbye
     *
     * @param user
     * @return
     */
    @Override
    public String goodbye(String user) {
        return "goodbye:" + user;
    }
}
