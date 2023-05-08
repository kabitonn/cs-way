package com.vika.way.srpc.provider.service.impl;

import com.vika.way.srpc.annotation.RPCProvider;
import com.vika.way.srpc.provider.client.service.GreetService;
import com.vika.way.srpc.provider.dto.ExampleChildDTO;
import com.vika.way.srpc.provider.dto.ExampleParentDTO;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 传送
     *
     * @return
     */
    @Override
    public List<Object> send(String user) {
        List<Object> list = new ArrayList<>();
        ExampleParentDTO parentDTO = new ExampleParentDTO();
        parentDTO.setName(user);
        parentDTO.setNameAlias(user);
        ExampleChildDTO childDTO = new ExampleChildDTO();
        childDTO.setName(user);
        childDTO.setNameAlias(user);
        list.add(parentDTO);
        list.add(childDTO);
        return list;
    }

    /**
     * 子类测试
     *
     * @param user
     * @return
     */
    @Override
    public Object testChild(String user) {
        ExampleChildDTO childDTO = new ExampleChildDTO();
        childDTO.setName(user);
        childDTO.setNameAlias(user);
        return childDTO;
    }
}
