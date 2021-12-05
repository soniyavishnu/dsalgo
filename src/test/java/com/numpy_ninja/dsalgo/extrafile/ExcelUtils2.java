package com.numpy_ninja.dsalgo.extrafile;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils2{
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;


	//Constructor - same as class name
	public ExcelUtils2(String excelpath, String sheetname)
	{
	try {

	workbook = new XSSFWorkbook(excelpath);
	sheet = workbook.getSheet(sheetname);

	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	
	public static int getRowCount()
	{
	int rowCount = 0;
	rowCount = sheet.getPhysicalNumberOfRows();
	//System.out.println("Number of rows : " + rowCount);
	return rowCount;

	}
	
	public static int getColumnCount()
	{
	int colCount = 0;
	colCount = sheet.getRow(0).getPhysicalNumberOfCells();
	//System.out.println("Number of rows : " + colCount);
	return colCount;
	}
	

	public static Object getCelldata(int rowNum, int colNum) throws IOException
	{
		//file = new FileInputStream(excelpath);
		//workbook = new XSSFWorkbook(file);
		//sheet = workbook.getSheet(sheetname);

		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(colNum);

		DataFormatter formatter = new DataFormatter();
		Object data = formatter.formatCellValue(cell);
		
		

		return data;

	}

	
	

}
