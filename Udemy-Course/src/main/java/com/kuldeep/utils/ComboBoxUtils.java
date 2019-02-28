package com.kuldeep.utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class ComboBoxUtils {

	public static void selectComboBox(WebElement element, String expectedValue) throws InterruptedException {
		String lastValue;

		element.click();
		String elementValue = getElementTextOrValue(element);
		while (!expectedValue.equals(elementValue)) {
			lastValue = elementValue;
			element.sendKeys(Keys.DOWN);
			element.sendKeys(Keys.ENTER);
			Thread.sleep(500);
			elementValue = getElementTextOrValue(element);
			if (lastValue.equals(elementValue)) {
				break;
			}
		}
		System.out.println("Selected Value is :" + element.getAttribute("value"));

	}

	private static String getElementTextOrValue(WebElement element) {
		String elementValue = element.getAttribute("value");
		if (StringUtils.isNotBlank(elementValue)) {
			return elementValue;
		}
		String elementText = element.getText();
		if (StringUtils.isNotBlank(elementText)) {
			return elementText;
		}
		return null;
	}
	
	public static void main(String[] args) {
		StringUtils.isNotBlank("Hellow");
	}

}
