package com.vika.way.srpc.utils;

/**
 *
 * @author chenwei.tjw
 * @date 2022/5/12
 **/
public class ProviderUtils {
    /**
     * 构造服务的唯一标识key
     *
     * @param serviceName    服务类名
     * @param serviceVersion 服务版本号
     * @return 服务标识
     */
    public static String makeKey(String serviceName, String serviceVersion) {
        return String.join(":", serviceName, serviceVersion);
    }
}
