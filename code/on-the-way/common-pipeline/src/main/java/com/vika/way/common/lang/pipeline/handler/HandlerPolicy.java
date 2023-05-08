package com.vika.way.common.lang.pipeline.handler;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenwei.tjw
 * @date 2022/11/27
 **/
@Component
public class HandlerPolicy implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private final static String HANDLER_TYPE_SEPARATOR = "@:@";

    private Map<String, Class<? extends AbstractHandler>> policyMap;


    @Override
    public void afterPropertiesSet() throws Exception {
        policyMap = new HashMap<>();
        for (AbstractHandler handler : applicationContext.getBeansOfType(AbstractHandler.class).values()) {
            String policyKey = generatePolicyKey(handler.getHandlerGroup(), handler.getHandlerType());
            if (policyMap.containsKey(policyKey)) {
                throw new RuntimeException(MessageFormat.format("AbstractHandlerPolicyKeyDuplicate:{0}", policyKey));
            }
            policyMap.put(policyKey, handler.getClass());
        }
    }


    /**
     * 获取处理器
     *
     * @param group
     * @param type
     * @return
     */
    public AbstractHandler getHandler(String group, String type) {
        String policyKey = generatePolicyKey(group, type);
        if (!policyMap.containsKey(policyKey)) {
            return null;
        }
        Class<? extends AbstractHandler> clazz = policyMap.get(policyKey);
        return applicationContext.getBean(clazz);
    }

    private String generatePolicyKey(String group, String type) {
        return String.join(HANDLER_TYPE_SEPARATOR, group, type);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
