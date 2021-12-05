package com.numpy_ninja.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class home_Page {

	WebDriver driver;
	public home_Page(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(linkText="Sign in")
	WebElement link_signin;

	@FindBy (linkText = "Register")
	WebElement link_Register;

	
	public void click_signin()
	{
		link_signin.click();
	}

	
	public void click_link_register()
	{
		link_Register.click();

	}
	

	public void click_linkedlist_getstarted()
	{
		btn_DSintro_getstarted.click();

	}

}
