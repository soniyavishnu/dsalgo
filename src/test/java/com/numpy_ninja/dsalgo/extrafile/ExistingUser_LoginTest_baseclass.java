package com.numpy_ninja.dsalgo.extrafile;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.numpy_ninja.dsalgo.utilities.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.numpy_ninja.dsalgo.pages.*;
public class ExistingUser_LoginTest_baseclass extends BaseClass_dsalgo
{

	//WebDriver driver = null;
	dsintro_Page dsintro;
	portal_Page portal;
	home_Page dsalgohome;
	homePage_loggedin homeloggedin;
	signin_Page signin;
signout sign_out;


	@Test (priority=1)


	public void testcase2() throws InterruptedException 
	{
		Thread.sleep(2000);
		System.out.println("hi");
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
		Reporter.log("User at the DSAlgoHome page");
		Thread.sleep(1000);
		sign_out = new signout(driver);
		sign_out.click_signout();

	}

	



}
