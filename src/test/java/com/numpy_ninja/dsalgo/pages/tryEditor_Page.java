package com.numpy_ninja.dsalgo.pages;

import java.awt.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class tryEditor_Page {
	WebDriver driver;
	public tryEditor_Page(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	/*@FindBy (className="CodeMirror")
	WebElement codeMirror;
	
	@FindBy (className="CodeMirror-line")).get(0)
	WebElement codeLine;*/
	
	
	//WebElement
	//@FindBy(css ="div.CodeMirror cm-s-default")
	@FindBy(css ="textarea")
	WebElement textarea;
	 
	//Run button
	@FindBy(xpath="//button[@type='button']")
	WebElement button_run;
	
	//Submit button
		@FindBy(xpath="//input[@type='submit']")
		WebElement button_submit;

	//Output 
	@FindBy(id="output")
	WebElement txtarea_output;
	//method to click the run button
		public void click_run()
		{
			button_run.click();
		}
		
		public void click_submit()
		{
			button_submit.click();
		}
		//Method to check if output is displayed
		public boolean check_output()
		{
			Boolean output = txtarea_output.isDisplayed();
			return output;
		}
		
		//Method to catch if alert is displayed
		public Boolean check_alert() 
		{
			//Boolean output;
//			String alert_msg =driver.switchTo().alert().getText();
//			if (alert_msg.length()> 0)
//				output = true;
//			else output = false;
			
			/*
			 * Alert alert = driver.switchTo().alert().accept(); alert.accept(); String
			 * alert_msg = alert.getText(); if (alert_msg.length()> 0) output = true; else
			 * output = false;
			 */
			
			//return output;
			try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			return true;
			}
			catch (NoAlertPresentException e)
			{
			return false;
			}
		}
	
		public void write_code_tryeditor(String code) throws InterruptedException
		{

			WebElement codeMirror = driver.findElement(By.className("CodeMirror"));
			/* getting the first line of code inside codemirror and clicking it to bring it in focus */
			WebElement codeLine = codeMirror.findElements(By.className("CodeMirror-line")).get(0);
			codeLine.click();
			/* sending keystokes to textarea once codemirror is in focus */
			WebElement txtbx = codeMirror.findElement(By.cssSelector("textarea"));
			// txtbx.clear();
			txtbx.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			txtbx.sendKeys(Keys.BACK_SPACE);
			txtbx.sendKeys(code);
			Thread.sleep(1000);
		}

}
