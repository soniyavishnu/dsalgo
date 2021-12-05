package com.numpy_ninja.dsalgo.dsintro.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.numpy_ninja.dsalgo.utilities.*;
import com.numpy_ninja.dsalgo.pages.*;
public class timeComplexity_Page_test {

	WebDriver driver = null;
	dsintro_Page dsintro;
	portal_Page portal;
	home_Page dsalgohome;
	homePage_loggedin homeloggedin;
	signin_Page signin;
	signout sign_out;
	dsintro_timecomplexity_Page timecomplexity;
	    
  
	@Test  (priority=1)

  public void navigate_to_timecomplexity() throws IOException, InterruptedException
	{
		dsintro = new dsintro_Page(driver);
		dsintro.time_complexitylink();
		Reporter.log("User is navigated to the Time complexity page");
		Thread.sleep(1000);
		timecomplexity = new dsintro_timecomplexity_Page(driver);
		Reporter.log("User clicks on the tryhere button");
		timecomplexity.tryhere_timecomplexity();
		Reporter.log("User is at the tryEditor page");
		
		
  }


  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(dsalgo_config.url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
  }
  
  @BeforeMethod
	public void navigate_to_dsintropage() throws InterruptedException
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
	}

  
  @AfterTest
  public void aftertest() throws InterruptedException
  {
	  driver.navigate().back();
		sign_out = new signout(driver);
		sign_out.click_signout();
		Thread.sleep(1000);
	  driver.close();
	  driver.quit();
	  Reporter.log("User successfully logged out");
	  
  }
}

