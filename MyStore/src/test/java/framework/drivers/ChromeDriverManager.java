package framework.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

	public ChromeDriverManager() {
		super("chromedriver.exe", "webdriver.chrome.driver");
	}

	public WebDriver getDriver() {
		super.webDriver = new ChromeDriver();
		return super.webDriver;
	}
}
