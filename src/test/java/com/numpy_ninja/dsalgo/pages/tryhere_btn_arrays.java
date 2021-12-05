package com.numpy_ninja.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class tryhere_btn_arrays {
	WebDriver driver;
	public tryhere_btn_arrays(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//a[@href='/tryEditor']")
	WebElement btn_tryhere;
	
	
	public void click_tryHere_btn()
	{
		btn_tryhere.click();
	}
}
