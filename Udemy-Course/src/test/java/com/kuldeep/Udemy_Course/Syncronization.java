package com.kuldeep.Udemy_Course;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Syncronization {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.expedia.com/");
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys("nyc");
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(Keys.TAB);
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(Keys.TAB);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(Keys.ENTER);
		
		WebDriverWait d = new WebDriverWait(driver,20);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@target,'6467973')]")));
		
		driver.findElement(By.xpath("//a[contains(@target,'6467973')]")).click();
		
		

	}

}
