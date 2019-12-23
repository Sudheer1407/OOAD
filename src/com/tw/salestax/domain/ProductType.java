package com.tw.salestax.domain;

import java.util.ArrayList;
import java.util.List;

public enum ProductType {
	  BOOK,
	  CHOCOLATES,
	  PILL;
	  
	  public static List<String> getPrdList() {
		  List<String> productTypeList = new ArrayList<String>();
	     
		for(ProductType productType:values())
	    	  productTypeList.add(productType.name().toLowerCase());
		return productTypeList;
	             
	  } 
	  
	  public String toString() {
		    switch(this) {
		      case BOOK:  return "book";
		      case CHOCOLATES:  return "chocloate";
		      case PILL:  return "pill";
		      default:     return "Unspecified";
		    }
		  }
	}
