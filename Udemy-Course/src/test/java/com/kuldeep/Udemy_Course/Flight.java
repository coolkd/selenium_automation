package com.kuldeep.Udemy_Course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Flight {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://hmatravel.com/travel/");
		driver.findElement(By.xpath("//input['bookingTabView:flightSearch:j_idt72:0']")).click();
		
	}
}
