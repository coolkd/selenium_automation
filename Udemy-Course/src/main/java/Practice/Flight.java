package Practice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kuldeep.objectrepository.BookingPanel;
import com.kuldeep.objectrepository.LoginPage;
import com.kuldeep.utils.ComboBoxUtils;

public class Flight {

	private static List<String> firstNameList = Arrays.asList("Kuldeep", "Vinayak", "Max", "John");
	private static List<String> lastNameList = Arrays.asList("Mishra", "More", "Well", "Ebrahem");

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");



		// MyWebDriver driver = new FirefoxDriver();
		try (MyWebDriver myDriver = new MyWebDriver(new FirefoxDriver())) {
			WebDriver driver = myDriver.getWebDriver();
			// driver.manage().window().fullscreen();
			login(driver);
			changeProfileCorp(driver);
			BookingPanel panel = new BookingPanel(driver);
			// from
			selectAutoSuggest(driver, panel.getOrigin(), "BOM");
			// flight-booking-panel-going-to

			// to
			selectAutoSuggest(driver, panel.getDestination(), "DELHI");

			// departure date
			driver.findElement(By.xpath("//div[@id='flight-booking-panel-depart-date']//button")).click();
			while (!driver.findElement(By.xpath("//span[@class='v-datefield-calendarpanel-month']")).getText()
					.contains("August 2018")) {

				driver.findElement(By.cssSelector("[class='v-button-nextmonth']")).click();
			}
			List<WebElement> dates = driver.findElements(By.cssSelector("[class='v-datefield-calendarpanel-day']"));
			int count = dates.size();
			System.out.println("Select day count:" + count);

			for (WebElement elements : dates) {

				if ("10".equalsIgnoreCase(elements.getText())) {
					elements.click();
					break;
				}
			}
			// adult count
			selectAutoSuggest(driver, By.xpath("//div[@id='flight-booking-panel-adult'] //input"), "2");
			selectAutoSuggest(driver, By.xpath("//div[@id='flight-booking-panel-preferred-carrier'] //input"), "SG");
			// child count
			// selectAutoSuggest(driver, By.xpath("//div[@id='flight-booking-panel-child']
			// //input"), "2");
			// click to search button
			driver.findElement(By.xpath("//div[@id='flight-booking-panel-search']")).click();
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'wait-box')]")));

			List<WebElement> select = driver.findElements(By.xpath(
					"//ul[@class='forward listView flights']//div[@class='book_button']//div[contains(@class,'v-button')]"));
			System.out.println(select.size());
			select.get(0).click();

			List<WebElement> select1 = driver.findElements(By.xpath(
					"//ul[@class='back listView flights']//div[@class='book_button']//div[contains(@class,'v-button')]"));
			System.out.println(select1.size());
			select1.get(0).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='v-slot v-slot-action-button v-slot-tiny']")).click();
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("document.getElementById('continue').scrollIntoView();");

			driver.findElement(By.xpath("//div[@id='continue']")).click();

			List<WebElement> titles = driver
					.findElements(By.xpath(".//*[@class='guest-list']//div[@class='v-slot v-slot-pax-title'] //input"));
			for (WebElement title : titles) {
				ComboBoxUtils.selectComboBox(title, "Mr");
			}
			// driver.findElements(By.id("firstname")).get(1).sendKeys(firstNameList.get(1));
			for (int i = 0; i < driver.findElements(By.id("firstname")).size(); i++) {
				driver.findElements(By.id("firstname")).get(i).click();
				driver.findElements(By.id("firstname")).get(i).clear();
				Thread.sleep(2000);
				driver.findElements(By.id("firstname")).get(i).sendKeys(firstNameList.get(i));
				Thread.sleep(2000);
				driver.findElements(By.id("firstname")).get(i).sendKeys(Keys.TAB);
			}

			for (int i = 0; i < driver.findElements(By.id("lastname")).size(); i++) {
				driver.findElements(By.id("lastname")).get(i).click();
				driver.findElements(By.id("lastname")).get(i).clear();
				Thread.sleep(2000);
				driver.findElements(By.id("lastname")).get(i).sendKeys(lastNameList.get(i));
				Thread.sleep(2000);
				driver.findElements(By.id("lastname")).get(i).sendKeys(Keys.TAB);
			}

			for (int i = 0; i < driver.findElements(By.id("mm")).size(); i++) {

				ComboBoxUtils.selectComboBox(driver.findElements(By.xpath("//div[@id='mm']//input")).get(i), "7");
			}

			for (int i = 0; i < driver.findElements(By.id("add-meal")).size(); i++) {
				driver.findElements(By.id("add-meal")).get(i).click();

			}

			/*
			 * List<WebElement> firstnames = driver.findElements(By.id("firstname")); int
			 * counter = 0; for (WebElement firstname : firstnames) { firstname.clear();
			 * firstname.sendKeys(firstNameList.get(counter)); counter++; }
			 */
			/*
			 * List<WebElement> lastnames = driver.findElements(By.id("lastname")); int
			 * counter1 = 0; for (WebElement lastname : lastnames) { lastname.clear();
			 * lastname.sendKeys(lastNameList.get(counter1)); counter1++; }
			 */

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private static void changeProfileCorp(WebDriver driver) throws InterruptedException {
		WebElement changeProfileButton = driver
				.findElement(By.xpath("//div[contains(@class, 'v-button-change-profile-layout-button')]"));
		System.out.println(changeProfileButton.getText());
		changeProfileButton.click();
		System.out.println("clicked change profile button");

		selectAutoSuggest(driver, By.xpath("//input[contains(@class, 'v-filterselect')]"), "Kelkar");

		Thread.sleep(2000);
		System.out.println("Selected corporate is "
				+ driver.findElement(By.xpath("//input[contains(@class, 'v-filterselect')]")).getAttribute("value"));
		driver.findElement(By.xpath("//div[@class='search-form'] //div[contains(@class,'v-button-action-button')]"))
				.click();
		Thread.sleep(2000);
		List<WebElement> selectCorp = driver.findElements(
				By.xpath("//tr[contains (@class,'v-table-row')] //div[@class='v-button v-widget link v-button-link']"));
		for (int i = 0; i < selectCorp.size(); i++) {
			WebElement element = selectCorp.get(i);
			System.out.println(element.getText());
			if (element.getText().contains("Jatin")) {
				element.click();
				break;

			}

		}
	}

	private static void login(WebDriver driver) {
		driver.get("http://stage.hmatravel.com/travel/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		LoginPage login = new LoginPage(driver);
		login.getUsername().sendKeys("happy-hma travels-hsingh");
		login.getPassword().sendKeys("welcome");
		login.getSubmit().click();

		// driver.findElement(By.xpath("//input[@id='userLoginForm:userName']")).sendKeys("happy-hma
		// travels-hsingh");
		// driver.findElement(By.xpath("//input[@id='userLoginForm:password']")).sendKeys("welcome");
		// driver.findElement(By.xpath("//button[@id='userLoginForm:login']")).click();

		System.out.println(driver.getTitle());
	}

	public static void selectAutoSuggest(WebDriver driver, By by, String key) throws InterruptedException {

		driver.findElement(by).click();
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(key);
		Thread.sleep(2000);
		driver.findElement(by).sendKeys(Keys.DOWN);
		driver.findElement(by).sendKeys(Keys.ENTER);
		System.out.println(driver.findElement(by).getAttribute("value"));

	}

	// public static void selectComboBox(WebElement element, int nthElement) throws
	// InterruptedException {
	// element.click();
	// int i = 0;
	// String elementValue = element.getAttribute("value");
	// if (elementValue != null && elementValue.length() > 0) {
	// i = 1;
	// }
	// Thread.sleep(500);
	// for (; i <= nthElement; i++) {
	// element.sendKeys(Keys.DOWN);
	// Thread.sleep(500);
	// }
	// element.sendKeys(Keys.ENTER);
	// System.out.println(element.getAttribute("value"));
	//
	// }

}
