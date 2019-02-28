package com.kuldeep.objectrepository;

import java.io.FileInputStream;
import java.util.Properties;

public class employeeURL {

	private static Properties prop = new Properties();
	static {
		try {
			FileInputStream fis = new FileInputStream(
					"/home/kuldeep/selenium_automation/Udemy-Course/src/main/java/Practice/dataD.properties");
			prop.load(fis);
		} catch (Exception exception)

		{

		}

	}

	public static String getProperty(String propertyKey) {
		return prop.getProperty(propertyKey);
	}
}
