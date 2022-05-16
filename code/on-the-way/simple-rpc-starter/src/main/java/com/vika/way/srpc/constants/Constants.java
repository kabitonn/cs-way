package com.vika.way.srpc.constants;

/**
 * @author chenwei.tjw
 * @date 2022/5/12
 */
public class Constants {

    public static final String DEFAULT_HOST = "127.0.0.1";
    public static final int DEFAULT_PORT = 8080;

    /**
     * init method name
     */
    public static String INIT_METHOD = "init";

    /**
     * 生产者线程池线程数量
     */
    public static final int PROVIDER_THREAD_POOL_NUM = 256;

    /**
     * 生产者线程池工作队列长度
     */
    public static final int PROVIDER_THREAD_POOL_QUEUE_LEN = 1024;

    /**
     * 注册中心root节点名
     */
    public static final String BASE_PATH = "/rpc";
}
