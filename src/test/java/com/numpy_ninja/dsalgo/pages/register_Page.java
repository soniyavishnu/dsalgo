package com.numpy_ninja.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class register_Page {
	WebDriver driver;
	public register_Page(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="username")
			WebElement enterusername;
	
	@FindBy (name="password1")
	WebElement enterpassword;
	
	@FindBy (name="password2")
	WebElement enterpwdconfirmation;
	
	@FindBy (xpath="//input[@value='Register']")
	WebElement btn_register;
	
	@FindBy(linkText="Login")
	WebElement link_login;
	
	public void logindetails() throws InterruptedException
	{
		enterusername.sendKeys("soniya");
	Reporter.log("Username value is entered");
	Thread.sleep(1000);

	enterpassword.sendKeys("Hackathon3");
	Reporter.log("Password value is entered");
	Thread.sleep(1000);

	enterpwdconfirmation.sendKeys("Hackathon3");
	Reporter.log("Password value is entered");
	Thread.sleep(1000);
	btn_register.click();
	Reporter.log("Submit button is clicked");
}
	public void logindetails_ddt(String username, String password) throws InterruptedException
	{
		enterusername.sendKeys(username);
		Reporter.log("Username value is entered");
		Thread.sleep(1000);

		enterpassword.sendKeys(password);
		Reporter.log("Password value is entered");
		Thread.sleep(1000);

		enterpwdconfirmation.sendKeys(password);
		Reporter.log("Password value is entered");
		Thread.sleep(1000);
		btn_register.click();
		Reporter.log("Submit button is clicked");

}
	
	public void click_link_login()
	{
	link_login.click();
	}

	public void click_btn_register()
	{
		btn_register.click();
	}
}
