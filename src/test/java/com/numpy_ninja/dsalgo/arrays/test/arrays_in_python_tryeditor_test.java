package com.numpy_ninja.dsalgo.arrays.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.numpy_ninja.dsalgo.pages.arrays_Page;
import com.numpy_ninja.dsalgo.pages.dsalgo_config;
import com.numpy_ninja.dsalgo.pages.dsintro_Page;
import com.numpy_ninja.dsalgo.pages.homePage_loggedin;
import com.numpy_ninja.dsalgo.pages.home_Page;
import com.numpy_ninja.dsalgo.pages.portal_Page;
import com.numpy_ninja.dsalgo.pages.signin_Page;
import com.numpy_ninja.dsalgo.pages.signout;
import com.numpy_ninja.dsalgo.pages.tryEditor_Page;
import com.numpy_ninja.dsalgo.pages.tryhere_btn_arrays;
import com.numpy_ninja.dsalgo.utilities.*;
public class arrays_in_python_tryeditor_test {
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
	readFiletxt readtxt;

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
		Thread.sleep(1000);
		signin = new signin_Page(driver);
		signin.loginvalidation();
		Thread.sleep(1000);
		homeloggedin= new homePage_loggedin(driver);
		homeloggedin.click_array_getstarted();
		Reporter.log("User is at the Array page");
		Thread.sleep(1000);

	}

	@Test(priority=2)

	//Validate the user is navigated to the Arrays in python-editor page
	public void array_links_validation() throws InterruptedException
	{
		arraypage= new arrays_Page(driver);
		arraypage.click_link_arrays_in_python();
		Reporter.log("User is at the Arrays in python page");
		tryhere_array= new tryhere_btn_arrays(driver);
		tryhere_array.click_tryHere_btn();
		Reporter.log("User clicked on the try here button");
		Thread.sleep(1000);
	}

	@Test(priority=3)


	//Test to validate if alert popped if user tries to run without entering code
	public void test_run_button() throws InterruptedException
	{
		Reporter.log("Test to validate if alert popped if user tries to run without enterig code");
		editor = new tryEditor_Page(driver);
		Thread.sleep(1000);
		editor.click_run();
		Reporter.log("Run Button clicked successfully");
		Thread.sleep(1000);
		boolean expected_output = true;
		editor.check_alert();
		//Assert.assertEquals(editor.check_output()	, expected_output);
		Reporter.log("Alert is popped successfully");
	}
	

	@Test(priority=5)
	//Test to validate if alert is popped when user tries to run invalid code
	public void invalidecode_validation() throws InterruptedException
	{
		Reporter.log("Test to validate if alert is popped when user tries to run invalid code");
		editor = new tryEditor_Page(driver);
		Thread.sleep(1000);
		String invalidcode = "print(Hello World)";
		editor.write_code_tryeditor(invalidcode);
		Thread.sleep(1000);
		Reporter.log("Code is written successfully in the editor form");
		editor.click_run();
		Reporter.log("Run Button clicked successfully");
		Thread.sleep(1000);
		// editor.check_alert();
		boolean expected_output = true;
		boolean actual_output = editor.check_alert();
		Assert.assertEquals(actual_output, expected_output);
		Reporter.log("Alert is popped successfully");
	}

	@Test (priority = 4)
	// validate if user able to enter valid code , click Run and see the output
	public void validCode_validation() throws InterruptedException, IOException
	{
		Reporter.log("Test to validate if user able to enter valid code , click Run and see the output");
		editor = new tryEditor_Page(driver);
		Thread.sleep(1000);
		// String code = "print(\"Hello World\")";
		//String projectpath = System.getProperty("user.dir");
		// System.out.println(projectpath);
		//String file = projectpath+"//logindata/dsalog_code.txt";
		 readtxt = new readFiletxt();
		String code = readtxt.readFile(dsalgo_config.file);
		System.out.println("code sent"+code);
		editor.write_code_tryeditor(code);
		Thread.sleep(1000);
		Reporter.log("Code is written successfully in the editor form");
		editor.click_run();
		Reporter.log("Run Button clicked successfully");
		Thread.sleep(1000);
		boolean expected_output = true;
		editor.check_alert();
		Assert.assertEquals(editor.check_output()	, expected_output);
		Reporter.log("Output for the code is displayed successfully");
	}
	@Test (priority = 6)
	// validate if user able to enter valid code , click Run and see the output
	public void invalidfile_validation() throws InterruptedException, IOException
	{
		Reporter.log("Test to validate if user able to enter valid code , click Run and see the output");
		editor = new tryEditor_Page(driver);
		Thread.sleep(1000);
		String code = readtxt.readFile(dsalgo_config.invalidcode);
		System.out.println("code sent"+code);
		editor.write_code_tryeditor(code);
		Thread.sleep(1000);
		Reporter.log("Code is written successfully in the editor form");
		editor.click_run();
		Reporter.log("Run Button clicked successfully");
		Thread.sleep(1000);
		boolean expected_output = false;
		editor.check_alert();
		Assert.assertEquals(editor.check_output()	, expected_output);
		Reporter.log("Output for the code is displayed successfully");
	}






	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(dsalgo_config.url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}
	@AfterTest
	public void aftertest() throws InterruptedException
	{
		driver.close();
		driver.quit();
		Reporter.log("User successfully logged out");
	}




}
