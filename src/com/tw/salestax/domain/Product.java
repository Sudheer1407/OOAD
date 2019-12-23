package com.tw.salestax.domain;

import java.math.BigDecimal;

public class Product {
	
	private  String name;
	private BigDecimal price;
	private  boolean isexempted;
	private  boolean isImported;
	
	public void setIsexempted(boolean isexempted) {
		this.isexempted = isexempted;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public Product(String name, BigDecimal price2,boolean isExcluded, boolean isImported) {
		this.name = name;
		this.price = price2;
		this.isexempted = isExcluded;
		this.isImported = isImported;
	}

	public boolean isIsexempted() {
		return isexempted;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public boolean isImported() {
		return isImported;
	}

	@Override
	public String toString() {
		return  name ;
	}
}
	