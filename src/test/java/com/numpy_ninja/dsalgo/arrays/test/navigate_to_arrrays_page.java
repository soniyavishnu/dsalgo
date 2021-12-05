package com.numpy_ninja.dsalgo.arrays.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.numpy_ninja.dsalgo.pages.dsalgo_config;
import com.numpy_ninja.dsalgo.pages.dsintro_Page;
import com.numpy_ninja.dsalgo.pages.homePage_loggedin;
import com.numpy_ninja.dsalgo.pages.home_Page;
import com.numpy_ninja.dsalgo.pages.portal_Page;
import com.numpy_ninja.dsalgo.pages.signin_Page;
import com.numpy_ninja.dsalgo.pages.signout;

public class navigate_to_arrrays_page {
	
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
		Thread.sleep(2000);
		signin = new signin_Page(driver);
		signin.loginvalidation();
		Thread.sleep(2000);
		homeloggedin= new homePage_loggedin(driver);
		homeloggedin.click_array_getstarted();
		Reporter.log("User is at the Array page");
		Thread.sleep(2000);
		
		sign_out = new signout(driver);
		sign_out.click_signout();
		Thread.sleep(2000);
		
  }


  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(dsalgo_config.url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
  }

  
  @AfterTest
  public void aftertest()
  {
	  driver.close();
	  driver.quit();
	  Reporter.log("User successfully logged out");
  }
  

}
