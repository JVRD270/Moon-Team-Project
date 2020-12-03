package framework;

import java.io.IOException;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import framework.drivers.DriverManagerFactory;



public abstract class TestBase {
	protected WebDriver webDriver;
	protected String baseUrl;
	
	protected void beforeTest() {
		LoadConfigurations();
	}
	
	
	protected void afterTest() {
		this.webDriver.quit();
	}
	
	private void LoadConfigurations() {
		
		HashMap<String, String> configs = null;
		
		try {
			configs = new ConfigurationReader().getPropertiesFromResourceFile("config.properties");
		}
		catch (IOException e) {
			throw new RuntimeException("Config file does not exist.");
		}
		
		this.baseUrl = configs.get(ConfigurationParameters.Url);
		this.webDriver = DriverManagerFactory.getManager(configs.get(ConfigurationParameters.Browser)).getDriver();
	}
	
}
