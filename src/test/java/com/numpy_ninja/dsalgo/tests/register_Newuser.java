package com.numpy_ninja.dsalgo.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.numpy_ninja.dsalgo.pages.DS_Intropage;
import com.numpy_ninja.dsalgo.pages.dsalgo_config;
import com.numpy_ninja.dsalgo.pages.dsintro_Page;
import com.numpy_ninja.dsalgo.pages.home_Page;
import com.numpy_ninja.dsalgo.pages.portal_Page;
import com.numpy_ninja.dsalgo.pages.register_Page;
import com.numpy_ninja.dsalgo.pages.signout;
import com.numpy_ninja.dsalgo.utilities.ExcelUtils;

public class register_Newuser {
	
	WebDriver driver;
	dsintro_Page dsintro;
	portal_Page portal;
	register_Page register;
	home_Page dsalgohome;
	signout sign_out;
	
	@DataProvider(name = "newuser")
	public String[][] getLogindata() throws IOException {

		String excelpath = System.getProperty("user.dir") + ".\\logindata\\logindata.xlsx";
		String sheet = "NewUser";
		ExcelUtils excelobj= new ExcelUtils();
		int rownum = excelobj.getRowCount(excelpath, sheet);
		int colnum = excelobj.getColumnCount(excelpath, sheet, 0);
		String logindetails[][] = new String[rownum][colnum];
		for (int i = 1; i <= rownum; i++) 
		{
			for (int j = 0; j < colnum; j++) 
			{

				logindetails [i-1][j]= ExcelUtils.getCelldata(excelpath,sheet, i,j);
				System.out.println(logindetails);

			}
		}
		return (logindetails);
	}

	@Test (priority=1, dataProvider="newuser")
	

  public void newuser_register(String username, String password) throws InterruptedException {
		Reporter.log("User is navigated at the Portal page");
		portal = new portal_Page(driver);
		portal.click_Getstarted();
		Reporter.log("User navigated to the Home page");
		Thread.sleep(1000);
		dsalgohome = new home_Page(driver);
		dsalgohome.click_link_register();
		Reporter.log("User navigated to the registration page");
		Thread.sleep(1000);
		register=new register_Page(driver);
		register.logindetails_ddt(username, password);
		Thread.sleep(1000);
		Reporter.log("User successfully loggedin");
	  	sign_out = new signout(driver);
		sign_out.click_signout();
		Reporter.log("User is navigated to the home page after signing out");
  }
  

	  

	@BeforeTest
	public void beforett() throws InterruptedException
	{
		System.out.println("WElcome");
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(dsalgo_config.url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}

@AfterTest
public void aftertest()
{
	
	driver.close();
	driver.quit();
	Reporter.log("User successfully logged out");
}

}
