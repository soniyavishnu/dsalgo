package com.numpy_ninja.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class arrays_Page {
	WebDriver driver;
	public arrays_Page(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='arrays-in-python']")
	WebElement link_arrays_in_python;
	
	@FindBy(xpath="//a[@href='arrays-using-list']")
	WebElement link_arrays_using_list;
	
	@FindBy(xpath="//a[@href='basic-operations-in-lists']")
	WebElement link_basic_operations_list;
	
	@FindBy(xpath="//a[@href='applications-of-array']")
	WebElement link_applications_of_array;
	
	
	
	

	public void click_link_arrays_in_python()
	{
		link_arrays_in_python.click();

	}
	
	public void click_link_arrays_using_list()
	{
		link_arrays_using_list.click();

	}

	public void click_basic_operations_list()
	{
		link_basic_operations_list.click();

	}
	
	public void click_applications_of_array()
	{
		link_applications_of_array.click();

	}

	
}
