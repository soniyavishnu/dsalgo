package com.numpy_ninja.dsalgo.arrays.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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

public class links_validation_at_Array_page {

	WebDriver driver = null;
	dsintro_Page dsintro;
	portal_Page portal;
	home_Page dsalgohome;
	homePage_loggedin homeloggedin;
	signin_Page signin;
	signout sign_out;
	arrays_Page arraypage;


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

	}

	@Test(priority=2)

	//Validate the user is able to navigate to different array pages

	public void array_links_validation() throws InterruptedException
	{
		arraypage= new arrays_Page(driver);
		arraypage.click_link_arrays_in_python();
		Reporter.log("User is at the Arrays in python page");

		driver.navigate().back();
		Thread.sleep(2000);
		arraypage.click_link_arrays_using_list();
		Reporter.log("User is at the arrays using list page");
		driver.navigate().back();
		Thread.sleep(2000);
		arraypage.click_basic_operations_list();
		Reporter.log("User is navigated to the basic operations list page");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		arraypage.click_applications_of_array();
		Thread.sleep(2000);
		Reporter.log("User is navigated to the applications of array page");
		/*Select dropdownvalue=new Select(driver.findElement(By.cssSelector("nav-link dropdown-toggle")));
		dropdownvalue.selectByValue("Array");
		Thread.sleep(2000);
		Reporter.log("User is navigated to the Arrays page");*/

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");

		//Click on Country Dropdown

		driver.findElement(By.xpath("//*[@class='nav-link dropdown-toggle']")).click();

		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='dropdown-item']"));
		System.out.println(allOptions.size());



		for(int i = 0; i<=allOptions.size()-1; i++) {


			if(allOptions.get(i).getText().contains("Array")) {

				allOptions.get(i).click();
				break;

			}
		}
		Reporter.log("User is navigated back to the array page");

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

		sign_out = new signout(driver);
		sign_out.click_signout();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		Reporter.log("User successfully logged out");
	}






}
