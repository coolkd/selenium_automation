package com.kuldeep.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractPage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private By username = By.xpath("//input[@id='userLoginForm:userName']");
	private By password = By.xpath("//input[@id='userLoginForm:password']");
	private By submit = By.xpath("//button[@id='userLoginForm:login']");

	public WebElement getUsername() {
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getSubmit() {
		return driver.findElement(submit);
	}

}
