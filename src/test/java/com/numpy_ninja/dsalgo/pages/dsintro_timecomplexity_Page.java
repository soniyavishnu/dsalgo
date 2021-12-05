package com.numpy_ninja.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dsintro_timecomplexity_Page {
	WebDriver driver;
	public dsintro_timecomplexity_Page(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//a[@href='/tryEditor']")
	WebElement btn_tryhere;
	
	
	public void tryhere_timecomplexity()
	{
		btn_tryhere.click();
	}
}
