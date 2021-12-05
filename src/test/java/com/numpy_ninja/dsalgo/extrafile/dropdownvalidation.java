package com.numpy_ninja.dsalgo.extrafile;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dropdownvalidation {


	public static void main(String[] aa) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://dsportalapp.herokuapp.com/array/applications-of-array/");
		driver.manage().window().maximize();

		Thread.sleep(3000);
		//scroll down the page

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");

		//Click on Country Dropdown

		driver.findElement(By.xpath("//*[@class='nav-link dropdown-toggle']")).click();

		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='dropdown-item']"));
		System.out.println(allOptions.size());



		for(int i = 0; i<=allOptions.size()-1; i++) {


			if(allOptions.get(i).getText().contains("Array")) {

				allOptions.get(i).click();
				break;

			}
		}

	}
}
