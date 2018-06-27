package com.kuldeep.Udemy_Course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Mischellenous {
	static String capchaCheckmark = "//div[@class='recaptcha-checkbox-checkmark']";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.deathbycaptcha.com/user/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		int number = findFramenumber(driver, By.xpath(capchaCheckmark));
		System.out.println("frame number found: " + number);
		driver.switchTo().frame(number);
		driver.findElement(By.xpath(capchaCheckmark)).click();
		driver.switchTo().defaultContent();

		int number1 = findFramenumber(driver, By.xpath(".//*[@id='recaptcha-verify-button']"));
		driver.switchTo().frame(number1);
		driver.findElement(By.xpath(".//*[@id='recaptcha-verify-button']")).click();

	}

	public static int findFramenumber(WebDriver driver, By by) {
		int i = 0;

		int framecount = driver.findElements(By.tagName("iframe")).size();
		System.out.println("FrameCount:" + framecount);
		for (int i1 = 0; i1 < framecount; i1++) {

			driver.switchTo().frame(i1);
			int count = driver.findElements(by).size();
			if (count > 0) {
				i = driver.findElements(by).size();
				System.out.println("Frame found at "+i1);
				break;
			} else

			{
				System.out.println("countinue looping");
			}
		}

		driver.switchTo().defaultContent();
		return i;

	}
}
