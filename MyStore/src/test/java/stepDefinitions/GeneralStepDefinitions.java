package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.BaseStepDefinitions;
import framework.CucumberTestBase;

public class GeneralStepDefinitions extends BaseStepDefinitions{
	@Before
	public void beforeScenario() throws Throwable {
		BaseStepDefinitions.cucumberTestBase = CucumberTestBase.getInstance();
		cucumberTestBase.beforeCucumberScenario();
		BaseStepDefinitions.webDriver = cucumberTestBase.getWebDriver();
		BaseStepDefinitions.baseUrl = cucumberTestBase.getBaseUrl();
	}
	
	@After
	public void afterScenario() throws Throwable {
		cucumberTestBase.afterCucumberScenario();
	}
}
