package com.vika.way.common.lang.strategy.manager;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vika.way.common.lang.strategy.IStrategy;

import java.text.MessageFormat;
import java.util.*;
import java.util.function.Function;

/**
 * 策略管理器
 *
 * @author chenwei.tjw
 * @date 2023/2/2
 **/
public class StrategyManager {

    /**
     * 策略组 容器
     * <策略接口, <租户,<策略组编码, <策略编码, 策略>>>>>
     */
    private static final Map<String, Map<String, Map<String, Map<String, IStrategy>>>> GROUP_STRATEGY_CONTAINER = Maps.newConcurrentMap();


    /**
     * 注册策略
     *
     * @param tenant
     * @param groupCode
     * @param code
     * @param strategy
     * @param strategyService
     */
    public static void register(String tenant, String groupCode, String code, Class<? extends IStrategy> strategy, IStrategy strategyService) {
        IStrategy iStrategy = getStrategy(strategy.getCanonicalName(), tenant, groupCode, code, null);
        if (Objects.nonNull(iStrategy)) {
            throw new RuntimeException(MessageFormat.format(
                    "Strategy[tenant={0}, group={1}, code={2}] is already registered", tenant, groupCode, code));
        }
        Map<String, Map<String, Map<String, IStrategy>>> ifaceMap = GROUP_STRATEGY_CONTAINER.get(strategy.getCanonicalName());

        if (Objects.isNull(ifaceMap)) {
            ifaceMap = Maps.newHashMap();
            GROUP_STRATEGY_CONTAINER.put(strategy.getCanonicalName(), ifaceMap);
        }

        Map<String, Map<String, IStrategy>> tenantMap = ifaceMap.get(tenant);
        if (Objects.isNull(tenantMap)) {
            tenantMap = Maps.newHashMap();
            ifaceMap.put(tenant, tenantMap);
        }

        Map<String, IStrategy> groupMap = tenantMap.get(groupCode);
        if (Objects.isNull(groupMap)) {
            groupMap = Maps.newHashMap();
            tenantMap.put(groupCode, groupMap);
        }
        groupMap.put(code, strategyService);
    }


    /**
     * 获取策略
     *
     * @param strategy
     * @param tenant
     * @param code
     * @param defaultCode
     * @return
     */
    public static IStrategy getStrategy(String strategy, String tenant, String groupCode, String code, String defaultCode) {
        return Optional.ofNullable(GROUP_STRATEGY_CONTAINER)
                .map(container -> container.get(strategy))
                .map(tenantMap -> tenantMap.get(tenant))
                .map(group -> group.get(groupCode))
                .map(strategyMap -> Objects.isNull(strategyMap.get(code)) ? strategyMap.get(defaultCode) : strategyMap.get(code))
                .orElse(null);
    }

    /**
     * 获取策略组
     *
     * @param strategy
     * @param tenant
     * @param groupCode
     * @param defaultGroupCode
     * @return
     */
    public static List<IStrategy> getStrategyGroup(String strategy, String tenant, String groupCode, String defaultGroupCode) {
        return (List<IStrategy>) Optional.ofNullable(GROUP_STRATEGY_CONTAINER)
                .map(container -> container.get(strategy))
                .map(container -> container.get(tenant))
                .map(groupMap -> Objects.nonNull(groupMap.get(groupCode)) ? groupMap.get(groupCode) : groupMap.get(defaultGroupCode))
                .map(Map::values)
                .map(ArrayList::new)
                .orElseGet(Lists::newArrayList);
    }
}
