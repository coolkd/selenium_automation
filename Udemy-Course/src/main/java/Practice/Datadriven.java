package Practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Datadriven {

	public WebDriver driver;

	@Test

	public void login() throws IOException {
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"//home//kuldeep//workspace//Udemy-Course//src//main//java//Practice//dataD.properties");

		prop.load(fis);

		if (prop.getProperty("browser").equals("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (prop.getProperty("browser").equals("chrome")) {
			driver = new ChromeDriver();
		}
		driver.get(prop.getProperty("url"));

	}

	@Test(priority = 1)
	public void LoginAgain() {
		System.out.println("Selenium Test");
	}

	@Test(priority = 2)
	public void LogOut() {
		System.out.println("LogOut Soon");
	}

	@Test(priority = 3)
	public void Gotohell() {
		System.out.println("I am coming");
	}

}
