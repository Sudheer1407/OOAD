package com.tw.salestax.domain;

import java.math.BigDecimal;

public class TaxEntry {

		  private final ProductEntry taxedEntry;
		  private final TaxMethod tax;
		  private final BigDecimal salesPrice;

		  public TaxEntry(ProductEntry taxedEntry, TaxMethod tax, BigDecimal salesPrice) {
		    this.taxedEntry = taxedEntry;
		    this.tax = tax;
		    this.salesPrice = salesPrice;
		  }

		  public BigDecimal getSalesAmount() {
		    return salesPrice;
		  }

		  public ProductEntry getProductEntry() {
		    return taxedEntry;
		  }

		  public String getProductName() {
		    return taxedEntry.getProduct().getName();
		  }
		    
		  public String getTaxName() {
		    return tax.getName();
		  }
		  
		  public BigDecimal getTaxRate() {
		    return tax.getRate();
		  }
}
