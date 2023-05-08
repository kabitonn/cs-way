package com.vika.way.spring.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * 金额工具类
 *
 * @author chenwei.tjw
 * @date 2023/5/6
 **/
public class AmountUtils {
    /**
     * 保留小数位数
     */
    private static final int DEFAULT_SCALE = 6;

    public static BigDecimal formatAmount(BigDecimal waitFormatAmount) {

        Objects.requireNonNull(waitFormatAmount, "format amount param must be nonnull");

        return waitFormatAmount.setScale(DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 计算未税
     * taxPrice/(1+taxRate)
     */
    public static BigDecimal calUnTax(BigDecimal taxPrice, BigDecimal taxRate) {
        return taxPrice.divide(taxRate.add(BigDecimal.ONE), DEFAULT_SCALE, RoundingMode.HALF_UP);
    }
}
