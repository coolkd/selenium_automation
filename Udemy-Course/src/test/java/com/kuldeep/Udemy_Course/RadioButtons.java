package com.kuldeep.Udemy_Course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButtons {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		//driver.findElement(By.xpath("//input[@value='Milk']")).click();
		int count =(driver.findElements(By.xpath("//input[@name='group1']")).size());
		
		for(int i=0; i<count; i++){
			
			driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
			
			String text =(driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value"));
			if (text.equals("Cheese")) 
			{
				driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
				
			}
			
		}
		
		
		
		
		
	}

}