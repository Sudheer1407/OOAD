package com.tw.salestax.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

	TaxMethodsPractice taxingPractice = new TaxMethodsPractice();
	private final List<ProductEntry> entries = new ArrayList<ProductEntry>();
	private final List<TaxEntry> taxEntries = new ArrayList<TaxEntry>();

	public Order(TaxMethodsPractice taxingPractice) {
		this.taxingPractice = taxingPractice;
	}

	public void add(Product product, int quantity) {
		ProductEntry entry = new ProductEntry(product, product.getPrice(), quantity);
		entries.add(entry);
		taxEntries.addAll(taxingPractice.apply(entry));
	}

	public BigDecimal getTotalSalesTax() {
		BigDecimal totalCost = BigDecimal.ZERO;
		for (TaxEntry entry : taxEntries) {
			totalCost = totalCost.add(entry.getSalesAmount());
		}
		
		return totalCost;
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		
		for (ProductEntry entry : entries) { 
			total.add(entry.getAmount());
		}
		
		return getTotalSalesTax().add(total);
	}

	
	public void print(Receipt receipt) {
		
		for (TaxEntry entry : taxEntries) receipt.printProduct(entry);
		receipt.printSalesTax(getTotalSalesTax());
		receipt.printTotal(getTotal());
	}

}
