package com.kuldeep.Udemy_Course;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// 1.Give me the count of links on the page.
		// 2.Count of footer section

		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://qaclickacademy.com/practice.php");

		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));// Limiting webdriver scope
		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		// 3.Count of footer's column section

		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());

		// 4.Click on each link in the column and check if the page are opening

		for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++) {

			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000);
		}
		// Opens all the tabs

		Set<String> abc = driver.getWindowHandles();// 4
		Iterator<String> it = abc.iterator();

		while (it.hasNext()) {

			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			driver.quit();
		}
	}
}
