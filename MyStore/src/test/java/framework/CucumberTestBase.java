package framework;

import org.openqa.selenium.WebDriver;

public class CucumberTestBase extends TestBase {
	
	private static CucumberTestBase cucumberTestBase = new CucumberTestBase();
	
	public void beforeCucumberScenario() {
		cucumberTestBase.beforeMethod();
	}
	
	public void afterCucumberScenario() {
		cucumberTestBase.afterMethod();
	}
	
	public static CucumberTestBase getInstance() {
		if(cucumberTestBase == null)
			cucumberTestBase = new CucumberTestBase();
		
		return cucumberTestBase;
	}
	
	public WebDriver getWebDriver() {
		return cucumberTestBase.webDriver;
	}
	
	public String getBaseUrl() {
		return cucumberTestBase.baseUrl;
	}
}
