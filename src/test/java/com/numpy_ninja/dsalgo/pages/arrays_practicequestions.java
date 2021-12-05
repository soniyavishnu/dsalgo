package com.numpy_ninja.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class arrays_practicequestions {

	WebDriver driver;
	public arrays_practicequestions(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//a[@href='/array/practice']")
			WebElement link_practice_questions;
	
	@FindBy (xpath="//a[@href='/question/1']")
	WebElement link_searchthe_array;
	
	@FindBy (xpath="//a[@href='/question/2']")
	WebElement link_Max_ConsecutiveOnes;
	
	@FindBy (xpath="//a[@href='/question/3']")
	WebElement link_find_numbers;
	
	@FindBy (xpath="//a[@href='/question/4']")
	WebElement link_squares_sortedarray;
	
	
	
	public void click_practice_questions()
	{
		link_practice_questions.click();
	}
	
	
	public void click_link_searchthe_array()
	{
		link_searchthe_array.click();
	}
	

	public void click_link_Max_ConsecutiveOnes()
	{
		link_Max_ConsecutiveOnes.click();
	}
	
	public void click_link_find_numbers()
	{
		link_find_numbers.click();
	}

	public void click_link_squares_sortedarray()
	{
		link_squares_sortedarray.click();
	}
	
}
