package com.kuldeep.Udemy_Course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class salesforce {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.rediff.com/");
		driver.findElement(By.xpath(".//*[@id='signin_info']/a[1]")).click();
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("hellokd");
		driver.findElement(By.cssSelector("input#password")).sendKeys("1234");
		driver.findElement(By.xpath("//input[contains(@name,'procee')]")).click();

	}
}
