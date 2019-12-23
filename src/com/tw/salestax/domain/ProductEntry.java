package com.tw.salestax.domain;

import java.math.BigDecimal;

public class ProductEntry {

	private Product product;
	private int qnty;
	private BigDecimal price;

	public ProductEntry(Product product, BigDecimal price, int quantity) {
		this.product = product;
		this.price = price;
		this.qnty = quantity;
	}
	
	public BigDecimal getAmount() {
	    return price.multiply(new BigDecimal(qnty));
	  }

	public Product getProduct() {
		return product;
	}

	public String getProductName() {
		return product.getName();
	}

	public int getQuantity() {
		return qnty;
	}
}
