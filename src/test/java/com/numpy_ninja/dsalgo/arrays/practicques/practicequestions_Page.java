package com.numpy_ninja.dsalgo.arrays.practicques;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.numpy_ninja.dsalgo.pages.arrays_Page;
import com.numpy_ninja.dsalgo.pages.arrays_practicequestions;
import com.numpy_ninja.dsalgo.pages.dsalgo_config;
import com.numpy_ninja.dsalgo.pages.dsintro_Page;
import com.numpy_ninja.dsalgo.pages.homePage_loggedin;
import com.numpy_ninja.dsalgo.pages.home_Page;
import com.numpy_ninja.dsalgo.pages.portal_Page;
import com.numpy_ninja.dsalgo.pages.signin_Page;
import com.numpy_ninja.dsalgo.pages.signout;
import com.numpy_ninja.dsalgo.pages.tryEditor_Page;
import com.numpy_ninja.dsalgo.pages.tryhere_btn_arrays;

public class practicequestions_Page {
	WebDriver driver = null;
	dsintro_Page dsintro;
	portal_Page portal;
	home_Page dsalgohome;
	homePage_loggedin homeloggedin;
	signin_Page signin;
	signout sign_out;
	arrays_Page arraypage;
	tryhere_btn_arrays tryhere_array;
	tryEditor_Page editor;
	arrays_practicequestions practiceques;

	@Test  (priority=1)

	//Validate the user is navigated to the array page
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
		arraypage= new arrays_Page(driver);
		arraypage.click_link_arrays_in_python();
		Reporter.log("User is at the Arrays in python page");

	}
	
	@Test (priority=2)
	//Validate if the user is navigated to the practice questions page
	public void navigate_to_practicequestions() throws InterruptedException
	{
		practiceques=new arrays_practicequestions(driver);
		practiceques.click_practice_questions();
		Reporter.log("User is at the practice questions page");
		Thread.sleep(1000);
		
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
	public void aftertest() throws InterruptedException
	{
		driver.close();
		driver.quit();
		Reporter.log("User successfully logged out");
	}
}
