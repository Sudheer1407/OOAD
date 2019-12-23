package com.tw.salestax.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {

	private File inputfile;
	private Scanner scannerObj;
	
	public InputReader(String pathName) {
		inputfile = new File(pathName);
	}
	
	public List<String> readInput() throws FileNotFoundException{
		return readInputFile();
	}
	
	private List<String> readInputFile() throws FileNotFoundException{
		scannerObj = new Scanner(inputfile);
		List<String> inputData = new ArrayList<String>();
		while(scannerObj.hasNext()){
			inputData.add(scannerObj.nextLine());
		}
		scannerObj.close();
		return inputData;
	}
}
