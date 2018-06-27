package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class radio {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();

		driver.get("http://qaclickacademy.com/practice.php");
		System.out.println(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());
		driver.findElement(By.xpath("//input[@value='radio2']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());
		System.out.println(driver.findElements(By.xpath("//input[@name='radioButton']")).size());

	}

}
