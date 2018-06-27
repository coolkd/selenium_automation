package com.kuldeep.Udemy_Course;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.util.Strings;

public class WindowHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://accounts.google.com/signup");
		driver.findElement(By.xpath("//a[contains(@target,'_blank')]")).click();
		System.out.println("Parent title " + driver.getTitle());
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentid = it.next();
		final String childid = it.next();
		driver.switchTo().window(childid);

		WebDriverWait d = new WebDriverWait(driver, 5);
		d.until(ExpectedConditions.and(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver1) {
				return isNotNullOrEmpty(driver.getTitle());
			}
		}));

		System.out.println("Child Title " + driver.getTitle());
		driver.quit();

	}

	public static boolean isNotNullOrEmpty(String string) {
		return !Strings.isNullOrEmpty(string);

	}

}
