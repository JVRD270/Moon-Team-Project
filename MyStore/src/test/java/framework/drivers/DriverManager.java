package framework.drivers;

import java.net.URL;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	protected URL url;
	protected WebDriver webDriver;
	
	protected DriverManager(String executableUrl, String propertyName) {
		URL url = ClassLoader.getSystemResource(executableUrl);
		System.setProperty(propertyName, url.getFile());
	}
	
	public abstract WebDriver getDriver();
}
