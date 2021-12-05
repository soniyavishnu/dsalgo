package com.numpy_ninja.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signout {
	WebDriver driver;
	public signout(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Sign out")
	WebElement link_signout;
	
	public  void click_signout()
	{
		link_signout.click();
	}
	
}
