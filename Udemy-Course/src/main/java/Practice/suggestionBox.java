package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class suggestionBox {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.findElement(By.id("autocomplete")).click();

		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));

		System.out.println("Total countries found : " + list.size());

		/*for (int i = 0; i < list.size(); i++) {
			if ("india".equalsIgnoreCase(list.get(i).getText())) {
				list.get(i).click();
				break;
			}
		}*/

		for (WebElement element : list) {
			if("India".equalsIgnoreCase(element.getText())) {
				element.click();
				break;
			}
		}
	}

}
