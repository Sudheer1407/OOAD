package com.tw.salestax.domain;

import java.math.BigDecimal;

public interface Receipt {
	
	void printProduct(TaxEntry entry);
	void printSalesTax(BigDecimal entry);
	void printTotal(BigDecimal total);
}
