package com.kuldeep.objectrepository;

import org.openqa.selenium.WebDriver;

public class AbstractPage {

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

}
