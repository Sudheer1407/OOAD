package com.tw.salestax.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tw.salestax.domain.Product;
import com.tw.salestax.domain.ProductType;

public class InputParser {
	private List<String> inputText;
	private static String PRODUCT_REGEX = "(\\d+)\\s((\\w+\\s)+)at\\s(\\d+.\\d+)";
	private String REGEX_CLASSIFIER = "(\\d+)([a-zA-Z0-9_\\s]+?)( at )(\\d+.\\d+)";
	private static List<String> prdTypeList = ProductType.getPrdList();

	
	public List<Product> extractDataFromText(){
		List<Product> items = new ArrayList<Product>();
		for (String item : inputText) {
			items.add(parser(item));
		}
		return items;
	}
	
	public static Matcher parseText(String description) {
		Pattern pattern = Pattern.compile(PRODUCT_REGEX);
		Matcher matcher = pattern.matcher(description);
		matcher.find();
		return matcher;
	}
	
	private Product parser(String itemText){
		Pattern textPattern = Pattern.compile(PRODUCT_REGEX, Pattern.CASE_INSENSITIVE);
		Matcher textMatcher = textPattern.matcher(itemText);
		Integer qty = null;
		Double price = null;
		String desc = null;
		if (textMatcher.find()){
			qty = Integer.parseInt(textMatcher.group(1));
			price = Double.parseDouble(textMatcher.group(4));
			desc = textMatcher.group(2);
		}
		return null;
		
	}
	
	public static boolean isProductexempt(String descrption) {
		String string = String.join("|", prdTypeList);
		Pattern exemptPattern = Pattern.compile(string);
		if (exemptPattern.matcher(descrption).find()) {
           return true;
        }
		return false;
	}
	
}
