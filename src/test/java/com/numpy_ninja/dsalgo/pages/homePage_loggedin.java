package com.numpy_ninja.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage_loggedin {

	WebDriver driver;
	public homePage_loggedin(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//a[@href='data-structures-introduction']")
	WebElement btn_DSintro_getstarted;

	@FindBy(linkText="Sign out")
	WebElement link_signout;
	
	@FindBy(xpath="//*[@href='array']")
	WebElement btn_array_getstarted;




	public void click_signout()
	{
		link_signout.click();
	}
	


	public void click_dsintro_getstarted()
	{
		btn_DSintro_getstarted.click();

	}

	public void click_array_getstarted()
	{
		btn_array_getstarted.click();

	}

	
}
