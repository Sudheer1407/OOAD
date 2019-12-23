package com.tw.salestax.driver;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tw.salestax.domain.Order;
import com.tw.salestax.domain.OrderReceipt;
import com.tw.salestax.domain.Product;
import com.tw.salestax.domain.TaxMethod;
import com.tw.salestax.domain.TaxMethodsPractice;
import com.tw.salestax.parser.InputParser;
import com.tw.salestax.util.InputReader;

public class MainApp {
	private static String FILE_PATH = "C:\\Users\\sbejugum\\eclipse-workspace\\SalesTaxProblem\\src\\com\\tw\\salestax\\source\\input2.txt";

	public static void main(String[] args) throws FileNotFoundException {

		InputReader fileRead = new InputReader(FILE_PATH);
		List<Product> productList = new ArrayList<Product>();
		List<String> fileData = fileRead.readInput();

		TaxMethod basicSalesTax = new TaxMethod("BST", new BigDecimal("0.10"));
		TaxMethod importDuty = new TaxMethod("IMD", new BigDecimal("0.05"));

		TaxMethodsPractice taxes = new TaxMethodsPractice();
		taxes.add(basicSalesTax);
		taxes.add(importDuty);
		
		Order order = new Order(taxes);

		for (String entry : fileData) {
			Matcher matchObj = InputParser.parseText(entry);
			Integer qty = null;
			BigDecimal price = null;
			boolean isProductImported = false;
			boolean isProductExempted = false;

			String name = matchObj.group(2).trim();
			qty = Integer.parseInt(matchObj.group(1));
			price = new BigDecimal(matchObj.group(4));

			isProductExempted = InputParser.isProductexempt(name);

			if (name.contains("imported"))
				isProductImported = true;

			System.out.println(
					"name : " + name + " qty:" + qty + " price:" + price + " isProductExempted:" + isProductExempted);
			order.add(new Product(name, price, isProductExempted, isProductImported),qty);

		}
		 // print the receipt
	    OrderReceipt receipt = OrderReceipt.create(System.out);
	    order.print(receipt);
	
	}
}
