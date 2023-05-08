package com.vika.way.common.lang.strategy;

import com.vika.way.common.lang.strategy.callback.StrategyCallBack;

import java.util.List;

/**
 * 策略调用服务
 *
 * @author chenwei.tjw
 * @date 2023/2/2
 **/
public interface StrategyInvokeService {

    /**
     * 执行策略
     *
     * @param tenant             策略租户
     * @param code               策略编码
     * @param strategy           策略接口类
     * @param callBack           执行策略方法
     * @param ignoreNullStrategy 策略不存在时是否忽略
     * @param <R>                返回结果类型
     * @return
     */
    <T extends IStrategy, R> R execute(String tenant, String code, Class<T> strategy,
                                       StrategyCallBack<T, R> callBack, boolean ignoreNullStrategy);

    /**
     * 执行策略
     *
     * @param tenant             策略租户
     * @param groupCode          策略组
     * @param code               策略编码
     * @param defaultCode        默认策略编码
     * @param strategy           策略接口类
     * @param callBack           执行策略方法
     * @param ignoreNullStrategy 策略不存在时是否忽略
     * @param <R>                返回结果类型
     * @return
     */
    <T extends IStrategy, R> R execute(String tenant, String groupCode, String code, String defaultCode, Class<T> strategy,
                                       StrategyCallBack<T, R> callBack, boolean ignoreNullStrategy);


    /**
     * 执行策略组
     *
     * @param tenant             策略租户
     * @param groupCode          策略组编码
     * @param strategy           策略接口类
     * @param callBack           执行策略方法
     * @param ignoreNullStrategy 策略不存在时是否忽略
     * @param <T>                策略接口
     * @param <R>                返回结果类型
     * @return
     */
    <T extends IStrategy, R> List<R> executeGroup(String tenant, String groupCode, Class<T> strategy,
                                                  StrategyCallBack<T, R> callBack, boolean ignoreNullStrategy);

    /**
     * 执行策略组
     *
     * @param tenant             策略租户
     * @param groupCode          策略组编码
     * @param defaultGroupCode   默认策略组编码
     * @param strategy           策略接口类
     * @param callBack           执行策略方法
     * @param ignoreNullStrategy 策略不存在时是否忽略
     * @param <T>                策略接口
     * @param <R>                返回结果类型
     * @return
     */
    <T extends IStrategy, R> List<R> executeGroup(String tenant, String groupCode, String defaultGroupCode, Class<T> strategy,
                                                  StrategyCallBack<T, R> callBack, boolean ignoreNullStrategy);
}
