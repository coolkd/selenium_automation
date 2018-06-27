package com.kuldeep.Udemy_Course;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Misc {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//	  driver.manage().deleteCookieNamed("SessionKey");
	  
		//click on any link
		
		//login page verify login url
		
		driver.get("http://google.com/");

	}

}
