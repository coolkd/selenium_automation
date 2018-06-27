package com.kuldeep.Udemy_Course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TableExcercises {

	private static final String ActualTotal = null;

	public static void main(String[] args) {
		int sum= 0;
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get(
				"http://www.cricbuzz.com/live-cricket-scorecard/18871/eng-vs-aus-1st-odi-australia-tour-of-england-2018");
		WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		int rowcount = table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
		int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"))
				.size();

		for (int i = 0; i < count - 2; i++) {
			String value = table
					.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i)
					.getText();
			int valueinterger = Integer.parseInt(value);
			sum = sum + valueinterger;
		}
		//System.out.println(sum);
		String Extras=driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		int extrasValue=Integer.parseInt(Extras);
		int TotalSumValue=sum+extrasValue;
		System.out.println(TotalSumValue);
		
		String ActualTotal=driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		int ActualTotalVAlue = Integer.parseInt(ActualTotal);
		if(ActualTotalVAlue==TotalSumValue)
		{
			System.out.println("count matches");
			
		}
		else
		{
			System.out.println("count fails");
		}
		
		driver.close();

	}

}
