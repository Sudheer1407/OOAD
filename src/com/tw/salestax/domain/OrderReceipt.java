package com.tw.salestax.domain;

import java.io.PrintStream;
import java.math.BigDecimal;

public class OrderReceipt implements Receipt {

	private final PrintStream out;

	public static OrderReceipt create(PrintStream out) {
		return new OrderReceipt(out);
	}

	private OrderReceipt(PrintStream out) {
		this.out = out;
	}


	@Override
	public void printProduct(TaxEntry entry) {
		out.printf(" %d %3s : %3s\n", entry.getProductEntry().getQuantity(), entry.getProductName(), entry.getSalesAmount().add(entry.getProductEntry().getAmount()));

	}

	@Override
	public void printSalesTax(BigDecimal total) {
		 out.printf("Sales Taxes: \n", total);

	}

	@Override
	public void printTotal(BigDecimal total) {
		 out.printf("Total:  ", total);

	}


}
