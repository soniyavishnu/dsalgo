package com.numpy_ninja.dsalgo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils{
	
	public static FileInputStream file;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

/*	//Constructor - same as class name
	public ExcelUtils(String excelpath, String sheetname)
	{
	try {

	workbook = new XSSFWorkbook(excelpath);
	sheet = workbook.getSheet(sheetname);

	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}*/
	
	public static int getRowCount(String excelpath, String sheetname) throws IOException
	{

		file = new FileInputStream(excelpath);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum();
		return rowCount;

	}
	
	public static int getColumnCount(String excelpath, String sheetname, int rowNum) throws IOException
	{
		file = new FileInputStream(excelpath);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetname);		
		row = sheet.getRow(rowNum);

		int colcount = sheet.getRow(0).getLastCellNum();
		System.out.println("Column count"+colcount);
		return colcount;
	}
	

	public static String getCelldata(String excelpath, String sheetname, int rowNum, int colNum) throws IOException
	{
		file = new FileInputStream(excelpath);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetname);

		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);

		String data = row.getCell(colNum).getStringCellValue();

			
		return data;

	}

	
	

}
