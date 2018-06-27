package com.kuldeep.Udemy_Course;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Enter the letters BENG
//Verify if Airport option is displayed in the suggestive box

public class Autosuggestive {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://ksrtc.in/oprs-web/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#fromPlaceName")).sendKeys("BENG");
		driver.findElement(By.cssSelector("#fromPlaceName")).sendKeys(Keys.DOWN);
		driver.findElement(By.cssSelector("#fromPlaceName")).sendKeys(Keys.DOWN);
		System.out.println(driver.findElement(By.cssSelector("#fromPlaceName")).getText());

		// Javascript DDOM can extract hidden elements
		// Because selenium can not identify hidden elements - (Ajax implementation)
		// Investigate the properties of object if it have any hidden text

		// JavascriptExecuter

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = " return document.getElementById(\"fromPlaceName\").value";
		String text = (String) js.executeScript(script);
		System.out.println(text);
		// BENGALURU INTERNATION AIPORT
		while (!text.equalsIgnoreCase("BENGALURU INTERNATION AIPORT"))

		{
			driver.findElement(By.cssSelector("#fromPlaceName")).sendKeys(Keys.DOWN);
			text = (String) js.executeScript(script);
			System.out.println(text);

		}

	}

}
