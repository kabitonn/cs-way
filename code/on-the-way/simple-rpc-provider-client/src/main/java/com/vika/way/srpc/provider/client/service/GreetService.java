package com.vika.way.srpc.provider.client.service;

import java.util.List;

/**
 * @author chenwei.tjw
 * @date 2022/5/13
 **/
public interface GreetService {

    /**
     * hello
     *
     * @param user
     * @return
     */
    String hello(String user);

    /**
     * goodbye
     *
     * @param user
     * @return
     */
    String goodbye(String user);

    /**
     * 传送
     *
     * @return
     */
    List<Object> send(String user);


    /**
     * 子类测试
     *
     * @return
     */
    Object testChild(String user);

}
