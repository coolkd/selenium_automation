package com.kuldeep.Udemy_Course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://spicejet.com");
		//driver.findElement(By.id("noOfTravellers")).click();
		//Select s= new Select(driver.findElement(By.id("ddlAdult")));
		//s.selectByValue("3");
		//s.selectByIndex(6);
	
		//driver.findElement(By.xpath(".//*[@id='MainBody_ObeFlights1_autoOriginHome_AutoText']")).click();
		
		driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[@value='AMD']")).click();
		driver.findElement(By.xpath("(//a[@value='GOI'])[2]")).click();
		
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		
		
		
		
	}

}
