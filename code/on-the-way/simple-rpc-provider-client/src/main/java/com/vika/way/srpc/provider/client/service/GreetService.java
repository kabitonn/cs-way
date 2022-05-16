package com.vika.way.srpc.provider.client.service;

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

}
