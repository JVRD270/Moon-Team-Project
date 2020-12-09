package framework;

import java.io.IOException;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import framework.drivers.DriverManagerFactory;



public abstract class TestBase {
	protected WebDriver webDriver;
	protected String baseUrl;
	
	@BeforeMethod
	protected void beforeMethod() {
		LoadConfigurations();
	}
	
	@AfterMethod
	protected void afterMethod() {
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
