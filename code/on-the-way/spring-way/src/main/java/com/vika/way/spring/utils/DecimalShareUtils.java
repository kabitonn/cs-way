package com.vika.way.spring.utils;


import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;

import static lombok.Lombok.checkNotNull;

/**
 * 分摊工具
 *
 * @author chenwei.tjw
 * @date 2023/5/8
 **/
public class DecimalShareUtils {

    private static final int DEFAULT_SCALE = 6;


    /**
     * 依据分摊因子shareQuotaMap对shareValue分摊
     *
     * @param shareValue
     * @param shareQuotaMap
     * @return
     */
    public static Map<String, BigDecimal> share(BigDecimal shareValue, Map<String, BigDecimal> shareQuotaMap) {
        List<Map.Entry<String, BigDecimal>> shareQuotaSortList = new ArrayList<>(shareQuotaMap.entrySet());
        shareQuotaSortList.sort(Comparator.comparing(Entry::getValue));
        List<BigDecimal> shareQuotaList = new ArrayList<>();
        List<String> keyList = new ArrayList<>();
        shareQuotaSortList.forEach(e -> {
            keyList.add(e.getKey());
            shareQuotaList.add(e.getValue());
        });
        BigDecimal totalShareQuota = shareQuotaList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        if (totalShareQuota.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("分摊异常，分摊数据为空或者是负数");
        }

        List<BigDecimal> shareResultList = shareList(shareValue, totalShareQuota, shareQuotaList);
        Map<String, BigDecimal> shareResultMap = new HashMap<>();
        for (int i = 0; i < keyList.size(); i++) {
            shareResultMap.put(keyList.get(i), shareResultList.get(i));
        }
        return shareResultMap;
    }

    /**
     * 依据分摊因子shareQuotaList和totalQuota对shareValue分摊
     *
     * @param totalValue
     * @param totalQuota
     * @param shareQuotaList
     * @return
     */
    private static List<BigDecimal> shareList(BigDecimal totalValue, BigDecimal totalQuota, List<BigDecimal> shareQuotaList) {
        List<BigDecimal> shareResultList = new ArrayList<>();
        //分摊总额为0
        if (totalValue.compareTo(BigDecimal.ZERO) == 0) {
            shareQuotaList.forEach(item -> shareResultList.add(new BigDecimal(0)));
            return shareResultList;
        }

        BigDecimal leftOverAmount = totalValue;
        for (int i = 0; i < shareQuotaList.size(); i++) {
            BigDecimal shareQuota = shareQuotaList.get(i);
            if (i == shareQuotaList.size() - 1) {
                // 尾差
                shareResultList.add(leftOverAmount);
            } else {
                BigDecimal shareValue = calculationShareValue(totalQuota, shareQuota, totalValue);
                shareResultList.add(shareValue);
                leftOverAmount = leftOverAmount.subtract(shareValue);
            }
        }
        return shareResultList;
    }


    /**
     * 按需分摊计算
     */
    private static BigDecimal calculationShareValue(BigDecimal totalQuota, BigDecimal shareQuota,
                                                    BigDecimal totalValue) {
        return totalValue.multiply(shareQuota).divide(totalQuota, DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP);
    }
}
