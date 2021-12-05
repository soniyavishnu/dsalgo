package com.numpy_ninja.dsalgo.extrafile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.numpy_ninja.dsalgo.utilities.*;
import com.numpy_ninja.dsalgo.pages.*;
public class dsIntroPage_Test_Screenshot_Timestamp {

	WebDriver driver = null;
	dsintro_Page dsintro;
	portal_Page portal;
	home_Page dsalgohome;
	homePage_loggedin homeloggedin;
	signin_Page signin;
	signout sign_out;
	    
	  
	@Test  

  public void dsintropage_navigation() throws IOException, InterruptedException
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
		signin.loginvalidation();
		Thread.sleep(1000);
		homeloggedin= new homePage_loggedin(driver);
		homeloggedin.click_dsintro_getstarted();
		Reporter.log("User is at the Data Structures Introduction page");
		sign_out = new signout(driver);
		sign_out.click_signout();
		Thread.sleep(1000);
		
  }
	@AfterMethod
	
	  public void captureScreenshot() throws IOException {
			//Take screenshot
			  TakesScreenshot ts = (TakesScreenshot)driver; //Typecasting to TakesScreenshot interface
			 /* File sourcepath = ts.getScreenshotAs(OutputType.FILE); //Temporary Location
			  File targetpath = new File(".\\Screenshots\\error.png"); //Specifying the file path to save
			  //FileUtils.copyFile(sourcepath, targetpath); //Copying the file*/
			  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			  String times=new SimpleDateFormat("yyyy_MM_dd").format(new Date());
			  FileUtils.copyFile(scrFile, new File(".\\Screenshots\\"+ timestamp + ".png"));
			  Reporter.log("Taken the Screenshot successsfully");
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

