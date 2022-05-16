package com.vika.way.srpc.annotation;

import com.vika.way.srpc.consumer.RpcSpringConsumerBean;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 消费者注解
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Component
public @interface RPCConsumer {

    /**
     * @see RpcSpringConsumerBean#setServiceVersion(String)
     * @return
     */
    String serviceVersion() default "1.0.0";

    /**
     * @see RpcSpringConsumerBean#setRegistryType(String)
     * @return
     */
    String registryType() default "zookeeper";

    /**
     * @see
     * @see RpcSpringConsumerBean#setRegistryAddress(String)
     * @return
     */
    String registryAddress() default "127.0.0.1:2181";
}
