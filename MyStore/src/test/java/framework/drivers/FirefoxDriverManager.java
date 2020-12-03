package framework.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
	
	public FirefoxDriverManager() {
		super("geckodriver.exe", "webdriver.gecko.driver");
	}

	public WebDriver getDriver() {
		super.webDriver = new FirefoxDriver();
		return super.webDriver;
	}

}
