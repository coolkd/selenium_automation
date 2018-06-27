package com.kuldeep.Udemy_Course;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class calendar {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.makemytrip.com/");

		driver.findElement(By.id("hp-widget__depart")).click();
		Thread.sleep(5000);

		while (!driver.findElement(By.cssSelector("[class='ui-datepicker-month']")).getText()
				.contains("SEPTEMBER")) {
			driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-e']")).click();
		}

		List<WebElement> dates = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		// Grab common attribute//put into list and iterate

		int count = dates.size();
		System.out.println("selectDay date count:"+count);
		//traditional for loop
/*		for (int i = 0; i < count; i++) {

			String text = dates.get(i).getText();

			if (text.equalsIgnoreCase("20")) {
				dates.get(i).click();

				break;
			}

		}*/
		
		//foreach loop
		for (WebElement element : dates) {
			if ("20".equalsIgnoreCase(element.getText())) {
				element.click();
				break;
			}
		}

		//driver.quit();

	}

}
