package com.numpy_ninja.dsalgo.tests;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.numpy_ninja.dsalgo.pages.dsalgo_config;
import com.numpy_ninja.dsalgo.pages.dsintro_Page;
import com.numpy_ninja.dsalgo.pages.home_Page;
import com.numpy_ninja.dsalgo.pages.portal_Page;
import com.numpy_ninja.dsalgo.pages.register_Page;
import com.numpy_ninja.dsalgo.pages.signout;
import com.numpy_ninja.dsalgo.utilities.ExcelUtils;

public class register_Page_Validation {

	WebDriver driver;
	dsintro_Page dsintro;
	portal_Page portal;
	register_Page register;
	home_Page dsalgohome;
	signout sign_out;
	

	@Test (priority=2)
	//Validate the user is able to navigate to login page from register page

	public void invalid_login_detils() throws InterruptedException {
	driver.navigate().back();
	
		String message = driver.findElement(By.name("username")).getAttribute("validationMessage");  
		String expectedmsg = "Please fill out this field.";
		Assert.assertEquals(message, expectedmsg );
		System.out.println(message);
		Reporter.log("Error message validated successfully");
	}

	@Test (priority=1)
	//Validate the user is able to navigate to login page from register page

	public void navigate_to_login() throws InterruptedException {
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
		register.click_link_login();
		Thread.sleep(1000);
		Reporter.log("User navigated to the login page");

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
