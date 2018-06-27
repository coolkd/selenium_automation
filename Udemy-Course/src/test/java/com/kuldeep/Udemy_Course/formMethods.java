package com.kuldeep.Udemy_Course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class formMethods {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();

		// Is displayed is used when particulat object is in code base but it is in visible
		
		driver.get("http://spicejet.com/");
		System.out.println("Before clicking on multi city radio button");
		System.out.println(driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_view_date2']")).isDisplayed());
		driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_rbtnl_Trip_2']")).click();
		driver.findElement(By.xpath(".//*[@id='MultiCityModelAlert']")).click();
		System.out.println("After clicking on multi city radio button");
		//System.out.println(driver.findElement(By.xpath(".//*[@id='ctl00_maContent_rbtnl_Trip_2']")).isDisplayed());
		
		System.out.println(driver.findElement(By.xpath(".//*[@id='subFooter']/div/span[2]/div/p")).getText());

		// If you want to validate the object which is present in the web page or code base
		
		int count = driver.findElements(By.xpath(".//*[@id='ctl00_maContent_view_date2']")).size();
		if (count == 0) {
		}
		System.out.println("Verified");
	}
}
