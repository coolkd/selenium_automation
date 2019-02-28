package Practice;

import org.openqa.selenium.WebDriver;

public class MyWebDriver implements AutoCloseable {

	private final WebDriver webDriver;

	public MyWebDriver(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	@Override
	public void close() throws Exception {
		System.out.println("Closing browser in 15sec.");
		Thread.sleep(15000);
		webDriver.quit();
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

}
