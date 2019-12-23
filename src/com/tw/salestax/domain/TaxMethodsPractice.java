package com.tw.salestax.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TaxMethodsPractice {

	private List<TaxMethod> taxes = null;

	public TaxMethodsPractice() {
		taxes = new ArrayList<TaxMethod>();
	}

	public void add(TaxMethod tax) {
		taxes.add(tax);
	}

	public Collection<TaxEntry> apply(ProductEntry entry) {
		List<TaxEntry> entries = new ArrayList<TaxEntry>();
		BigDecimal taxAmount = BigDecimal.ZERO;
		boolean isProductImported = entry.getProduct().isImported();
		boolean isProductExempted = entry.getProduct().isIsexempted();
		
		for (TaxMethod tax : taxes) {
			if(isProductExempted && tax.getName().equalsIgnoreCase("BST"))
				taxAmount = BigDecimal.ZERO;
			else
				taxAmount = tax.calculateTax(entry.getAmount());
			TaxEntry taxEntry = new TaxEntry(entry, tax, taxAmount);
			entries.add(taxEntry);
		}
		
		return entries;
	}

}
