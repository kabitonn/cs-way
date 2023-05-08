package com.vika.way.common.lang.strategy.impl;

import com.google.common.base.Preconditions;
import com.vika.way.common.lang.strategy.IStrategy;
import com.vika.way.common.lang.strategy.StrategyInvokeService;
import com.vika.way.common.lang.strategy.callback.StrategyCallBack;
import com.vika.way.common.lang.strategy.constants.StrategyGroup;
import com.vika.way.common.lang.strategy.manager.StrategyManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author chenwei.tjw
 * @date 2023/2/2
 **/
public class StrategyInvokeServiceImpl implements StrategyInvokeService {
    /**
     * 执行策略
     *
     * @param tenant             策略租户
     * @param code               策略编码
     * @param strategy           策略接口类
     * @param callBack           执行策略方法
     * @param ignoreNullStrategy 策略不存在时是否忽略
     * @return
     */
    @Override
    public <T extends IStrategy, R> R execute(String tenant, String code, Class<T> strategy, StrategyCallBack<T, R> callBack, boolean ignoreNullStrategy) {
        return this.execute(tenant, StrategyGroup.DEFAULT_GROUP, code, null, strategy, callBack, ignoreNullStrategy);
    }

    /**
     * 执行策略
     *
     * @param tenant             策略租户
     * @param groupCode          策略组
     * @param code               策略编码
     * @param defaultCode        默认策略编码
     * @param iStrategy          策略接口类
     * @param callBack           执行策略方法
     * @param ignoreNullStrategy 策略不存在时是否忽略
     * @return
     */
    @Override
    public <T extends IStrategy, R> R execute(String tenant, String groupCode, String code, String defaultCode, Class<T> iStrategy, StrategyCallBack<T, R> callBack, boolean ignoreNullStrategy) {
        IStrategy strategy = StrategyManager.getStrategy(iStrategy.getCanonicalName(), tenant, groupCode, code, defaultCode);
        if (ignoreNullStrategy && Objects.isNull(strategy)) {
            return null;
        }
        Preconditions.checkArgument(Objects.nonNull(strategy),
                MessageFormat.format("strategy not found, tenant={0}, code={1}, iStrategy={2}",
                        tenant, code, iStrategy.getCanonicalName()));
        return callBack.apply((T) strategy);
    }

    /**
     * 执行策略组
     *
     * @param tenant             策略租户
     * @param groupCode          策略组编码
     * @param strategy           策略接口类
     * @param callBack           执行策略方法
     * @param ignoreNullStrategy 策略不存在时是否忽略
     * @return
     */
    @Override
    public <T extends IStrategy, R> List<R> executeGroup(String tenant, String groupCode, Class<T> strategy, StrategyCallBack<T, R> callBack, boolean ignoreNullStrategy) {
        return executeGroup(tenant, groupCode, null, strategy, callBack, ignoreNullStrategy);
    }

    /**
     * 执行策略组
     *
     * @param tenant             策略租户
     * @param groupCode          策略组编码
     * @param defaultGroupCode   默认策略组编码
     * @param iStrategy          策略接口类
     * @param callBack           执行策略方法
     * @param ignoreNullStrategy 策略不存在时是否忽略
     * @return
     */
    @Override
    public <T extends IStrategy, R> List<R> executeGroup(String tenant, String groupCode, String defaultGroupCode, Class<T> iStrategy, StrategyCallBack<T, R> callBack, boolean ignoreNullStrategy) {
        defaultGroupCheck(tenant, groupCode, defaultGroupCode, iStrategy);
        List<IStrategy> strategies = StrategyManager.getStrategyGroup(iStrategy.getCanonicalName(), tenant, groupCode, defaultGroupCode);
        if (ignoreNullStrategy && CollectionUtils.isEmpty(strategies)) {
            return null;
        }
        Preconditions.checkArgument(Objects.nonNull(strategies),
                MessageFormat.format("strategyGroup not found, tenant={0}, groupCode={1}, iStrategy={2}",
                        tenant, groupCode, iStrategy.getCanonicalName()));
        return strategies.stream()
                .map(strategy -> callBack.apply((T) strategy))
                .collect(Collectors.toList());
    }


    /**
     * 默认分组检查
     *
     * @param tenant
     * @param groupCode
     * @param defaultGroupCode
     * @param iStrategy
     * @param <T>
     */
    private <T extends IStrategy> void defaultGroupCheck(String tenant, String groupCode, String defaultGroupCode, Class<T> iStrategy) {
        boolean isDefaultGroup = StringUtils.equals(StrategyGroup.DEFAULT_GROUP, groupCode)
                || StringUtils.equals(StrategyGroup.DEFAULT_GROUP, defaultGroupCode);
        Preconditions.checkArgument(!isDefaultGroup,
                MessageFormat.format("strategyGroup cant not be default group[{0}], tenant={1}, groupCode={2}, defaultGroupCode={3}, iStrategy={4}",
                        StrategyGroup.DEFAULT_GROUP, tenant, groupCode, defaultGroupCode, iStrategy.getCanonicalName()));
    }
}
