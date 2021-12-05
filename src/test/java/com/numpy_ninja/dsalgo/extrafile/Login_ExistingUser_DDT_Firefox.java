package com.numpy_ninja.dsalgo.extrafile;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.numpy_ninja.dsalgo.pages.dsalgo_config;
import com.numpy_ninja.dsalgo.pages.dsintro_Page;
import com.numpy_ninja.dsalgo.pages.homePage_loggedin;
import com.numpy_ninja.dsalgo.pages.home_Page;
import com.numpy_ninja.dsalgo.pages.portal_Page;
import com.numpy_ninja.dsalgo.pages.signin_Page;
import com.numpy_ninja.dsalgo.pages.signout;

public class Login_ExistingUser_DDT_Firefox {
	WebDriver driver = null;
	dsintro_Page dsintro;
	portal_Page portal;
	home_Page dsalgohome;
	homePage_loggedin homeloggedin;
	signin_Page signin;
	signout sign_out;

	@DataProvider(name = "logindata")
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

	@Test (priority=1, dataProvider="logindata")
//validate if the user is able to navigate to the login using the valid username and password
	public void logintohomepage(String username, String password) throws IOException, InterruptedException
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
		
		//div[@class='alert alert-primary']
		// String Expected_title = "Linked List";
		//Assert.assertEquals(driver.getTitle(), Expected_title);
	   // Reporter.log("User successfully navigated to Linked List Page by clicking Get Started Button");
		sign_out = new signout(driver);
		sign_out.click_signout();
	}

	@Test (priority=2)
	//validate the invalid login functionality
	
	public void invalid_login_validation() throws InterruptedException
	{
		dsalgohome.click_signin();
		//User clicks on the signin button
				String invalid_username = "sonia";
		String password ="Hackathon3";
		signin.loginvalidation1(invalid_username, password);
		Thread.sleep(1000);
		String Expectedvalue="Invalid Username and Password";
		WebElement error=driver.findElement(By.xpath("//div[@role='alert']"));
		String actualvalue= error.getText();
		Assert.assertEquals(actualvalue, Expectedvalue );
		Reporter.log("Invalid username or password entered is validated");
		
	}

	@Test(priority=3)
	
	//validate the user is able to navigate to the register page by clicking on the register page from the login page
	public void loginpage_to_register() throws InterruptedException
	{
	signin.click_link_register();			
	String actual_page_title= driver.getTitle();
	Assert.assertEquals(actual_page_title, "Registration");
	Reporter.log("User should navigate to the registration page");
	Thread.sleep(1000);
	}
	
	@Test(priority=4)
	
	//validate the error message is getting displayed when the user did not enter the values in the username and passwordfields
	public void field_validation() throws InterruptedException
	{
			
		String message = driver.findElement(By.name("username")).getAttribute("validationMessage");  
		String expectedmsg = "Please fill out this field.";
		Assert.assertEquals(message, expectedmsg );
		System.out.println(message);
		Reporter.log("Error message validated successfully");
	}
	@BeforeTest
	public void beforetest() throws InterruptedException
	{

	
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();	
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