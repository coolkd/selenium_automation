package com.kuldeep.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingPanel extends AbstractPage {

	public BookingPanel(WebDriver driver) {
		super(driver);
	}

	private final By origin = By.xpath("//div[@id='flight-booking-panel-leaving-from'] //input");
	private final By destination = By.xpath("//div[@id='flight-booking-panel-going-to'] //input");

	public By getOrigin() {
		return origin;
	}

	public By getDestination() {
		return destination;
	}

	public WebElement getOriginWebElement() {
		return driver.findElement(origin);
	}

}
