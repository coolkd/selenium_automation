package com.kuldeep.Udemy_Course;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHanle2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://accounts.google.com/signup");
		driver.findElement(By.xpath("//a[contains(@target,'_blank')]")).click();
		System.out.println("Before Switching");
		System.out.println(driver.getTitle());
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		System.out.println("After Switching");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentid);
		System.out.println("Switching back to parent");
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
