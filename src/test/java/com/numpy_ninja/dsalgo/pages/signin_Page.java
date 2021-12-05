package com.numpy_ninja.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class signin_Page {

	WebDriver driver;
	public signin_Page(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//input[@value='Login']")
	WebElement login;

	@FindBy(linkText="Register")
	WebElement link_register;

	public void click_login()
	{
		login.click();
	}

	public void loginvalidation()
	{
		username.sendKeys("soniya");
		Reporter.log("Username value is entered");

		password.sendKeys("Hackathon3");
		Reporter.log("Password value is entered");

		login.click();
		Reporter.log("Submit button is entered");
	}

	public void loginvalidation1(String usernam, String pasword)
	{
		username.sendKeys(usernam);
		Reporter.log("Username value is entered");

		password.sendKeys(pasword);
		Reporter.log("Password value is entered");

		login.click();
		Reporter.log("Submit button is clicked");
	}

	public void click_link_register()
	{

		link_register.click();
	}
}
