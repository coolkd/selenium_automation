package com.kuldeep.Udemy_Course;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;

public class Screenshots {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
		
		WindowsUtils.killByName("/home/kuldeep/KRA_2016-2017.xlsx");
	}
}
		
//	  driver.manage().deleteCookieNamed("SessionKey");
	  
		//click on any link
		
		//login page verify login url
		
		/*driver.get("https://google.com/");
		File src =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/home/kuldeep/sc.png"));

	}

}
*/
