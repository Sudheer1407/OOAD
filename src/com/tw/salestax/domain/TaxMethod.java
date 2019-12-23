package com.tw.salestax.domain;

import java.math.BigDecimal;

public class TaxMethod {
	private  String name;
	private  BigDecimal rate;
	
	 public TaxMethod(String name, BigDecimal rate) {
		    this.name = name;
		    this.rate = rate;
		  }
	
	 public String getName() {
		    return name;
		  }
		  
	  public BigDecimal getRate() {
	    return rate;
	  }
	  
	  public BigDecimal calculateTax(BigDecimal amount) {
		    return amount.multiply(rate);
	  }
}
