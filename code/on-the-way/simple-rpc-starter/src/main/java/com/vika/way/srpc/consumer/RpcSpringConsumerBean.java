package com.vika.way.srpc.consumer;

import com.vika.way.srpc.registry.ServiceRegistryFactory;
import com.vika.way.srpc.registry.ServiceRegistryType;
import com.vika.way.srpc.utils.RpcUtils;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
@Setter
@Slf4j
public class RpcSpringConsumerBean implements FactoryBean {

    private Class<?> interfaceClass;

    private String serviceVersion;

    private String registryType;

    private String registryAddress;

    private Object object;


    public void init() throws Exception {
        this.object = RpcUtils.create(interfaceClass, serviceVersion, ServiceRegistryFactory.getInstance(
                ServiceRegistryType.valueOf(registryType), registryAddress
        ));
        log.info("RpcConsumerBean {} init ...", interfaceClass.getName());
    }

    @Override
    public Object getObject() throws Exception {
        return object;
    }


    @Override
    public Class<?> getObjectType() {
        return interfaceClass;
    }


    @Override
    public boolean isSingleton() {
        return true;
    }

}
