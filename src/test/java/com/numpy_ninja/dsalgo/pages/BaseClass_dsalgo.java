package com.numpy_ninja.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.numpy_ninja.dsalgo.utilities.*;

public class BaseClass_dsalgo {

	public WebDriver driver;

	@BeforeTest
	public void beforeClass()
	{
		driver = BrowserFactory.startApplication(driver, "Chrome", dsalgo_config.url);

		Reporter.log("Welcome to Home page");
	}

	//@AfterClass
	public void afterClass()
	{
		BrowserFactory.quitBrowser(driver);
	}


}
