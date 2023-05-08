package com.vika.way.spring.utils;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author chenwei.tjw
 * @date 2023/5/8
 **/
public class DecimalShareUtilsTest {

    /**
     * 正常分摊
     *
     * @throws Exception
     */
    @Test
    public void testShare() throws Exception {
        BigDecimal total = new BigDecimal("100.6");
        Map<String, BigDecimal> shareQuotaMap = new HashMap<>();
        List<String> quotaList = Arrays.asList("1.1", "2.2", "0", "3.3", "4.4", "-1");
        for (int i = 0; i < quotaList.size(); i++) {
            shareQuotaMap.put(String.valueOf(i), new BigDecimal(quotaList.get(i)));
        }
        Map<String, BigDecimal> result = DecimalShareUtils.share(total, shareQuotaMap);
        System.out.println(result);
    }

    /**
     * @throws Exception
     */
    @Test
    public void testShare1() throws Exception {
        BigDecimal total = new BigDecimal("-100.6");
        Map<String, BigDecimal> shareQuotaMap = new HashMap<>();
        List<String> quotaList = Arrays.asList("1.1", "2.2", "0", "3.3", "4.4", "-1");
        for (int i = 0; i < quotaList.size(); i++) {
            shareQuotaMap.put(String.valueOf(i), new BigDecimal(quotaList.get(i)));
        }
        Map<String, BigDecimal> result = DecimalShareUtils.share(total, shareQuotaMap);
        System.out.println(result);
    }
}

