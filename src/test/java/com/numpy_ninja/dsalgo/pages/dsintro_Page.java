package com.numpy_ninja.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dsintro_Page {
	WebDriver driver;
	public dsintro_Page(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//*[@href='data-structures-introduction']")
	WebElement btn_DSintro_getstarted;
	
	@FindBy (xpath="//a[@href='time-complexity']")
	WebElement link_Timecomplexity;
	



	
	public void time_complexitylink()
	{
		link_Timecomplexity.click();
	}

	
}
