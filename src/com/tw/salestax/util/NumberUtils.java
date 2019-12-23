package com.tw.salestax.util;

import java.math.BigDecimal;

public class NumberUtils {
	private static final int ROUND_DECIMAL_PLACE = 2;

	public static BigDecimal toBigDecimal(double input) {
        BigDecimal bd = new BigDecimal(input);
        bd = bd.setScale(ROUND_DECIMAL_PLACE,BigDecimal.ROUND_CEILING);
        return bd;
	}

	public static double roundOff(double input) {
        return (toBigDecimal(input).doubleValue());
    }
}
