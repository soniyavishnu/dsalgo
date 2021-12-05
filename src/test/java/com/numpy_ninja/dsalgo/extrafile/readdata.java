package com.numpy_ninja.dsalgo.extrafile;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class readdata {
	WebDriver driver;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFCell cell;
	
	@DataProvider ("logindata")
	public void readdata1(){
		String excelpath = System.getProperty("user.dir") + ".\\logindata\\logindata.xlsx";
		FileInputStream fis= new FileInputStream(excelpath);
		workbook=new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		int rowcount= sheet.getPhysicalNumberOfRows();
		int colcount = sheet.getRow(0).getLastCellNum();
		XSSFRow row = sheet.getRow(rowcount);
		XSSFCell cell = row.getCell(colcount);
		
		for (int i=1; i<=sheet.getLastRowNum(); i++)
		{
			for(int j=0;j<=colcount; j++)
			{
	
			logindetails[i-1][j]= cell.get
			
			
		}
		
		
		
		
		
		
		
		
		
	}

	
	@BeforeTest
	public void beforett() throws InterruptedException
	{
		System.out.println("WElcome");
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://dsportalapp.herokuapp.com/login");
		Thread.sleep(5000);
	}

}
