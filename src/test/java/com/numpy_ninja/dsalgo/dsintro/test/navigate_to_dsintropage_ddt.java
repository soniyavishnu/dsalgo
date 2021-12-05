package com.numpy_ninja.dsalgo.dsintro.test;

import org.testng.annotations.Test;

import com.numpy_ninja.dsalgo.pages.dsalgo_config;
import com.numpy_ninja.dsalgo.pages.dsintro_Page;
import com.numpy_ninja.dsalgo.pages.homePage_loggedin;
import com.numpy_ninja.dsalgo.pages.home_Page;
import com.numpy_ninja.dsalgo.pages.portal_Page;
import com.numpy_ninja.dsalgo.pages.signin_Page;
import com.numpy_ninja.dsalgo.pages.signout;
import com.numpy_ninja.dsalgo.utilities.ExcelUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class navigate_to_dsintropage_ddt {
	
	WebDriver driver = null;
	dsintro_Page dsintro;
	portal_Page portal;
	home_Page dsalgohome;
	homePage_loggedin homeloggedin;
	signin_Page signin;
	signout sign_out;
	  @DataProvider (name="logindata")
  
  	  
	  public String[][] getLogindata() throws IOException {

			String excelpath = System.getProperty("user.dir") + ".\\logindata\\logindata.xlsx";
			String sheet = "ExistingUser";
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
  

	  @Test(dataProvider = "logindata")

  public void dsintropage_navigation(String username, String password) throws IOException, InterruptedException
	{
		Reporter.log("Validate if the user is able to login with the Valid username and the password");
		portal = new portal_Page(driver);
		portal.click_Getstarted();
		Reporter.log("User navigated to the Home page");
		Thread.sleep(1000);
		dsalgohome = new home_Page(driver);
		dsalgohome.click_signin();
		Reporter.log("User navigated to the Signin page");
		Thread.sleep(1000);
		signin = new signin_Page(driver);
		signin.loginvalidation1(username, password);
		Thread.sleep(1000);
		homeloggedin= new homePage_loggedin(driver);
		homeloggedin.click_dsintro_getstarted();
		Reporter.log("User is at the Data Structures Introduction page");
		sign_out = new signout(driver);
		sign_out.click_signout();
		Thread.sleep(1000);
		//dsalgohome.click_signin();
  }


  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(dsalgo_config.url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		Reporter.log("User successfully logged out");
  }


}
