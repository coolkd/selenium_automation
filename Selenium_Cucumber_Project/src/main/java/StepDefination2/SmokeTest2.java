package StepDefination2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest2 {
	WebDriver driver;
	
	@Given("^open firefox and start application$")
	public void open_firefox_and_start_application() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
	   
	}

	@When("^I enter valid username and invalid password$")
	public void i_enter_valid_username_and_invalid_password() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("kdcool86");
		driver.findElement(By.id("pass")).sendKeys("test@123");
	    
	}

	@Then("^User should get validation message$")
	public void user_shoulf_get_validation_message() throws Throwable {
		driver.findElement(By.id("loginbutton")).click();
	    
	}


}
