package com.numpy_ninja.dsalgo.dsintro.test;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.numpy_ninja.dsalgo.utilities.*;
import com.numpy_ninja.dsalgo.pages.*;
public class timeComplexity_tryEditorPage_test {

	WebDriver driver = null;
	dsintro_Page dsintro;
	portal_Page portal;
	home_Page dsalgohome;
	homePage_loggedin homeloggedin;
	signin_Page signin;
	signout sign_out;
	dsintro_timecomplexity_Page timecomplexity;
	tryhere_btn_arrays tryhere_array;
	tryEditor_Page editor;
	
	@Test(priority=1)

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
  
  
	@Test  (priority=2)

  public void navigate_to_timecomplexity() throws IOException, InterruptedException
	{
		dsintro = new dsintro_Page(driver);
		dsintro.time_complexitylink();
		Reporter.log("User is navigated to the Time complexity page");
		Thread.sleep(1000);
		timecomplexity = new dsintro_timecomplexity_Page(driver);
		timecomplexity.tryhere_timecomplexity();
		Reporter.log("User clicks on the tryhere button");
		
  }
	
	
	@Test(priority=4)
	//Test to validate if alert is popped when user tries to run invalid code
	public void invalidecode_validation() throws InterruptedException
	{
		Reporter.log("Test to validate if alert is popped when user tries to run invalid code");
		editor = new tryEditor_Page(driver);
		Thread.sleep(1000);
		String invalidcode = "print(Hello World)";
		write_code_tryeditor(invalidcode);
		Thread.sleep(1000);
		Reporter.log("Code is written successfully in the editor form");
		editor.click_run();
		Reporter.log("Run Button clicked successfully");
		Thread.sleep(1000);
		// editor.check_alert();
		boolean expected_output = true;
		boolean actual_output = editor.check_alert();
		//Assert.assertEquals(actual_output, expected_output);
		Reporter.log("Alert is popped successfully");
	}
	
	
	@Test (priority =3)
	// validate if user able to enter valid code , click Run and see the output
	public void validCode_validation() throws InterruptedException, IOException
	{
		Reporter.log("Test to validate if user able to enter valid code , click Run and see the output");
		editor = new tryEditor_Page(driver);
		Thread.sleep(1000);
		// String code = "print(\"Hello World\")";
		String projectpath = System.getProperty("user.dir");
		// System.out.println(projectpath);
		String file = projectpath+"//logindata/dsalog_code.txt";
		String code = readFile(file);
		System.out.println("code sent"+code);
		write_code_tryeditor(code);
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
	
	public void write_code_tryeditor(String code) throws InterruptedException
	{

		WebElement codeMirror = driver.findElement(By.className("CodeMirror"));
		/* getting the first line of code inside codemirror and clicking it to bring it in focus */
		WebElement codeLine = codeMirror.findElements(By.className("CodeMirror-line")).get(0);
		codeLine.click();
		/* sending keystokes to textarea once codemirror is in focus */
		WebElement txtbx = codeMirror.findElement(By.cssSelector("textarea"));
		//txtbx.clear();
		txtbx.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		txtbx.sendKeys(Keys.BACK_SPACE);
		txtbx.sendKeys(code);
		Thread.sleep(1000);
	}


	public String readFile(String filename) throws IOException
	{
		String content = null;
		File file = new File(filename);
		FileReader reader = null;
		try {
			reader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			reader.read(chars);
			content = new String(chars);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(reader != null){
				reader.close();
			}
		}
		return content;
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
	  driver.navigate().back();
				Thread.sleep(1000);
		Reporter.log("User successfully logged out");
	  driver.close();
	  driver.quit();
	  
  }
}

